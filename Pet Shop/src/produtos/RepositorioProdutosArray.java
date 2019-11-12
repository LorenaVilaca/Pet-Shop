package produtos;

public class RepositorioProdutosArray implements RepositorioProduto {
	private Produtos[] arrayProdutos;
	private int indice;

	public RepositorioProdutosArray() {
		this.arrayProdutos = new Produtos [100];
		this.indice = 0;
	}
	
	@Override
	public void inserir(Produtos produto) throws ProdutoJaCadastradoException{ 
		boolean inserido = false;
		boolean jainserido = false;
		for(int i=0;i<this.arrayProdutos.length && !inserido && !jainserido; i++) {
			if (this.arrayProdutos[i].getCode().equals(produto.getCode())) {
				jainserido = true;
			} else if               °
		}

	}

	@Override
	public Produtos procurar(String codeProduto) {
		Produtos p = null;
		boolean find = false;
		for(int i=0; i<this.arrayProdutos.length && !find; i++) {
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
		for (int i=0; i<this.arrayProdutos.length && !removido; i++) {
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
		for (int i=0; i<this.arrayProdutos.length && !existe;i++) {
			if (this.arrayProdutos[i].getCode().equals(codeProduto)) {
				existe = true;
			}
		}
		return existe;
	}
	
	@Override
	public void atualizarProduto(Produtos produto) {
		boolean atualizado = false;
		for (int i=0; i<this.arrayProdutos.length && !atualizado;i++) {
			if (this.arrayProdutos[i].getCode().equals(produto.getCode())) {
				atualizado = true;
				this.arrayProdutos[i]=produto;
			}
		}
	}


}
