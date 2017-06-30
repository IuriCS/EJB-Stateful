package br.com.k19.sessionbeans;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
public class CarrinhoBean {

	private Set<String> produtos;

	public CarrinhoBean() {
		this.produtos = new HashSet<>();
	}

	@PostConstruct
	public void init(){
		System.out.println("Mai um carrinho criado...");
	}

	@PreDestroy
	public void destroy(){
		System.out.println("Mais um carrinho destruído...");
	}

	@PrePassivate
	public void passived(){
		System.out.println("Carrinho entrando em passivação...");
	}

	@PostActivate
	public  void  ativando () {
		System.out.println("Mais um  carrinho  foi  ativado ...");
	}

	@Remove //DESTROI A INSTÂNCIA 
	public void finalizarCompra(){
		//IMPLEMENTAÇÃO
	}


	public boolean add(final String produto){
		if(!this.produtos.contains(produto))
			return this.produtos.add(produto);
		else
			return false;
	}

	public boolean remove(final String produto){
		return this.produtos.remove(produto);
	}

	public Set<String> getProdutos() {
		return produtos;
	}



}
