package com.example.juiceFruit.exeption;

public class EntidadeComDependenciasException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public EntidadeComDependenciasException(String mensagem) {
		super(mensagem);
	}
}