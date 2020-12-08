package com.example.juiceFruit.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.juiceFruit.exeption.EntidadeNaoEncontradaException;
import com.example.juiceFruit.mode.Produto;
import com.example.juiceFruit.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService{
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	@Transactional
	public Produto salvar(Produto produto) {
		return this.produtoRepository.save(produto);
	}

	@Override
	public List<Produto> listarProdutos() {
		return this.produtoRepository.findAll();
	}

	@Override
	@Transactional
	public void remover(Produto produto) {
		this.produtoRepository.delete(produto);
		
	}

	@Override
	public Produto buscarPorId(int idProduto) {
		Optional<Produto> produto = this.produtoRepository.findById(idProduto);
		if(produto.get()==null) {
			throw new EntidadeNaoEncontradaException("Não foi possível localizar o produto pesquisado!");
		} else
		return produto.get();
	}

}