package com.example.juiceFruit.exeption;


public class EntidadeNaoEncontradaException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public EntidadeNaoEncontradaException(String mensagem) {
		super(mensagem);
	}

}