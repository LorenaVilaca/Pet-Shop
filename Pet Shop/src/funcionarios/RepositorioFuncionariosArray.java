package funcionarios;

public class RepositorioFuncionariosArray implements InterfaceFuncionarios{
	private funcionarios[] arrayFuncionario;
	private int indice;

	public RepositorioFuncionariosArray() {
		this.arrayFuncionario = new funcionarios[200];
		this.indice = 0;
	}

	public void inserirFuncionarios(funcionarios funcionario) {
		if (this.indice < this.arrayFuncionario.length) {
			this.arrayFuncionario[this.indice] = funcionario;
			this.indice += 1;
		}
	}
	public void removerFuncionarios(funcionarios funcionario) {
		
	}
	public funcionarios procurarFuncionarios(int codigo) {
		funcionarios resposta = null;
		boolean achou = false;
		for (int i=0; i<this.indice && !achou ; i++) {
			if(this.arrayFuncionario[i].getCodigo()==codigo) {
				resposta = this.arrayFuncionario[i];
				achou = true;
			}
		}
		return resposta;
	}
	
	public boolean existeFuncionario(int codigo) {
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
