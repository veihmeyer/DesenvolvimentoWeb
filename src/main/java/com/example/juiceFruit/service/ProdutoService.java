package com.example.juiceFruit.service;

import java.util.List;

import com.example.juiceFruit.mode.Produto;

public interface ProdutoService {
	
	Produto salvar(Produto produto);
	List<Produto> listarProdutos();
	void remover(Produto produto);
	Produto buscarPorId(int idProduto);

}
