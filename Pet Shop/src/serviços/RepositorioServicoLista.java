package serviços;

public class RepositorioServicoLista implements RepositorioServicos {
	private Servicos servico;
	private RepositorioServicoLista proximo;

	public RepositorioServicoLista () {
		this.servico = null;
		this.proximo = null;
	}
	public void inserir (Servicos serviço) {
		if (this.servico == null) {
			this.servico = serviço;
			this.proximo = new RepositorioServicoLista();
			return;
		}
		this.proximo.inserir(serviço);
	}
	
	public void remover(String codigo) {
		if (this.servico != null && this.servico.getCodigo().equals(codigo)) {
			this.servico = this.proximo.servico;
			this.proximo = this.proximo.proximo;
		}
		else {
			this.proximo.procurar(codigo);
		}

	}
	public void atualizar(Servicos serviço) {
		if (this.servico != null && this.servico.getCodigo().equals(serviço.getCodigo())) {
			this.servico.setNome(serviço.getNome());
			this.servico.setPreco(serviço.getPreco());
		}
		else {
			this.proximo.atualizar(serviço);
		}
	}

	public Servicos procurar(String codigo) {
		if (this.servico != null && this.servico.getCodigo().equals(codigo)) {
			return this.servico;
		}
		else if (this.servico == null) {
			return null;
		}
		else {
			return this.proximo.procurar(codigo);
		}

	}
	public boolean existe(String codigo) {
		if (this.servico != null && this.servico.getCodigo().equals(codigo)) {
			return true;
		}
		else if (this.servico == null) {
			return false;
		}
		else {
			return this.proximo.existe(codigo);
		}
	}

}
