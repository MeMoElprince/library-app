package com.example.library.repository;

import com.example.library.model.BorrowRecord;
import com.example.library.model.Book;
import com.example.library.model.Patron;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Integer> {
	BorrowRecord findById(Long id);
    
    List<BorrowRecord> findByPatronAndBookAndReturnDateIsNull(Patron patron, Book book);
}
