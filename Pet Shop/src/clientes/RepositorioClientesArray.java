package clientes;

public class RepositorioClientesArray implements RepositorioClientes {

	private Clientes[] arrayCliente;
	private int indice;

	public RepositorioClientesArray() {
		this.arrayCliente = new Clientes[500];
		this.indice = 0;
	}

	public Clientes procurar(String cpf) throws ClienteNaoEncontradoException {
		Clientes retorno = null;
        for (int i = 0; i < this.indice && retorno == null; i++) {
            if (this.arrayCliente[i].getCpf().contentEquals(cpf)){
                retorno = this.arrayCliente[i];
            }
        }
        if (retorno != null){
            return retorno;
        }else {
            ClienteNaoEncontradoException e;
            e = new ClienteNaoEncontradoException();
            throw e;
        }
	}

	public void inserir(Clientes cliente) throws LimiteClientesAtingidoException{
		if (this.indice < this.arrayCliente.length){
            this.arrayCliente[this.indice] = cliente;
            this.indice = this.indice + 1;
        }else{
            LimiteClientesAtingidoException e;
            e = new LimiteClientesAtingidoException();
            throw e;
        }
	}

	public void remover(String cpf) {
		for (int i = 0; i < 100; i ++) {
			if (this.arrayCliente[i].getCpf().equals(cpf)) {
				this.arrayCliente[i] = null;
				System.arraycopy(arrayCliente, i + 1, this.arrayCliente, i, this.arrayCliente.length - 1 - i);
				this.indice --;
				return;
			}
		}
	}

	public void atualizar(Clientes cliente) {
		for (int i = 0; i < 100; i ++) {
			if(this.arrayCliente[i].getCpf().equals(cliente.getCpf())) {
				this.arrayCliente[i].setNome(cliente.getNome());
				this.arrayCliente[i].setCpf(cliente.getCpf());
				this.arrayCliente[i].setTelefone(cliente.getTelefone());
				return;
			}
		}
	}
	
	public boolean existe(String cpf) {
		for (int i = 0; i < 100; i ++) {
			if (this.arrayCliente[i].getCpf().equals(cpf)) {
				return true;
			}
		}
		return false;
	}

}
