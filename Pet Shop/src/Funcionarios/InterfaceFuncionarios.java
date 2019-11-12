package funcionarios;


public interface InterfaceFuncionarios {
	public void inserirFuncionarios(Funcionarios funcionario);
	
	public void removerFuncionarios(Funcionarios funcionario);
	
	public Funcionarios procurarFuncionarios(int codigo);
	
	public boolean existeFuncionario(int codigo);
	
	public void atualizarSalario(double salario);

}
