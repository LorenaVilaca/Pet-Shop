package produtos;

public class CadastroProdutos {
	private RepositorioProduto repositorio;
	public CadastroProdutos(RepositorioProduto repositorio) {
		this.repositorio = repositorio;
	}

	public void cadastrar(Produtos produto) throws LimiteProdutosAtingidoException, ProdutoNaoEncontradoException, ProdutoJaCadastradoException{ 
		if(!this.repositorio.existe(produto.getCode())) {
			this.repositorio.inserir(produto);
		}
	}

	public void atualizarProduto (Produtos produto) throws ProdutoNaoEncontradoException { //produto nao encontrado
		this.repositorio.atualizarProduto(produto);
	}
	public void remover(String codeProduto) throws ProdutoNaoEncontradoException { //produto nao encontrado 
		this.repositorio.remover(codeProduto);
	}

	public Produtos procurar(String codeProduto)throws ProdutoNaoEncontradoException { //produto na encontrado
		return this.repositorio.procurar(codeProduto);
	}
	
	public boolean existe(String codeProduto) throws ProdutoNaoEncontradoException { //produto nao encontrado
		return this.repositorio.existe(codeProduto);
	}
	
}

