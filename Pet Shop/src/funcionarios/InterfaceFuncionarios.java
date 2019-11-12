package funcionarios;


public interface InterfaceFuncionarios {
	public void inserirFuncionarios(funcionarios funcionario);
	
	public void removerFuncionarios(funcionarios funcionario);
	
	public funcionarios procurarFuncionarios(int codigo);
	
	public boolean existeFuncionario(int codigo);
	
	public void atualizarSalario(double salario);

}
