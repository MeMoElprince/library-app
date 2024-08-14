package com.example.library.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void addBook(Book book) {
        // Add book to the database
        if(book.getTitle() == null || book.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if(book.getAuthor() == null || book.getAuthor().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be empty");
        }
        if(book.getIsbn() == null || book.getIsbn().isEmpty()) {
            throw new IllegalArgumentException("ISBN cannot be empty");
        }
        if(book.getIsbn().length() != 13) {
            throw new IllegalArgumentException("ISBN must be 13 characters long");
        }
        bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void updateBook(Book book, Long id) {
        // Update book in the database
        Book existingBook = bookRepository.findById(id);
        if(existingBook == null) {
            throw new IllegalArgumentException("Book not found");
        }
        if(book.getTitle() == null || book.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if(book.getAuthor() == null || book.getAuthor().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be empty");
        }
        if(book.getIsbn() == null || book.getIsbn().isEmpty()) {
            throw new IllegalArgumentException("ISBN cannot be empty");
        }
        if(book.getIsbn().length() != 13) {
            throw new IllegalArgumentException("ISBN must be 13 characters long");
        }
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setIsbn(book.getIsbn());
        bookRepository.save(existingBook);
    }

    public Book getBook(Long id) {
        return bookRepository.findById(id);
    }

    public void deleteBook(Long id) {
        // Delete book from the database
        Book existingBook = bookRepository.findById(id);
        if(existingBook == null) {
            throw new IllegalArgumentException("Book not found");
        }
        bookRepository.delete(existingBook);
    }

}
