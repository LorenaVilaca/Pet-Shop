package Funcionarios;

import Venda.PessoaAbstract;

public class Funcionarios extends PessoaAbstract{
	public Funcionarios(String nome, String cpf, String telefone, String codigo, double salario) {
		super(nome, cpf, telefone);
	}
	private String codigo;
	private double salario;
	
	public String getCodigo() {
		return this.codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public double desconto() {
		
		return 0;
	}
}