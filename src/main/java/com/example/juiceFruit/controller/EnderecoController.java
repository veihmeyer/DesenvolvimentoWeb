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

import com.example.juiceFruit.mode.Endereco;
import com.example.juiceFruit.service.EnderecoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/endereco/api")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	
	@PostMapping("/v1")
	public Endereco Salvar1(@RequestBody Endereco endereco) {
		this.enderecoService.salvar(endereco);
		return endereco;
	}

	@GetMapping("/v1")
	public List<Endereco> Listar1(){
		return this.enderecoService.listarEnderecos();
	}

	@DeleteMapping("/v1/{id}")
	public String remover1(@PathVariable("id") Integer id) {
		this.enderecoService.remover(this.enderecoService.buscarPorId(id));
		return "Endereço informado deletado com sucesso!";
	}

	@PutMapping("/v1/{id}")
	public Endereco editar1(@PathVariable("id") Integer id, @RequestBody Endereco endereco) {
		Endereco enderecoBD = this.enderecoService.buscarPorId(id);
		BeanUtils.copyProperties(endereco, enderecoBD, "id");
		this.enderecoService.salvar(enderecoBD);
		return enderecoBD;
	}

	@ApiOperation(
			value = "Cadastrar endereço:",
			response = ResponseEntity.class,
			notes = "Essa operação salva um resgistro de endereço.")
	@PostMapping("/v2")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Endereco> Salvar2(@RequestBody Endereco endereco) {
	return ResponseEntity.ok().body(this.enderecoService.salvar(endereco));
	}
	
	@ApiOperation(
			value = "Listar endereços:",
			response = ResponseEntity.class,
			notes = "Essa operação lista todos os resgistros de endereço.")
	@GetMapping("/v2")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<Endereco>> Listar2(){
		return ResponseEntity.ok().body(this.enderecoService.listarEnderecos());
	}
	
	@ApiOperation(
			value = "Deletar endereço:",
			response = ResponseEntity.class,
			notes = "Essa operação deleta um resgistro de endereço.")
	@DeleteMapping("/v2/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public String remover2(@PathVariable("id") Integer id) {
		this.enderecoService.remover(this.enderecoService.buscarPorId(id));
		return "Endereço informado deletado com sucesso!";
	}
	
	@ApiOperation(
			value = "Editar endereço:",
			response = ResponseEntity.class,
			notes = "Essa operação deleta um resgistro de endereço.")
	@PutMapping("/v2/{id}")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Endereco> editar2(@PathVariable("id") Integer id, @RequestBody Endereco endereco) {
		Endereco enderecoBD = this.enderecoService.buscarPorId(id);
		BeanUtils.copyProperties(endereco, enderecoBD, "id");
		return ResponseEntity.ok().body(this.enderecoService.salvar(enderecoBD));
		}

}

