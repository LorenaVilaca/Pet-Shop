package Venda;

public class RepositorioVendaArray implements RepositorioVenda {
       private Venda repositorio [] = new Venda [40];

	@Override
	public void inserir(Venda venda) {
		// TODO Auto-generated method stub
		//inicializando
		if (venda == null) {
			
		}
	}

	@Override
	public void remover(String cpf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procurar(String cpf) {
		// TODO Auto-generated method stub
		Venda v = null;
		boolean achou = false;
		for (int i = 0; i < 40 && !achou; i++) {
			v = repositorio [i];
			if (venda.cpf)
		}
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
