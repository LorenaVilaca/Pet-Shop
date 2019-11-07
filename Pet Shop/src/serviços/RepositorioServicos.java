package serviços;

public interface RepositorioServicos {
	public void inserir (Servicos servico);
	public void remover (String codigo);
	public void atualizar (Servicos servico);
	public Servicos procurar (String codigo);
	public boolean existe (String codigo);
}
