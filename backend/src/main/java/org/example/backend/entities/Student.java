package org.example.backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor @Getter @Setter @ToString @Builder
public class Student {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    @Column(unique = true)
    private String code;
    private String programId;
    private String photo;
}
