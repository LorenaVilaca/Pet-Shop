package serviços;

public class RepositorioServicoArray implements RepositorioServicos {
	private Servicos [] arrayServiço;
	private int indice;
	
	public RepositorioServicoArray() {
		this.arrayServiço = new Servicos [100];
		this.indice = 0;
	}
	
	public void inserir(Servicos serviço) {
		if (this.indice < this.arrayServiço.length) {
			this.arrayServiço [indice] = serviço;
			indice ++;
		}
		else {
			//gerar erro
		}
	}
	
	public void remover(String codigo) {
		for (int i = 0; i < 100; i ++) {
			if (this.arrayServiço[i].getCodigo().equals(codigo)) {
				this.arrayServiço[i] = null;
				System.arraycopy(arrayServiço, i + 1, this.arrayServiço, i, this.arrayServiço.length - 1 - i);
				return;
			}
		}
	}

	public void atualizar(Servicos serviço) {
		for (int i = 0; i < 100; i ++) {
			if(this.arrayServiço[i].getCodigo().equals(serviço.getCodigo())) {
				this.arrayServiço[i].setNome(serviço.getNome());
				this.arrayServiço[i].setPreco(serviço.getPreco());
				return;
			}
		}
	}

	public Servicos procurar(String codigo) {
		for (int i = 0; i < 100; i ++) {
			if (this.arrayServiço[i].getCodigo().equals(codigo)) {
				return this.arrayServiço [i];
			}
		}
		return null;
	}

	public boolean existe(String codigo) {
		for (int i = 0; i < 100; i ++) {
			if (this.arrayServiço[i].getCodigo().equals(codigo)) {
				return true;
			}
		}
		return false;
	}
}
