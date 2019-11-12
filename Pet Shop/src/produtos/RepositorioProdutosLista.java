package produtos;

public class RepositorioProdutosLista implements RepositorioProduto{
	private Produtos produto;
	private RepositorioProdutosLista next;
	
	public RepositorioProdutosLista() {
		this.produto=null;
		this.next=null;
	}
	
	@Override
	public void inserir(Produtos produto) {
		if (this.produto==null) {
			this.produto = produto;
			this.next = new RepositorioProdutosLista();
		} else {
			this.next.inserir(produto);
		}
	}

	@Override
	public Produtos procurar(String codeProduto) {
		Produtos p = null;
		if (this.produto!=null&&this.produto.getCode().equals(codeProduto)) {
			p = this.produto;
		} else if (this.produto==null) {
			p = null;
		} else {
			this.next.procurar(codeProduto);
		}
		return p;
	}

	@Override
	public void remover(String codeProduto) {
		
	}

	@Override
	public boolean existe(String codeProduto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void atualizarProduto(Produtos produto) {
		// TODO Auto-generated method stub
		
	}

}
