package produtos;

public interface RepositorioProduto {
	void inserir(Produtos produto) throws LimiteProdutosAtingidoException, ProdutoJaCadastradoException;
	Produtos procurar(String codeProduto) throws ProdutoNaoEncontradoException;
	void remover(String codeProduto) throws ProdutoNaoEncontradoException;
	boolean existe(String codeProduto) throws ProdutoNaoEncontradoException;
	void atualizarProduto(Produtos produto) throws ProdutoNaoEncontradoException;
}
