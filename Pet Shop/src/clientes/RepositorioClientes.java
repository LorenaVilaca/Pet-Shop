package clientes;

import funcionarios.FuncionarioNaoEncontradoException;
import funcionarios.Funcionarios;

public interface RepositorioClientes {
	
	public void inserir(Clientes cliente) throws LimiteClientesAtingidoException;

	public void remover(String codigo) throws ClienteNaoEncontradoException;

	public void atualizar(Clientes cliente) throws ClienteNaoEncontradoException;

	public Clientes procurar(String codigo) throws ClienteNaoEncontradoException;

	public boolean existe(String cpf);
	
	public void gerarBonus (Clientes cliente, double valor) throws ClienteNaoEncontradoException;

}

