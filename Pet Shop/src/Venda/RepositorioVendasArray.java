package Venda;

public class RepositorioVendasArray implements RepositorioVendas {
       
	   private Vendas [] arrayVendas;
       private int indice;
       
       public RepositorioVendasArray () {
    	   this.arrayVendas = new Vendas [999];
    	   this.indice = 0;
       }
       
	@Override
	public void remover(int id) 
			throws VendaNaoEncontradaException {
		int a = this.getIndice(id);
		if (this.arrayVendas.length - 1 - a >= 0) {
			//ocupando a posicao removida
            System.arraycopy(arrayVendas, a + 1, 
            		this.arrayVendas, a, this.arrayVendas.length - 1 - a);
        }
        this.arrayVendas[this.arrayVendas.length - 1] = null;
        this.indice = this.indice - 1;
    }
	
	@Override
	//inserindo novas vendas
	public void inserir(Vendas venda) 
			throws LimiteAtingidoException {	
		if (this.indice < this.arrayVendas.length) {
			this.arrayVendas[indice] = venda;
			indice++;
		} else {
			//indice > 999
			LimiteAtingidoException e;
			e = new LimiteAtingidoException();
			throw e;
		}
	}
	
	@Override
	public Vendas procurar(int id) 
			throws VendaNaoEncontradaException {
		Vendas retorno2 = null;
        boolean achou2 = false;
        for (int i = 0; i < this.indice && !achou2; i++) {
            if (this.arrayVendas[i].getId() == id) {
                retorno2 = this.arrayVendas[i];
                achou2 = true;
            }
        }
        if(achou2) {
            return retorno2;
        } else {
            VendaNaoEncontradaException e;
            e = new VendaNaoEncontradaException();
            throw e;
        }
    }
	
	@Override
	public boolean existe(int id) {
		boolean achou3 = false;
		for (int i = 0; i < this.indice && !achou3; i++) {
			if (this.arrayVendas[i].getId() == id) achou3 = true;
		}
		return achou3;
	}
	@Override
	public void atualizar(Vendas venda) 
			throws VendaNaoEncontradaException {
		int b = this.getIndice(venda.getId());
		arrayVendas [b] = venda;
	}

	public int getIndice(int id) 
			throws VendaNaoEncontradaException {
		int retorno = 0;
        boolean achou = false;
        for (int i = 0; i < this.indice && !achou; i++) {
            if (this.arrayVendas[i].getId() == id) {
                retorno = i;
                achou = true;
            }
        }
        if (achou) {
            return retorno;
        } else {
            VendaNaoEncontradaException e;
            e = new VendaNaoEncontradaException();
            throw e;
        }
	}
}
