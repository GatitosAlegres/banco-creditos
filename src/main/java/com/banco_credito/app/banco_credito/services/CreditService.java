package com.banco_credito.app.banco_credito.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco_credito.app.banco_credito.entity.Credit;
import com.banco_credito.app.banco_credito.respository.CreditRepository;

@Service
public class CreditService {
    private final CreditRepository creditRepository;

    @Autowired
    public CreditService(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }

    public Credit createCredit(Credit credit) {
        return creditRepository.save(credit);
    }

    public List<Credit> getAllCredits() {
        return creditRepository.findAll();
    }

    public Optional<Credit> getCreditById(Long id) {
        return creditRepository.findById(id);
    }

    public Credit updateCredit(Long id, Credit updatedCredit) {
        if (creditRepository.existsById(id)) {
            updatedCredit.setId(id);
            return creditRepository.save(updatedCredit);
        } else {
            // Manejar el caso de que el crédito no exista, por ejemplo, lanzar una
            // excepción.
            throw new RuntimeException("El crédito con ID " + id + " no existe.");
        }
    }

    public void deleteCredit(Long id) {
        creditRepository.deleteById(id);
    }
}
