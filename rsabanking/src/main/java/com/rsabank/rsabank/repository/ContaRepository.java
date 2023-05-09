package com.rsabank.rsabank.repository;

import com.rsabank.rsabank.model.Conta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends CrudRepository<Conta,Long> {
    Conta findContaById(Long id);
}