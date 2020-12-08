package com.example.juiceFruit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.juiceFruit.exeption.EntidadeComDependenciasException;
import com.example.juiceFruit.mode.Cliente;
import com.example.juiceFruit.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	@Transactional
	public Cliente salvar(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	@Override
	public List<Cliente> listaClientes() {
		return this.clienteRepository.findAll();
	}

	@Override
	@Transactional
	public void remover(Cliente cliente) {
		if(!cliente.getProdutos().isEmpty()) {
			throw new EntidadeComDependenciasException("Erro...Cliente não pode ser removido, pois tem produtos associados!");
		} else
		this.clienteRepository.delete(cliente);
	
	}

	@Override
	public Cliente buscarPorId(int idCliente) {
		return this.clienteRepository.findById(idCliente).get();
	}

}