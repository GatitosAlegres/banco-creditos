package com.banco_credito.app.banco_credito.controllers;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banco_credito.app.banco_credito.entity.Credit;
import com.banco_credito.app.banco_credito.services.CreditService;

@RestController
@RequestMapping("/credits")
@RequiredArgsConstructor
public class CreditController {
    private final CreditService creditService;

    @PostMapping
    public Credit createCredit(@RequestBody Credit credit) {
        return creditService.createCredit(credit);
    }

    @GetMapping
    public List<Credit> getAllCredits() {
        return creditService.getAllCredits();
    }

    @GetMapping("/{id}")
    public Optional<Credit> getCreditById(@PathVariable Long id) {
        return creditService.getCreditById(id);
    }

    @PutMapping("/{id}")
    public Credit updateCredit(@PathVariable Long id, @RequestBody Credit credit) {
        return creditService.updateCredit(id, credit);
    }

    @DeleteMapping("/{id}")
    public void deleteCredit(@PathVariable Long id) {
        creditService.deleteCredit(id);
    }
}
