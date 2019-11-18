package servicos;

public class Teste {

	public static void main(String[] args) throws LimiteServicoAtingidoException, ServicoJaCadastradoException, ServicoNaoEncontradoException {
		RepositorioServicos repoTeste = new RepositorioServicoArray();
		Servicos teste = new Servicos("bla", "1", 10);
		Servicos teste1 = new Servicos("bla1", "2", 20);
		Servicos teste2 = new Servicos("bla2", "3", 30);
		repoTeste.inserir(teste);
		repoTeste.inserir(teste1);
		repoTeste.inserir(teste2);
		System.out.println(repoTeste.existe("1"));
		
	}

}
