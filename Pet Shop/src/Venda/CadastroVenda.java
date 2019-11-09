package Venda;
public class CadastroVenda {
	private RepositorioVendas repositorio;
       public CadastroVenda (RepositorioVendas repo) {
    	   repositorio = repo;
       }
       
       public void cadastar (Vendas venda) 
    		   throws LimiteAtingidoException {
    	   //cadastrando qnd não existe a venda com o respectivo id
    	   if (!this.repositorio.existe(venda.getId()))
    		   this.repositorio.inserir(venda);	   
    	   }
       
       public void atualizar (Vendas venda) 
    		   throws VendaNaoEncontradaException {
    	   this.repositorio.atualizar(venda);
       }
       
       public void remover (int id) 
    		   throws VendaNaoEncontradaException {
    	   this.repositorio.remover(id);
       }
       
       public Vendas procurar (int id) 
    		   throws VendaNaoEncontradaException {
		return this.repositorio.procurar(id);	   
       }
       
       public boolean existe (int id) {
		return this.repositorio.existe(id); 	   
       }
}
