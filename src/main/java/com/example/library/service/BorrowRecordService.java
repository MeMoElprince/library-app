package com.example.library.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.library.model.BorrowRecord;
import com.example.library.model.Patron;
import com.example.library.model.Book;

import com.example.library.repository.BookRepository;
import com.example.library.repository.PatronRepository;
import com.example.library.repository.BorrowRecordRepository;

@Service
public class BorrowRecordService {
    @Autowired
    private BorrowRecordRepository borrowRecordRepository;
   
    @Autowired
    private BookRepository bookRepository;
    
    @Autowired 
    private PatronRepository patronRepository;
    
    public void borrowBook(Long bookId, Long patronId) {
        // Borrow book
        System.out.println("---------------------------\n");
        System.out.println(bookId + " - " + patronId);
        Book book = bookRepository.findById(bookId);
        Patron patron = patronRepository.findById(patronId);
        System.out.println("---------------------------\n\n");
        if(book == null) {
            throw new IllegalArgumentException("Book not found");
        }
        if(patron == null) {
            throw new IllegalArgumentException("Patron not found");
        }
        if(book.isBorrowed()) {
            throw new IllegalArgumentException("Book is already borrowed");
        }
        BorrowRecord borrowRecord = new BorrowRecord();
        borrowRecord.setBook(book);
        borrowRecord.setPatron(patron);
        borrowRecordRepository.save(borrowRecord);
        book.setStatus(false);
        bookRepository.save(book);
    }
    public void returnBook(Long bookId, Long patronId) {
        Book book = bookRepository.findById(bookId);
        Patron patron = patronRepository.findById(patronId);
        if(book == null) {
            throw new IllegalArgumentException("Book not found");
        }
        if(patron == null) {
            throw new IllegalArgumentException("Patron not found");
        }
        if(!book.isBorrowed()) {
            throw new IllegalArgumentException("Book is not borrowed");
        }   
        List<BorrowRecord> existingBorrowRecord = borrowRecordRepository.findByPatronAndBookAndReturnDateIsNull(patron, book);
        if(existingBorrowRecord.isEmpty())
        {
            throw new IllegalArgumentException("Book hasn't been borrowd by this patron");
        }
        if(existingBorrowRecord.size() > 1)
        {
            throw new IllegalArgumentException("Database is inconsistant");
        }
        BorrowRecord borrowRecord = existingBorrowRecord.get(0);
        borrowRecord.setReturnDate(LocalDate.now());
        // Save the updated borrow record
        borrowRecordRepository.save(borrowRecord);
        // Update the book status if needed (assuming there's a method for that)
        book.setStatus(true);
        bookRepository.save(book);
    }


}

