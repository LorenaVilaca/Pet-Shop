	package funcionarios;

public class RepositorioFuncionariosArray implements RepositorioFuncionarios {

	private Funcionarios[] arrayFuncionario;
	private int indice;

	public RepositorioFuncionariosArray() {
		this.arrayFuncionario = new Funcionarios[200];
		this.indice = 0;
	}

	public void inserirFuncionarios(Funcionarios funcionario) 
			throws LimiteFuncionariosAtingidoException {
		if (this.indice < this.arrayFuncionario.length) {
			this.arrayFuncionario[this.indice] = funcionario;
			this.indice += 1;
		} else {
			LimiteFuncionariosAtingidoException e = new LimiteFuncionariosAtingidoException();
			throw e;
		}
	}
	public void removerFuncionarios(String codigo) 
			throws FuncionarioNaoEncontradoException {
		boolean achou=false;
		for (int i = 0; i < arrayFuncionario.length; i ++) {
			if (this.arrayFuncionario[i].getCodigo().equals(codigo)) {
				this.arrayFuncionario[i] = null;
				System.arraycopy(arrayFuncionario, i + 1, this.arrayFuncionario, i, this.arrayFuncionario.length - 1 - i);
				this.indice --;
				achou = true;
				return;
			}
		}
		if (!achou) {
			FuncionarioNaoEncontradoException e = new FuncionarioNaoEncontradoException();
			throw e;
		}
	}
	public Funcionarios procurarFuncionarios(String codigo) 
			throws FuncionarioNaoEncontradoException {
		Funcionarios resposta = null;
		boolean achou = false;
		for (int i=0; i<this.indice && !achou ; i++) {
			if(this.arrayFuncionario[i].getCodigo().equals(codigo)) {
				resposta = this.arrayFuncionario[i];
				achou = true;
			}
		}
		if (achou) {
			return resposta;
		} else {
			FuncionarioNaoEncontradoException e = new FuncionarioNaoEncontradoException();
			throw e;
		}
	}

	public boolean existeFuncionario(String codigo) {
		boolean achou = false;
		for (int i=0; i<this.indice && !achou; i++) {
			if (this.arrayFuncionario[i].getCodigo().equals(codigo))
				achou = true;
		}
		return achou;
	}

	public void atualizarFuncionarios(Funcionarios funcionario) 
			throws FuncionarioNaoEncontradoException {
		boolean achou = false;
		for (int i=0; i<this.indice && !achou; i++) {
			if (this.arrayFuncionario[i].getCodigo().equals(funcionario.getCodigo())) {
				this.arrayFuncionario[i] = funcionario;
				achou = true;
				return;
			}
		}
		if (!achou) {
			FuncionarioNaoEncontradoException e = new FuncionarioNaoEncontradoException();
			throw e;
		}

	}

	public void gerarBonus(Funcionarios funcionario, double valor) 
			throws FuncionarioNaoEncontradoException {
		boolean achou = false;
		for (int i=0; i<this.indice && !achou; i++) {
			if (this.arrayFuncionario[i].getCodigo().equals(funcionario.getCodigo())) {
				this.arrayFuncionario[i].gerarbonus(valor);
				achou = true;
				return;
			}
		}
		if (!achou) {
			FuncionarioNaoEncontradoException e = new FuncionarioNaoEncontradoException();
			throw e;
		}

	}
}