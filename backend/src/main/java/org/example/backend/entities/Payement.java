package org.example.backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@NoArgsConstructor @Getter @Setter @Builder @ToString
public class Payement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private double amount;
    private PayementType type;
    private PayementStatus method;
    private String file ;
    @ManyToOne
    private Student student;
}