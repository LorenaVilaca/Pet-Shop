package funcionarios;

public class CadastroFuncionarios {
	private RepositorioFuncionarios repositorio;

	public CadastroFuncionarios (RepositorioFuncionarios repo) {
		this.repositorio = repo;
	}

	public void cadastrar (Funcionarios funcionario, String codigo, double salario) 
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
			throws FuncionarioNaoEncontradoException {
		this.repositorio.atualizarSalario(salario);
	}

	public void remover (String codigo) 
			throws FuncionarioNaoEncontradoException {
		this.repositorio.removerFuncionarios(codigo);
	}

	public Funcionarios procurar (String codigo) 
			throws FuncionarioNaoEncontradoException {
		return this.repositorio.procurarFuncionarios(codigo);
	}

	public boolean existe (String codigo) 
			throws FuncionarioNaoEncontradoException {
		return this.repositorio.existeFuncionario(codigo);
	}
}
