package produtos;

public class RepositorioProdutosArray implements RepositorioProduto {
	private Produtos[] arrayProdutos;
	private int indice;
	
	public RepositorioProdutosArray() {
		this.arrayProdutos = new Produtos [100];
		this.indice = 0;
	}
	@Override
	public void inserir(Produtos produto) { //limite atingido
		if(this.indice < this.arrayProdutos.length-1) {
			this.arrayProdutos[this.indice] = produto;
			this.indice++;
		} else {
			//limite atingido
			//throw error
		}
		
	}

	@Override
	public Produtos procurar(String codeProduto) {
		Produtos p = null;
		boolean find = false;
		for(int i=0; i<this.arrayProdutos.length-1 && !find; i++) {
			if (this.arrayProdutos[i].getCode().equals(codeProduto)) {
				find = true;
				p = this.arrayProdutos[i];
			} else {
				p = null;
			}
		}
		return p;
	}

	@Override
	public void remover(String codeProduto) { //pokemon nao encontrad
		boolean removido = false;
		for (int i=0; i<this.arrayProdutos.length-1 && !removido; i++) {
			if (this.arrayProdutos[i].getCode().equals(codeProduto)) {
				this.arrayProdutos[i] = null;
				System.arraycopy(arrayProdutos, i+1, this.arrayProdutos, i, this.arrayProdutos.length -1 -i);				
				removido = true;
			}
		}
	}

	@Override
	public boolean existe(String codeProduto) {
		boolean existe = false;
		for (int i=0; i<this.arrayProdutos.length-1 && !existe;i++) {
			if (this.arrayProdutos[i].getCode().equals(codeProduto)) {
				existe = true;
			}
		}
		return existe;
	}

	@Override
	public void atualizarPreco(String codeProduto, double price) {
		boolean atualizado = false;
		for (int i=0; i<this.arrayProdutos.length-1 && !atualizado;i++) {
			if (this.arrayProdutos[i].getCode().equals(codeProduto)) {
				this.arrayProdutos[i].setPrice(price);
				atualizado = true;
			}
		}
	}

	@Override
	public void atualizarQuantidade(String codeProduto, int quantidade) {
		boolean atualizado = false;
		for (int i=0; i<this.arrayProdutos.length-1 && !atualizado;i++) {
			if (this.arrayProdutos[i].getCode().equals(codeProduto)) {
				this.arrayProdutos[i].setQuantidade(quantidade);
				atualizado = true;
			}
		}
	}

	@Override
	public void atualizarFornecedor(String codeProduto, String fornecedor) {
		boolean atualizado = false;
		for (int i=0; i<this.arrayProdutos.length-1 && !atualizado;i++) {
			if (this.arrayProdutos[i].getCode().equals(codeProduto)) {
				this.arrayProdutos[i].setFornecedor(fornecedor);
				atualizado = true;
			}
		}
	}

}
