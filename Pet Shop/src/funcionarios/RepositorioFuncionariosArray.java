package funcionarios;

public class RepositorioFuncionariosArray implements RepositorioFuncionarios {
	
	private Funcionarios[] arrayFuncionario;
	private int indice;

	public RepositorioFuncionariosArray() {
		this.arrayFuncionario = new Funcionarios[200];
		this.indice = 0;
	}
	
	public int getIndice (String codigo)
		throws FuncionarioNaoEncontradoException {
		for (int i = 0; i < this.indice; i++) {
            if (arrayFuncionario[i].getCodigo().equals(codigo)) {
                return i;
            }
        }
        throw new FuncionarioNaoEncontradoException();
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
	public void removerFuncionarios(String codigo) 
	throws FuncionarioNaoEncontradoException {
		int index = this.getIndice(codigo);
		if (this.arrayFuncionario.length - 1 - index >=0) {
			System.arraycopy(arrayFuncionario, index+1, this.arrayFuncionario, index, this.arrayFuncionario.length-1-index);
		}
		this.arrayFuncionario[this.arrayFuncionario.length-1] = null;
		this.indice = this.indice - 1;
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
		if (achou) {
			return resposta;
		} else {
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

	public void atualizarSalario(double salario) 
	throws FuncionarioNaoEncontradoException {
		boolean achou = false;
		int i = 0;
		for (i=0; i<this.indice && !achou; i++) {
		}
		
	}
}