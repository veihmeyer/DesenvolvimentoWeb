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

import com.example.juiceFruit.mode.Fornecedor;
import com.example.juiceFruit.service.FornecedorService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/fornecedores/api")
public class FornecedorController {
	
	@Autowired
	private FornecedorService fornecedorService;
	
	
	@PostMapping("/v1")
	public Fornecedor Salvar1(@RequestBody Fornecedor fornecedor) {
		this.fornecedorService.salvar(fornecedor);
		return fornecedor;
	}
	
	@GetMapping("/v1")
	public List<Fornecedor> Listar1(){
		return this.fornecedorService.listarFornecedores();
	}
	
	@DeleteMapping("/v1/{id}")
	public String Remover1(@PathVariable("id") Integer id) {
		this.fornecedorService.remover(this.fornecedorService.buscarPorId(id));
		return "Fornecedor informado deletado com sucesso!";
	}
	
	@PutMapping("/v1/{id}")
	public Fornecedor Editar1(@PathVariable("id") Integer id, @RequestBody Fornecedor fornecedor) {
		Fornecedor fornecedorBD = this.fornecedorService.buscarPorId(id);
		BeanUtils.copyProperties(fornecedor, fornecedorBD, "id");
		this.fornecedorService.salvar(fornecedorBD);
		return fornecedorBD;
	}

	@ApiOperation(
			value = "Salvar fornecedor:",
			response = ResponseEntity.class,
			notes = "Essa operação salva um registro de fornecedor.")
	@PostMapping("/v2")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Fornecedor> Salvar2(@RequestBody Fornecedor fornecedor) {
		return ResponseEntity.ok().body(this.fornecedorService.salvar(fornecedor));
	}

	@ApiOperation(
			value = "Listar endereços:",
			response = ResponseEntity.class,
			notes = "Essa operação lista todo os registros de fornecedor.")
	@GetMapping("/v2")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<Fornecedor>> Listar2(){
		return ResponseEntity.ok().body(fornecedorService.listarFornecedores());
	}

	@ApiOperation(
			value = "Deletar fornecedor:",
			response = ResponseEntity.class,
			notes = "Essa operação deleta um registro de fornecedor.")
	@DeleteMapping("/v2/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public String Remover2(@PathVariable("id") Integer id) {
		this.fornecedorService.remover(this.fornecedorService.buscarPorId(id));
		return "Fornecedor informado deletado com sucesso!";
	}
	
	@ApiOperation(
			value = "Editar fornecedor:",
			response = ResponseEntity.class,
			notes = "Essa operação edita um resgistro de fornecedor.")
	@PutMapping("/v2/{id}")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Fornecedor> Editar2(@PathVariable("id") Integer id, @RequestBody Fornecedor fornecedor) {
		Fornecedor fornecedorBD = this.fornecedorService.buscarPorId(id);
		BeanUtils.copyProperties(fornecedor, fornecedorBD, "id");
		return ResponseEntity.ok().body(this.fornecedorService.salvar(fornecedorBD));
	}
	
}
