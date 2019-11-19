package venda;
import clientes.Clientes;
import funcionarios.Funcionarios;
import produtos.Produtos;
import servicos.Servicos;

public class testeVendaLista {

	public static void main(String[] args) throws VendaNaoEncontradaException {
		// TODO Auto-generated method stub
		RepositorioVendasLista repoTeste = new RepositorioVendasLista();
		Funcionarios funcionario = new Funcionarios ("facebookson", "321", "987", "pipi", 8000);
		Clientes cliente = new Clientes("maminha", "123", "789");
		Produtos produto = new Produtos("coleira", "2", 25, 2, "pet happy");
		Servicos servico = new Servicos("pau de 25cm de nadia", "25", 2500);
		Vendas venda = new Vendas (funcionario, cliente, produto, servico, 2.5, 1);
		Vendas novaVenda = new Vendas (funcionario, cliente, produto, servico, 70, 3);
		repoTeste.inserir(venda);
		repoTeste.inserir(novaVenda);
		Vendas novaVenda2 = new Vendas (funcionario, cliente, produto, servico, 50, 3);
		repoTeste.atualizar(novaVenda2);
		System.out.println(repoTeste.existe(novaVenda2.getId()));
		System.out.println(repoTeste.procurar(novaVenda2.getId()));
		System.out.println(repoTeste.procurar(venda.getId()));
	}

}
