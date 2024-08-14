package com.example.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.model.Patron;
import com.example.library.repository.PatronRepository;

@Service
public class PatronService {
 
    @Autowired
    private PatronRepository patronRepository;

    public List<Patron> getAllPatrons() {
        return patronRepository.findAll();
    }

    public Patron getPatron(Long id) {
        return patronRepository.findById(id);
    }

    public void addPatron(Patron patron) {
        // Add patron to the database
        if(patron.getName() == null || patron.getName().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if(patron.getEmail() == null || patron.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        if(patron.getPhoneNumber() == null || patron.getPhoneNumber().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be empty");
        }
        patronRepository.save(patron);
    }

    public void updatePatron(Patron patron, Long id) {
        // Update patron in the database
        Patron existingPatron = patronRepository.findById(id);
        if(existingPatron == null) {
            throw new IllegalArgumentException("Patron not found");
        }
        if(patron.getName() == null || patron.getName().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if(patron.getEmail() == null || patron.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        if(patron.getPhoneNumber() == null || patron.getPhoneNumber().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be empty");
        }
        existingPatron.setName(patron.getName());
        existingPatron.setEmail(patron.getEmail());
        existingPatron.setPhoneNumber(patron.getPhoneNumber());
        patronRepository.save(existingPatron);
    }


    public void deletePatron(Long id) {
        // Delete patron from the database
        Patron existingPatron = patronRepository.findById(id);
        if(existingPatron == null) {
            throw new IllegalArgumentException("Patron not found");
        }
        patronRepository.delete(existingPatron);
    }
}
