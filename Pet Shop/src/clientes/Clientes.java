package clientes;

import pessoa.PessoaAbstract;

public class Clientes extends PessoaAbstract {
	
	private double credito;

	public Clientes (String nome, String cpf, String telefone) { 
		super (nome,cpf,telefone);
		this.credito = 0;	
	}

	public void gerarbonus(double valor) {
		this.credito = valor * 0.02;
	}


	public double getCredito() {
		return credito;
	}

	public void setCredito(double credito) {
		this.credito = credito;
	}
	
}
