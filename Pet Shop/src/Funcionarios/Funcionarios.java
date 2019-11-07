package Funcionarios;

public class Funcionarios{
	public class Funcionario{
		private int codigo;
		private double salario;
		
		//public Funcionarios(String nome, String cpf, String telefone, int codigo, double salario){
		//	super(nome, cpf, telefone);
		//	this.codigo = codigo;
		//  this.salario = salario;
		public int getCodigo() {
			return codigo;
		}
		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}
		public double getSalario() {
			return salario;
		}
		public void setSalario(double salario) {
			this.salario = salario;
		}

	}
}
