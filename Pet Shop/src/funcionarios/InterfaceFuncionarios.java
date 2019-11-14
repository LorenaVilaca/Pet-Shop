package funcionarios;


public interface InterfaceFuncionarios {
	public void inserirFuncionarios(Funcionarios funcionario, String codigo, double salario) 
			throws LimiteAtingidoException;
		
	public void removerFuncionarios(String codigo) 
			throws FuncionarioNaoEncontradoException;
	
	public Funcionarios procurarFuncionarios(String codigo) 
			throws FuncionarioNaoEncontradoException;
	
	public boolean existeFuncionario(String codigo) 
			throws FuncionarioNaoEncontradoException;
	
	public void atualizarSalario(double salario) 
			throws FuncionarioNaoEncontradoException;
	
	public void adicionarBonus(double salario, double desconto);

}