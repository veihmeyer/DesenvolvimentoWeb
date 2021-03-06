package com.example.juiceFruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.juiceFruit.mode.Fornecedor;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer>{

}
