package com.example.juiceFruit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.juiceFruit.mode.Fornecedor;
import com.example.juiceFruit.repository.FornecedorRepository;

@Service
public class FornecedorServiceImpl implements FornecedorService{

	@Autowired
	private FornecedorRepository fornecedorRepository;

	@Override
	@Transactional
	public Fornecedor salvar(Fornecedor fornecedor) {
		return this.fornecedorRepository.save(fornecedor);
	}

	@Override
	public List<Fornecedor> listarFornecedores() {
		return this.fornecedorRepository.findAll();
	}

	@Override
	@Transactional
	public void remover(Fornecedor fornecedor) {
		this.fornecedorRepository.delete(fornecedor);
		
	}

	@Override
	public Fornecedor buscarPorId(int idFornecedor) {
		return this.fornecedorRepository.findById(idFornecedor).get();
	}

}

