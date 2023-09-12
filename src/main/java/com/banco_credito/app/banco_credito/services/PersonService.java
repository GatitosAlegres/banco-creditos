package com.banco_credito.app.banco_credito.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco_credito.app.banco_credito.entity.Person;
import com.banco_credito.app.banco_credito.respository.PersonRepository;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    public Person updatePerson(Long id, Person updatedPerson) {
        if (personRepository.existsById(id)) {
            updatedPerson.setId(id);
            return personRepository.save(updatedPerson);
        } else {
            // Manejar el caso de que la persona no exista, por ejemplo, lanzar una
            // excepción.
            throw new RuntimeException("La persona con ID " + id + " no existe.");
        }
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}