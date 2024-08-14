package com.example.library.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;



@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    @NotBlank(message = "A book should have a title")
    private String title;

    @NotBlank(message = "A book should have an author")
    private String author;

    @NotNull(message = "A book should have a publication year")
    private LocalDate publicationYear;

    @Column(unique = true)
    @NotBlank(message = "A book should have an isbn")
    private String isbn; 

    @OneToMany(mappedBy = "book")
    private List<BorrowRecord> borrowRecords;

    private Boolean status = true;

    public Boolean isBorrowed() {
        return !status;
    }

}
