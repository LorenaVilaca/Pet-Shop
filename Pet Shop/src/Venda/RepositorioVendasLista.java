package Venda;
public class RepositorioVendasLista implements RepositorioVendas  {
	
	private Vendas venda;
	private RepositorioVendasLista proximo;

	@Override
	public void remover(int id) 
			throws VendaNaoEncontradaException {
		Vendas encontrado = this.procurar(id);
		if (this.venda != null) {
			if (this.venda.equals(encontrado)) {
				this.venda = this.proximo.venda;
				this.proximo = this.proximo.proximo;
			} else this.proximo.remover(id);
		} else {
			VendaNaoEncontradaException v;
			v = new VendaNaoEncontradaException();
			throw v;
		}
	}
	
	@Override
	public void inserir(Vendas venda) {
		//inicializando
		if (this.venda == null) {
			this.venda = venda;
			this.proximo = new RepositorioVendasLista();
		} else this.proximo.inserir(venda);
	}

	@Override
	public Vendas procurar (int id) 
			throws VendaNaoEncontradaException {
		Vendas retorno; retorno = null;
		if (this.venda != null) {
			if (this.venda.getId() == id) retorno = this.venda;
			else retorno = this.proximo.procurar(id);
		} else {
			VendaNaoEncontradaException v;
			v = new VendaNaoEncontradaException();
			throw v;
		}
		return retorno;
	}

	@Override
	public boolean existe(int id) {
		if (this.venda != null) {
			if (this.venda.getId() == id) {
				return true;
			} else return this.proximo.existe(id);
		} else return false;
	}

	@Override
	public void atualizar(Vendas venda) 
			throws VendaNaoEncontradaException {
       Vendas vendaAntiga = procurar(venda.getId());
       this.remover(vendaAntiga.getId());
       this.inserir(venda);
	}
}
