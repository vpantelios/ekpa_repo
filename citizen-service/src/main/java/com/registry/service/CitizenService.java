
package com.registry.service;

import com.registry.model.Citizen;
import com.registry.repository.CitizenRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitizenService {

    private final CitizenRepository repository;

    public CitizenService(CitizenRepository repository) {
        this.repository = repository;
    }

    public Citizen createCitizen(Citizen citizen) {
        if (repository.existsById(citizen.getAt())) {
            throw new IllegalArgumentException("Ο πολίτης υπάρχει ήδη.");
        }
        return repository.save(citizen);
    }

    public void deleteCitizen(String at) {
        if (!repository.existsById(at)) {
            throw new IllegalArgumentException("Δεν βρέθηκε πολίτης με ΑΤ: " + at);
        }
        repository.deleteById(at);
    }

    public Citizen updateCitizen(String at, String afm, String address) {
        Optional<Citizen> optionalCitizen = repository.findById(at);
        if (optionalCitizen.isEmpty()) {
            throw new IllegalArgumentException("Ο πολίτης δεν υπάρχει.");
        }

        Citizen citizen = optionalCitizen.get();

        if (afm != null && afm.matches("\\d{9}")) {
            citizen.setAfm(afm);
        } else if (afm != null) {
            throw new IllegalArgumentException("Μη έγκυρο ΑΦΜ.");
        }

        citizen.setAddress(address);
        return repository.save(citizen);
    }

    public List<Citizen> findAll() {
        return repository.findAll();
    }

    public Optional<Citizen> findById(String at) {
        return repository.findById(at);
    }
}
