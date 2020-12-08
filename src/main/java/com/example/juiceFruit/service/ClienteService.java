package com.example.juiceFruit.service;

import java.util.List;

import com.example.juiceFruit.mode.Cliente;

public interface ClienteService {
	
	Cliente salvar(Cliente cliente);
	List<Cliente> listaClientes();
	void remover(Cliente cliente);
	Cliente buscarPorId(int idCliente);


}
