package com.example.juiceFruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.juiceFruit.mode.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
