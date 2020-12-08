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

import com.example.juiceFruit.mode.Produto;
import com.example.juiceFruit.service.ProdutoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/produtos/api")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	
	@PostMapping("/v1")
	public Produto Salvar1(@RequestBody Produto produto) {
		this.produtoService.salvar(produto);
		return produto;
	}
	
	@GetMapping("/v1")
	public List<Produto> Listar1(){
		return this.produtoService.listarProdutos();
	}
	
	@DeleteMapping("/v1/{id}")
	public String Remover1(@PathVariable("id") Integer id) {
		this.produtoService.remover(this.produtoService.buscarPorId(id));
		return "Produto informado deletado com sucesso!";
	}
	
 	@PutMapping("/v1/{id}")
	public Produto editar1(@PathVariable("id") Integer id, @RequestBody Produto produto) {
		Produto produtoBD = this.produtoService.buscarPorId(id);
		BeanUtils.copyProperties(produto, produtoBD, "id");
		this.produtoService.salvar(produtoBD);
		return produtoBD;
	}

	@ApiOperation(
			value = "Salvar produto:",
			response = ResponseEntity.class,
			notes = "Essa operação salva um registro de produto.")
	@PostMapping("/v2")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Produto> Salvar2(@RequestBody Produto produto) {
		return ResponseEntity.ok().body(this.produtoService.salvar(produto));
	}
	
	@ApiOperation(
			value = "Listar produto:",
			response = ResponseEntity.class,
			notes = "Essa operação lista todos os registros de produto.")
	@GetMapping("/v2")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<Produto>> Listar2(){
		return ResponseEntity.ok().body(this.produtoService.listarProdutos());
	}
	
	@ApiOperation(
			value = "Deletar produto:",
			response = ResponseEntity.class,
			notes = "Essa operação deleta um registro de produto.")
	@DeleteMapping("/v2/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public String Remover2(@PathVariable("id") Integer id) {
		this.produtoService.remover(this.produtoService.buscarPorId(id));
		return "Produto informado deletado com sucesso!";
	}

	@ApiOperation(
			value = "Editar produto:",
			response = ResponseEntity.class,
			notes = "Essa operação edita um registro de produto.")
 	@PutMapping("/v2/{id}")
 	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Produto> editar2(@PathVariable("id") Integer id, @RequestBody Produto produto) {
		Produto produtoBD = this.produtoService.buscarPorId(id);
		BeanUtils.copyProperties(produto, produtoBD, "id");
		return ResponseEntity.ok().body(this.produtoService.salvar(produtoBD));
	}
	
}

