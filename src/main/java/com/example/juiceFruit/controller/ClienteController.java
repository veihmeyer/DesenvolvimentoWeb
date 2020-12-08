package com.example.juiceFruit.controller;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.juiceFruit.mode.Cliente;
import com.example.juiceFruit.service.ClienteService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/clientes/api")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	
	 @PostMapping("/v1") 
	 public Cliente salvar1(@RequestBody Cliente cliente) {
	 this.clienteService.salvar(cliente); 
	 return cliente;		 
	
}			 
	  
	  @GetMapping("/v1") public List<Cliente> listar1(){ return
	  this.clienteService.listaClientes(); }
	  
	  @DeleteMapping("/v1/{id}") public String remover1(@PathVariable("id") Integer
	  id) { this.clienteService.remover(this.clienteService.buscarPorId(id));
	  return "Cliente informado deletado com sucesso!"; }
	  
	  @PutMapping("/v1/{id}") public Cliente editar1(@PathVariable("id") Integer
	  id, @RequestBody Cliente cliente) { Cliente clienteBD =
	  this.clienteService.buscarPorId(id); BeanUtils.copyProperties(cliente,
	  clienteBD, "id"); this.clienteService.salvar(clienteBD); return clienteBD; }
	 

	@ApiOperation(value = "Cadastrar cliente:", response = ResponseEntity.class, notes = "Essa operação salva um registro de cliente.")
	@PostMapping("/v2")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Cliente> salvar2(@RequestBody Cliente cliente) {
		return ResponseEntity.ok().body(this.clienteService.salvar(cliente));
	}

	@ApiOperation(value = "Listar clientes:", response = ResponseEntity.class, notes = "Essa operação lista todos os registros de cliente.")
	@GetMapping("/v2")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<Cliente>> listar2() {
		return ResponseEntity.ok().body(this.clienteService.listaClientes());
	}

	@ApiOperation(value = "Deletar cliente:", response = ResponseEntity.class, notes = "Essa operação deleta um registro de cliente.")
	@DeleteMapping("/v2/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public String remover2(@PathVariable("id") Integer id) {
		this.clienteService.remover(this.clienteService.buscarPorId(id));
		return "Cliente informado deletado com sucesso!";
	}

	@ApiOperation(value = "Editar cliente:", response = ResponseEntity.class, notes = "Essa operação edita um registro de cliente.")
	@PutMapping("/v2/{id}")
	public ResponseEntity<Cliente> editar2(@PathVariable("id") Integer id, @RequestBody Cliente cliente) {
		Cliente clienteBD = this.clienteService.buscarPorId(id);
		BeanUtils.copyProperties(cliente, clienteBD, "id");
		return ResponseEntity.ok().body(this.clienteService.salvar(clienteBD));
	}

}
