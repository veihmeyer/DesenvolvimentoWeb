package com.example.juiceFruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.juiceFruit.mode.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}

