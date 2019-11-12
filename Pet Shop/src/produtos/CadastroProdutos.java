package produtos;

public class CadastroProdutos {
	private RepositorioProduto repositorio;
	public CadastroProdutos(RepositorioProduto repositorio) {
		this.repositorio = repositorio;
	}

	public void cadastrar(Produtos produto) { //produto ja cadastrado kutxlut
		if(!this.repositorio.existe(produto.getCode())) {
			this.repositorio.inserir(produto);
		}
	}

	public void atualizarPreco(String code, double price) {
		this.repositorio.atualizarPreco(code, price);
	}

	public void atualizarQuantidade(String code, int quantidade) {
		this.repositorio.atualizarQuantidade(code, quantidade);
	}
	public void atualizarFornecedor(String code, String fornecedor) {
		this.repositorio.atualizarFornecedor(code, fornecedor);
	}
	public void remover(String codeProduto) {
		this.repositorio.remover(codeProduto);
	}

	public Produtos procurar(String codeProduto) {
		return this.repositorio.procurar(codeProduto);
	}
	
	public boolean existe(String codeProduto) {
		return this.repositorio.existe(codeProduto);
	}
	
}

