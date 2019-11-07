package Venda;
public interface RepositorioVenda {
       public void cadastrar (Venda venda);
       public void remover (int id);
       public Venda procurar (int id);
       public boolean existe (int id);
       public void atualizar (Venda venda);
}
