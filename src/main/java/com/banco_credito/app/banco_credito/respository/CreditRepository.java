package com.banco_credito.app.banco_credito.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banco_credito.app.banco_credito.entity.Credit;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {

}