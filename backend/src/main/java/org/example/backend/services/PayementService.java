package org.example.backend.services;

import jakarta.transaction.Transactional;
import org.example.backend.entities.Payement;
import org.example.backend.entities.PayementStatus;
import org.example.backend.entities.PayementType;
import org.example.backend.entities.Student;
import org.example.backend.repository.PayementRepository;
import org.example.backend.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.UUID;

@Service
@Transactional
public class PayementService {
    private PayementRepository payementRepository;
    private StudentRepository studentRepository;

    public PayementService(PayementRepository payementRepository, StudentRepository studentRepository) {
        this.payementRepository = payementRepository;
        this.studentRepository = studentRepository;
    }
    public Payement savePayement(MultipartFile file, LocalDate date, double amount, PayementType type, String StudentCode) throws IOException {
        Path folderPath = Paths.get("C:/Users/PC/Desktop/uploads");
        if(!Files.exists(folderPath)){
            try {
                Files.createDirectories(folderPath);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        String fileName = UUID.randomUUID().toString();
        Path filePath = Paths.get("C:/Users/PC/Desktop/uploads/"+fileName+".pdf");
        Files.copy(file.getInputStream(),filePath);
        Student student = studentRepository.findByCode(StudentCode);
        Payement payement = Payement.builder()
                .date(date)
                .amount(amount)
                .type(type)
                .status(PayementStatus.CREATED)
                .file(filePath.toUri().toString())
                .student(student)
                .build();
        return payementRepository.save(payement);
    }
    public Payement updatePayementStatus(  PayementStatus status , Long id){
        Payement payement = payementRepository.findById(id).get();
        payement.setStatus(status);
        return payementRepository.save(payement);
    }
    public byte[] getPayementFile( Long id) throws IOException {
        Payement payement = payementRepository.findById(id).get();
        return Files.readAllBytes(Path.of(URI.create(payement.getFile())));
    }


}
