package clientes;

public class RepositorioClientesLista implements RepositorioClientes {

	private Clientes cliente;
	private RepositorioClientesLista proximo;

	public RepositorioClientesLista() {
		this.cliente = null;
		this.proximo = null;
	}

	public void inserir(Clientes cliente) {
		if (this.cliente == null) {
			this.cliente = cliente;
			this.proximo = new RepositorioClientesLista();
		} else {
			this.proximo.inserir(cliente);
		}
	}

	public void remover(String codigo) {
		if (this.cliente != null && this.cliente.getCpf().equals(codigo)) {
			this.cliente = this.proximo.cliente;
			this.proximo = this.proximo.proximo;
		} else {
			this.proximo.procurar(codigo);
		}

	}

	public void atualizar(Clientes cliente) {
		if (this.cliente != null && this.cliente.getCpf().equals(cliente.getCpf())) {
			this.cliente.setNome(cliente.getNome());
			this.cliente.setCpf(cliente.getCpf());
			this.cliente.setTelefone(cliente.getTelefone());
		} else {
			this.proximo.atualizar(cliente);
		}
	}

	public Clientes procurar(String cpf) {
		if (this.cliente != null && this.cliente.getCpf().equals(cpf)) {
			return this.cliente;
		} else if (this.cliente == null) {
			return null;
		} else {
			return this.proximo.procurar(cpf);
		}

	}
	
	public boolean existe(String cpf) {
		if (this.cliente != null && this.cliente.getCpf().equals(cpf)) {
			return true;
		} else if (this.cliente == null) {
			return false;
		} else {
			return this.proximo.existe(cpf);
		}
	}

}
