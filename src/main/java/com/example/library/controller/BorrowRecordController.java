package com.example.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.service.BorrowRecordService;

@RestController
@RequestMapping("/api")
public class BorrowRecordController {
    
    @Autowired
    private BorrowRecordService borrowRecordService;


    @PostMapping("/borrow/{bookId}/patron/{patronId}")
    public ResponseEntity<String> borrowBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        borrowRecordService.borrowBook(bookId, patronId);
        return ResponseEntity.ok("Book borrowed successfully");
    }


    @PutMapping("/return/{bookId}/patron/{patronId}")
    public ResponseEntity<String> returnBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        borrowRecordService.returnBook(bookId, patronId);
        return ResponseEntity.ok("Book returned successfully");
    }


}
