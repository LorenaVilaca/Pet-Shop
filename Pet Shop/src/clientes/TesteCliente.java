package clientes;

public class TesteCliente {
	public static void main (String[] args) throws ClienteNaoEncontradoException, ClienteJaCadastradoException, LimiteClientesAtingidoException {
		RepositorioClientes repoTeste = new RepositorioClientesLista();
		Clientes cliente = new Clientes ("thais", "95488", "99686660");
		repoTeste.inserir(cliente);
		Clientes novoCliente = new Clientes ("debora", "45472", "995672000");
		repoTeste.inserir(novoCliente);
		Clientes novoCliente2 = new Clientes ("nathalia", "74899", "999942444");
		repoTeste.inserir(novoCliente2);
		System.out.println(repoTeste.existe(novoCliente2.getCpf()));
		System.out.println(repoTeste.procurar(novoCliente2.getCpf()));
		System.out.println(repoTeste.procurar(novoCliente.getCpf()));
		System.out.println(repoTeste.procurar(cliente.getCpf()));
		repoTeste.remover("74899");
		System.out.println(repoTeste.existe(novoCliente2.getCpf()));
		Clientes novoCliente3 = new Clientes ("elinete", "45472", "998752022");
		repoTeste.atualizar(novoCliente3);
		System.out.println(repoTeste.existe(novoCliente2.getCpf()));
		System.out.println(repoTeste.procurar(novoCliente3.getCpf()));
	}
}//

