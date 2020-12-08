package com.example.juiceFruit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.juiceFruit.mode.Endereco;
import com.example.juiceFruit.repository.EnderecoRepository;

@Service
public class EnderecoServiceImpl implements EnderecoService{

	@Autowired
	private EnderecoRepository enderecoRepository;

	
	@Override
	@Transactional
	public Endereco salvar(Endereco endereco) {
		return this.enderecoRepository.save(endereco);
	}

	@Override
	public List<Endereco> listarEnderecos() {
		return this.enderecoRepository.findAll();
	}

	@Override
	public void remover(Endereco endereco) {
		this.enderecoRepository.delete(endereco);
		
	}

	@Override
	public Endereco buscarPorId(int idEndereco) {
		return this.enderecoRepository.findById(idEndereco).get();
	}

}
