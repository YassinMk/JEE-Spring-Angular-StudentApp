package org.example.backend.web;

import org.example.backend.entities.Payement;
import org.example.backend.entities.PayementStatus;
import org.example.backend.entities.PayementType;
import org.example.backend.entities.Student;
import org.example.backend.repository.PayementRepository;
import org.example.backend.repository.StudentRepository;
import org.example.backend.services.PayementService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@RestController
public class PayementRestController {
    private StudentRepository studentRepository;
    private  PayementRepository payementRepository;
    private PayementService payementService;

    public PayementRestController(StudentRepository studentRepository , PayementRepository payementRepository) {
        this.payementRepository = payementRepository;
        this.studentRepository = studentRepository;
        this.payementService = payementService;
    }

    @GetMapping(path = "/payements")
    public List<Payement> allPayements() {
        return payementRepository.findAll();
    }
    @GetMapping(path = "/payements/student/{code}")
    public List<Payement> getPayementByStudent(@PathVariable String code) {
        return payementRepository.findByStudentCode(code);
    }
    @GetMapping(path="/payements/byStatus")
    public List<Payement> getPayementByStatus(@RequestParam PayementStatus status){
        return payementRepository.findByStatus(status);
    }

    @GetMapping(path = "/payements/{id}")
    public Payement getPayement(@PathVariable  Long id) {
        return payementRepository.findById(id).get();
    }
    @GetMapping(path="/payements/byType")
    public List<Payement> getPayementByType(@RequestParam PayementType type){
        return payementRepository.findByType(type);
    }
    @GetMapping(path = "/students")
    public List<Student> getAllStudents(){
        return studentRepository.findAll() ;
    }

    @GetMapping(path="/students/{code}")
    public Student getStudentByCode(@PathVariable String code){
        return studentRepository.findByCode(code);
    }
    @GetMapping(path="/students/program/{programId}")
    public List<Student>  getStudentsByProgramId(@PathVariable String programId){
        return studentRepository.findByProgramId(programId);
    }
    @PutMapping(path = "/payements/{id}")
    public Payement updatePayementStatus(@RequestParam  PayementStatus status ,@PathVariable Long id){
       return this.payementService.updatePayementStatus(status,id);
    }
    @PostMapping(path = "/payements",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Payement savePayement(@RequestParam MultipartFile file, LocalDate date, double amount, PayementType type, String StudentCode) throws IOException {
        return this.payementService.savePayement(file,date,amount,type,StudentCode);
    }

    @GetMapping(path="/payements/files/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] getPayementFile(@PathVariable Long id) throws IOException {
      return this.payementService.getPayementFile(id);
    }

}
