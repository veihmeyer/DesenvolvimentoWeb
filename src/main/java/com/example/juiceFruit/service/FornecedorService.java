package com.example.juiceFruit.service;

import java.util.List;

import com.example.juiceFruit.mode.Fornecedor;

public interface FornecedorService {

	Fornecedor salvar(Fornecedor fornecedor);
	List<Fornecedor> listarFornecedores();
	void remover(Fornecedor fornecedor);
	Fornecedor buscarPorId(int idFornecedor);
}
