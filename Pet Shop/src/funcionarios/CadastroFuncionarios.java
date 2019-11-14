package funcionarios;

public class CadastroFuncionarios {
	private InterfaceFuncionarios repositorio;

	public CadastroFuncionarios (InterfaceFuncionarios repo) {
		this.repositorio = repo;
	}

	public void cadastrarFuncionario (Funcionarios funcionario, String codigo, double salario) 
			throws FuncionarioJaCadastradoException, LimiteAtingidoException, FuncionarioNaoEncontradoException  {
		if(this.repositorio.existeFuncionario(funcionario.getCodigo())) {
			this.repositorio.inserirFuncionarios(funcionario, codigo, salario);
		} else {
			FuncionarioJaCadastradoException e;
			e = new FuncionarioJaCadastradoException();
			throw e;
		}
	}

	public void atualizarSalario (double salario) 
			throws FuncionarioNaoEncontradoException, LimiteAtingidoException {
		this.repositorio.atualizarSalario(salario);
	}

	public void removerFuncionario(String codigo) 
			throws FuncionarioNaoEncontradoException {
		this.repositorio.removerFuncionarios(codigo);
	}

	public Funcionarios procurarFuncionario(String codigo) 
			throws FuncionarioNaoEncontradoException {
		return this.repositorio.procurarFuncionarios(codigo);
	}

	public boolean existeFuncionario(String codigo) 
			throws FuncionarioNaoEncontradoException {
		return this.repositorio.existeFuncionario(codigo);
	}
}
