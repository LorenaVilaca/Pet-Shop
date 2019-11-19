package venda;
public interface RepositorioVendas {
       public void remover (int id)
               throws VendaNaoEncontradaException;
       public void inserir (Vendas venda) 
    		   throws LimiteAtingidoException, VendaJaCadastradaException;
       public int procurar (int id)
    		   throws VendaNaoEncontradaException;
       public boolean existe (int id);
       public void atualizar (Vendas venda)
               throws VendaNaoEncontradaException;
}
