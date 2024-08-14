package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import com.example.library.service.PatronService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.model.Patron;

import com.example.library.service.PatronService;

@RestController
@RequestMapping("/api/patrons")
public class PatronController {
    
    @Autowired
    private PatronService patronService;


    @GetMapping("")
    public List<Patron> getAllPatrons() {
        return patronService.getAllPatrons();
    }

    @GetMapping("/{id}")
    public Patron getPatron(@PathVariable Long id) {
        return patronService.getPatron(id);
    }

    @PostMapping("")
    public ResponseEntity<String> addPatron(@RequestBody Patron patron) {
        patronService.addPatron(patron);
        return ResponseEntity.ok("Patron added successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePatron(@RequestBody Patron patron, @PathVariable Long id) {
        patronService.updatePatron(patron, id);
        return ResponseEntity.ok("Patron updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatron(@PathVariable Long id) {
        patronService.deletePatron(id);
        return ResponseEntity.ok("Patron deleted successfully");
    }




}
