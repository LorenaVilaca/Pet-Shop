package funcionarios;

import pessoa.PessoaAbstract;

public class Funcionarios extends PessoaAbstract{
	public Funcionarios(String nome, String cpf, String telefone, String codigo, double salario) {
		super(nome, cpf, telefone);
	}
	private String codigo;
	private double salario;
	
	public String getCodigo() {
		return codigo;
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
	public double bonus () {
		
		return 0;
	}
}
