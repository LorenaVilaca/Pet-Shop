package servicos;
public class CadastroServicos {
	private RepositorioServicos servico;
	
	public CadastroServicos (RepositorioServicos servico) {
		this.servico = servico;
	}
	//Conta já cadastrada
	public void cadastrar (Servicos servico) {
		if(!this.servico.existe(servico.getCodigo())) {
			
		}
	}
}
