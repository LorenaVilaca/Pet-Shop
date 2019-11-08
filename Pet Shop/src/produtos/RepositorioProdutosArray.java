package produtos;

public class RepositorioProdutosArray implements RepositorioProduto {
	private Produtos[] produtos;
	int indice = 0;
	
	@Override
	public void inserir(Produtos produto) {
		produtos[indice] = produto;
		indice++;
	}

	@Override
	public Produtos procurar(String codeProduto) {
		Produtos p = null;
		boolean find = false;
		for(int i=0; i<produtos.length && !find; i++) {
			if (produtos[i].getCode().equals(codeProduto)) {
				find = true;
				p = produtos[i];
			} else {
				p = null;
			}
		}
		return p;
	}

	@Override
	public void remover(String codeProduto) {
		boolean removido = false;
		for (int i=0; i<produtos.length && !removido; i++) {
			if (produtos[i].getCode().equals(codeProduto)) {
				produtos[i] = null;
				removido = true;
			}
		}
	}

	@Override
	public boolean existe(String codeProduto) {
		boolean existe = false;
		for (int i=0; i<produtos.length && !existe;i++) {
			if (produtos[i].getCode().equals(codeProduto)) {
				existe = true;
			}
		}
		return existe;
	}

	@Override
	public void atualizarPreco(String codeProduto, double price) {
		boolean atualizado = false;
		for (int i=0; i<produtos.length && !atualizado;i++) {
			if (produtos[i].getCode().equals(codeProduto)) {
				produtos[i].setPrice(price);
				atualizado = true;
			}
		}
	}

	@Override
	public void atualizarQuantidade(String codeProduto, int quantidade) {
		boolean atualizado = false;
		for (int i=0; i<produtos.length && !atualizado;i++) {
			if (produtos[i].getCode().equals(codeProduto)) {
				produtos[i].setQuantidade(quantidade);
				atualizado = true;
			}
		}
	}

	@Override
	public void atualizarFornecedor(String codeProduto, String fornecedor) {
		boolean atualizado = false;
		for (int i=0; i<produtos.length && !atualizado;i++) {
			if (produtos[i].getCode().equals(codeProduto)) {
				produtos[i].setFornecedor(fornecedor);
				atualizado = true;
			}
		}
	}

}
