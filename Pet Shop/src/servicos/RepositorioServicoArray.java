package servicos;

public class RepositorioServicoArray implements RepositorioServicos {
	private Servicos [] arrayServico;
	private int indice;
	
	public RepositorioServicoArray() {
		this.arrayServico = new Servicos [100];
		this.indice = 0;
	}
	
	public void inserir(Servicos serviço) {
		if (this.indice < this.arrayServico.length) {
			this.arrayServico [indice] = serviço;
			indice ++;
		}
		else {
			//gerar erro
		}
	}
	
	public void remover(String codigo) {
		for (int i = 0; i < 100; i ++) {
			if (this.arrayServico[i].getCodigo().equals(codigo)) {
				this.arrayServico[i] = null;
				System.arraycopy(arrayServico, i + 1, this.arrayServico, i, this.arrayServico.length - 1 - i);
				return;
			}
		}
	}

	public void atualizar(Servicos serviço) {
		for (int i = 0; i < 100; i ++) {
			if(this.arrayServico[i].getCodigo().equals(serviço.getCodigo())) {
				this.arrayServico[i].setNome(serviço.getNome());
				this.arrayServico[i].setPreco(serviço.getPreco());
				return;
			}
		}
	}

	public Servicos procurar(String codigo) {
		for (int i = 0; i < 100; i ++) {
			if (this.arrayServico[i].getCodigo().equals(codigo)) {
				return this.arrayServico [i];
			}
		}
		return null;
	}

	public boolean existe(String codigo) {
		for (int i = 0; i < 100; i ++) {
			if (this.arrayServico[i].getCodigo().equals(codigo)) {
				return true;
			}
		}
		return false;
	}
}
