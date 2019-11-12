package Funcionarios;

public class RepositorioFuncionariosArray implements InterfaceFuncionarios{
	private Funcionarios[] arrayFuncionario;
	private int indice;

	public RepositorioFuncionariosArray() {
		this.arrayFuncionario = new Funcionarios[200];
		this.indice = 0;
	}

	public void inserirFuncionarios(Funcionarios funcionario, String codigo, double salario) 
	throws LimiteAtingidoException {
		if (this.indice < this.arrayFuncionario.length) {
			this.arrayFuncionario[this.indice] = funcionario;
			this.indice += 1;
		} else {
			LimiteAtingidoException e;
			e = new LimiteAtingidoException();
			throw e;
		}
	}
	public void removerFuncionarios(String codigo) {
		
	}
	
	public Funcionarios procurarFuncionarios(String codigo) 
	throws FuncionarioNaoEncontradoException {
		Funcionarios resposta = null;
		boolean achou = false;
		for (int i=0; i<this.indice && !achou ; i++) {
			if(this.arrayFuncionario[i].getCodigo()==codigo) {
				resposta = this.arrayFuncionario[i];
				achou = true;
			}
		}
		if (achou)
		return resposta;
		else {
			FuncionarioNaoEncontradoException e;
			e = new FuncionarioNaoEncontradoException();
			throw e;
		}
		
	}
	
	public boolean existeFuncionario(String codigo) {
		boolean achou = false;
		for (int i=0; i<this.indice && !achou; i++) {
			if (this.arrayFuncionario[i].getCodigo()==codigo)
				achou = true;
		}
		return achou;
	}

	public void atualizarSalario(double salario) {
		
		
	}

}