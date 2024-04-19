package org.example.backend;

import org.example.backend.entities.Payement;
import org.example.backend.entities.PayementStatus;
import org.example.backend.entities.PayementType;
import org.example.backend.entities.Student;
import org.example.backend.repository.PayementRepository;
import org.example.backend.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }
    @Bean
    CommandLineRunner start( StudentRepository studentRepository , PayementRepository payementRepository){
        return args -> {
            studentRepository.save(
                    Student.builder()
                            .id(UUID.randomUUID().toString())
                            .firstname("Mohamed")
                            .lastname("Ali")
                            .code("A1223")
                            .programId("SDIA")
                            .build()
            );
            studentRepository.save(
                    Student.builder()
                            .id(UUID.randomUUID().toString())
                            .firstname("Yasiene")
                            .lastname("Benmoussa")
                            .code("A1224")
                            .programId("GLSID")
                            .build()
            );
            studentRepository.save(
                    Student.builder()
                            .id(UUID.randomUUID().toString())
                            .firstname("maryame")
                            .lastname("saadi")
                            .code("A1225")
                            .programId("BDDC")
                            .build()
            );
            PayementType[] payementTypes = PayementType.values();
            Random random = new Random();
            studentRepository.findAll().forEach(student -> {
                for(int i = 0; i < 10; i++){
                    int index = random.nextInt(payementTypes.length);
                    Payement payement=Payement.builder()
                            .date(LocalDate.now())
                            .amount(100 + random.nextInt(10000))
                            .type(payementTypes[index])
                            .method(PayementStatus.CREATED)
                            .student(student)
                            .build();
                    payementRepository.save(payement);

                }
            });
        };


    }
}
