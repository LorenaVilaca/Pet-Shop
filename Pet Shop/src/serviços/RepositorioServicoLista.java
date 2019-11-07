package serviços;

public class RepositorioServicoLista implements RepositorioServicos {
	private Servicos serviço;
	private RepositorioServicoLista proximo;

	public RepositorioServicoLista () {
		this.serviço = null;
		this.proximo = null;
	}
	public void inserir (Servicos serviço) {
		if (this.serviço == null) {
			this.serviço = serviço;
			this.proximo = new RepositorioServicoLista();
			return;
		}
		this.proximo.inserir(serviço);
	}
	
	public void remover(String codigo) {
		if (this.serviço != null && this.serviço.getCodigo().equals(codigo)) {
			this.serviço = this.proximo.serviço;
			this.proximo = this.proximo.proximo;
		}
		else {
			this.proximo.procurar(codigo);
		}

	}
	public void atualizar(Servicos serviço) {
		if (this.serviço != null && this.serviço.getCodigo().equals(serviço.getCodigo())) {
			this.serviço.setNome(serviço.getNome());
			this.serviço.setPreco(serviço.getPreco());
		}
		else {
			this.proximo.atualizar(serviço);
		}
	}

	public Servicos procurar(String codigo) {
		if (this.serviço != null && this.serviço.getCodigo().equals(codigo)) {
			return this.serviço;
		}
		else if (this.serviço == null) {
			return null;
		}
		else {
			return this.proximo.procurar(codigo);
		}

	}
	public boolean existe(String codigo) {
		if (this.serviço != null && this.serviço.getCodigo().equals(codigo)) {
			return true;
		}
		else if (this.serviço == null) {
			return false;
		}
		else {
			return this.proximo.existe(codigo);
		}
	}

}
