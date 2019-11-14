package funcionarios;

public class RepositorioFuncionariosLista implements InterfaceFuncionarios{
	private Funcionarios funcionario;
	private RepositorioFuncionariosLista proximo;
	private String codigo;
	private double salario;
	public RepositorioFuncionariosLista() {
		this.funcionario=null;
		this.proximo=null;
	}


	public void inserirFuncionarios(Funcionarios funcionario, String codigo, double salario) {
		if(this.funcionario==null) {
			this.funcionario=funcionario;
			this.proximo= new RepositorioFuncionariosLista(); 
		} else
			this.proximo.inserirFuncionarios(funcionario, codigo, salario);
		
	}
	
	public void removerFuncionarios(String codigo) 
	throws FuncionarioNaoEncontradoException {
		Funcionarios funcionarioDemitido = this.procurarFuncionarios(codigo);
		if (this.funcionario!=null && this.funcionario.getCodigo().equals(codigo)) {
			this.funcionario = this.proximo.funcionario;
			this.proximo = this.proximo.proximo;
		} else if (this.proximo!=null)
			this.removerFuncionarios(codigo);
		else {
			FuncionarioNaoEncontradoException e;
			e = new FuncionarioNaoEncontradoException();
			throw e;
		}
	}

	public Funcionarios procurarFuncionarios(String codigo) 
			throws FuncionarioNaoEncontradoException {
		Funcionarios funcionarioProcurado = null;
		if(this.funcionario != null && this.funcionario.getCodigo().equals(codigo))
			funcionarioProcurado=this.funcionario;
		else if (this.proximo!=null)
			funcionarioProcurado=this.procurarFuncionarios(codigo);
		else {
			FuncionarioNaoEncontradoException e;
			e = new FuncionarioNaoEncontradoException();
			throw e;
		}
		
		return funcionarioProcurado;
	}

	public boolean existeFuncionario(String codigo) 
			throws FuncionarioNaoEncontradoException {
		if(this.funcionario!=null && this.funcionario.getCodigo().equals(codigo))
			return true;
		else if (this.proximo!=null)
			return this.proximo.existeFuncionario(codigo);
		else
			return false;
	}

	public void atualizarSalario(double salario) 
			throws FuncionarioNaoEncontradoException{
		Funcionarios salarioAntigo = procurarFuncionarios(funcionario.getCodigo());
		this.removerFuncionarios(salarioAntigo.getCodigo());
		this.inserirFuncionarios(funcionario, funcionario.getCodigo(), salario);
		
		
	}


	@Override
	public void adicionarBonus(double salario, double desconto) {
		// TODO Auto-generated method stub
		
	}
	

}