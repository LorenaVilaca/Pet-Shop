package produtos;

public interface RepositorioProduto {
	void inserir(Produtos produto);
	Produtos procurar(String codeProduto);
	void remover(String codeProduto);
	boolean existe(String codeProduto);
	void atualizarPreco(String codeProduto, double price);
	void atualizarQuantidade(String codeProduto, int quantidade);
	void atualizarFornecedor(String codeProduto, String fornecedor);
}
