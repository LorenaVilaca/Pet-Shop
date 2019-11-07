package servicos;

public class RepositorioServicoLista implements RepositorioServicos {
	private Servicos servico;
	private RepositorioServicoLista proximo;

	public RepositorioServicoLista () {
		this.servico = null;
		this.proximo = null;
	}
	public void inserir (Servicos servico) {
		if (this.servico == null) {
			this.servico = servico;
			this.proximo = new RepositorioServicoLista();
			return;
		}
		this.proximo.inserir(servico);
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
	public void atualizar(Servicos servico) {
		if (this.servico != null && this.servico.getCodigo().equals(servico.getCodigo())) {
			this.servico.setNome(servico.getNome());
			this.servico.setPreco(servico.getPreco());
		}
		else {
			this.proximo.atualizar(servico);
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
