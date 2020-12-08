package com.example.juiceFruit.service;

import java.util.List;

import com.example.juiceFruit.mode.Endereco;

public interface EnderecoService {
	
	Endereco salvar(Endereco endereco);
	List<Endereco> listarEnderecos();
	void remover(Endereco endereco);
	Endereco buscarPorId(int idEndereco);
	

}
