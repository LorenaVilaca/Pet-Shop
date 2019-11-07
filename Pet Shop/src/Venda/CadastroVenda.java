package Venda;
public class CadastroVenda {
	private RepositorioVenda repositorio;
       public CadastroVenda (RepositorioVenda repo) {
    	   repositorio = repo;
       }
       
       public void cadastar (Venda venda) {
    	   if (!this.repositorio.existe(venda.getId())) {
    		   this.repositorio.inserir(venda);
    		   venda.setId(venda.getId()) += 1; 
    	   }
    		   
    	   }
       public void atualizar (Venda venda) throws VendaNaoEncontradaException {
    	   this.repositorio.atualizar(venda);
       }
       public void remover (int id) throws VendaNaoEncontradaException {
    	   this.repositorio.remover(id);
       }
       public Venda procurar (int id) throws VendaNaoEncontradaException {
		return this.repositorio.procurar(id);	   
       }
       public boolean existe (int id) {
		return this.repositorio.existe(id);
    	   
       }
}
