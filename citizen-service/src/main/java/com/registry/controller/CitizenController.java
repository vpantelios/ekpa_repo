
package com.registry.controller;

import com.registry.model.Citizen;
import com.registry.service.CitizenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citizens")
public class CitizenController {

    private final CitizenService service;

    public CitizenController(CitizenService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Citizen citizen) {
        try {
            return ResponseEntity.ok(service.createCitizen(citizen));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{at}")
    public ResponseEntity<?> delete(@PathVariable String at) {
        try {
            service.deleteCitizen(at);
            return ResponseEntity.ok("Διαγραφή επιτυχής.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{at}")
    public ResponseEntity<?> update(@PathVariable String at,
                                    @RequestParam(required = false) String afm,
                                    @RequestParam(required = false) String address) {
        try {
            return ResponseEntity.ok(service.updateCitizen(at, afm, address));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Citizen>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{at}")
    public ResponseEntity<?> getByAt(@PathVariable String at) {
        return service.findById(at)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().body("Δεν βρέθηκε πολίτης."));
    }
}
