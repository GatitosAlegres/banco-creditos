package com.banco_credito.app.banco_credito.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banco_credito.app.banco_credito.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
