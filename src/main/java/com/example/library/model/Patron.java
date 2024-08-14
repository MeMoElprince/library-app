package com.example.library.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Patron {
    // patrons
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A patron Records should have name")
    private String name;

    @Column(unique = true)
    @NotBlank(message = "A patron Records should have an email")
    private String email;

    @Column(unique = true)
    @NotBlank(message = "A patron Records should have a phone number")
    private String phoneNumber;
    
    @OneToMany(mappedBy = "patron")
    private List<BorrowRecord> borrowRecords;
}
