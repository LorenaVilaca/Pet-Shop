package Venda;
public class RepositorioVendaLista implements RepositorioVenda  {
    private Venda venda;
    private int a;
	@Override
	public void inserir(Venda venda) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(String cpf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procurar(String cpf) {
		// TODO Auto-generated method stub
		
	}

	public Venda getVenda() {
		return venda;
	}
	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	@Override
	public boolean existe(String cfp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void atualizar(String cpf) {
		// TODO Auto-generated method stub
		
	}

}
