package Venda;
public class CadastroVenda {
	private RepositorioVendas repoVendas;
       public CadastroVenda (RepositorioVendas repo) {
    	   this.repoVendas = repo;
       }
       
       public void cadastar (Vendas venda) 
    		   throws LimiteAtingidoException {
    	   //cadastrando qnd não existe a venda com o respectivo id
    	   if (!this.repoVendas.existe(venda.getId()))
    		   this.repoVendas.inserir(venda);	   
    	   }
       
       public void atualizar (Vendas venda) 
    		   throws VendaNaoEncontradaException {
    	   this.repoVendas.atualizar(venda);
       }
       
       public void remover (int id) 
    		   throws VendaNaoEncontradaException {
    	   this.repoVendas.remover(id);
       }
       
       public Vendas procurar (int id) 
    		   throws VendaNaoEncontradaException {
		return this.repoVendas.procurar(id);	   
       }
       
       public boolean existe (int id) {
		return this.repoVendas.existe(id); 	   
       }
}
