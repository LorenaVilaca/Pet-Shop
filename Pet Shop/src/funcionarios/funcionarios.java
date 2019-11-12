package funcionarios;

public class funcionarios {
	private int codigo;
	private double salario;

	//public Funcionarios(String nome, String cpf, String telefone, int codigo, double salario){
	//	super(nome, cpf, telefone);
	//	this.codigo = codigo;
	//  this.salario = salario;
	public int getCodigo() {
		return this.codigo;
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
