package produtos;

public interface RepositorioProduto {
	void inserir(Produtos produto);
	Produtos procurar(String codeProduto);
	void remover(String codeProduto);
	boolean existe(String codeProduto);
	void atualizarProduto(Produtos produto);
}
