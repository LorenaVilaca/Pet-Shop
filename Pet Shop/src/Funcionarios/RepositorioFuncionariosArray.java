package Funcionarios;

public class RepositorioFuncionariosArray implements InterfaceFuncionarios{
	private Funcionarios[] arrayFuncionario;
	private int indice;

	public RepositorioFuncionariosArray() {
		this.arrayFuncionario = new Funcionarios[200];
		this.indice = 0;
	}

	public void inserirFuncionarios(Funcionarios funcionario) {
		if (this.indice < this.arrayFuncionario.length) {
			this.arrayFuncionario[this.indice] = funcionario;
			this.indice += 1;
		}
	}
	public void removerFuncionarios(Funcionarios funcionario) {
		
	}
	public Funcionarios procurarFuncionarios(int codigo) {
		Funcionarios resposta = null;
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
