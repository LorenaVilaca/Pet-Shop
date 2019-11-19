package programa;
import java.util.Scanner;
import fachada.*;
import clientes.*;
import funcionarios.*;
import produtos.*;
import servicos.*;
import venda.*;
public class main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		Clientes objCliente;
		Funcionarios objFuncionarios;
		Produtos objProdutos;
		Servicos objServicos;
		Vendas objVendas;
		
		RepositorioClientes repoClientesLista = new RepositorioClientesLista();
	    RepositorioClientes repoClientesArray = new RepositorioClientesArray();
	    RepositorioFuncionarios repoFuncionariosLista = new RepositorioFuncionariosLista();
	    RepositorioFuncionarios repoFuncionariosArray = new RepositorioFuncionariosArray();
	    RepositorioProduto repoProdutosLista = new RepositorioProdutosLista();
	    RepositorioProduto repoProdutosArray = new RepositorioProdutosArray();
		RepositorioServicos repoServicosLista = new RepositorioServicoLista();
		RepositorioServicos repoServicosArray = new RepositorioServicoArray();
		RepositorioVendas repoVendasLista = new RepositorioVendasLista();
		RepositorioVendas repoVendasArray = new RepositorioVendasArray();
		
	    PetShop petlista = new PetShop (repoClientesLista, repoFuncionariosLista, 
	    		repoProdutosLista, repoServicosLista, repoVendasLista);
	    PetShop petarray = new PetShop(repoClientesArray, repoFuncionariosArray, repoProdutosArray,
	    		repoServicosArray, repoVendasArray);
		
		System.out.println("Digite um numero correspondente a fun��o que deseja alterar:\n "
				+ "1 - FUNCIONARIOS\n"
				+ " 2 - CLIENTES\n"
				+ " 3 - PRODUTOS\n"
				+ " 4 - SERVICOS\n"
				+ " 5 - VENDAS");

		//FUNCIONARIOS
		if (in.nextInt() == 1) {
			System.out.println("Selecione como deseja alterar FUNCIONARIOS:\n"
					+ " 1 - Cadastrar\n"
					+ " 2 - Procurar\n"
					+ " 3 - Remover\n"
					+ " 4 - Atualizar\n");

			//CADASTRAR FUNCIONARIO
			if (in.nextInt() == 1) {
				
			}

			//PROCURAR FUNCIONARIO 
			if (in.nextInt() == 2) {
				
			}

			//REMOVER FUNCIONARIO
			if (in.nextInt() == 3) {

			}

			//ATUALIZAR FUNIONARIO
			if (in.nextInt() == 4) {

			}
		} 

		//CLIENTES
		if (in.nextInt() == 2) {
			System.out.println("Selecione como deseja alterar CLIENTES:\n"
					+ " 1 - Cadastrar\n"
					+ " 2 - Procurar\n"
					+ " 3 - Remover\n"
					+ " 4 - Atualizar\n");
			
			//CADASTRAR CLIENTES
			if (in.nextInt() == 1) {
				
			}

			//PROCURAR CLIENTES 
			if (in.nextInt() == 2) {
				
			}

			//REMOVER CLIENTES
			if (in.nextInt() == 3) {

			}

			//ATUALIZAR CLIENTES
			if (in.nextInt() == 4) {

			}
		}

		//PRODUTOS
		if (in.nextInt() == 3) {
			System.out.println("Selecione como deseja alterar PRODUTOS:\n"
					+ " 1 - Cadastrar\n"
					+ " 2 - Procurar\n"
					+ " 3 - Remover\n"
					+ " 4 - Atualizar\n");
			
			//CADASTRAR PRODUTOS
			if (in.nextInt() == 1) {
				
			}

			//PROCURAR PRODUTOS 
			if (in.nextInt() == 2) {
				
			}

			//REMOVER PRODUTOS
			if (in.nextInt() == 3) {

			}

			//ATUALIZAR PRODUTOS
			if (in.nextInt() == 4) {

			}
		}

		//SERVICOS
		if (in.nextInt() == 4) {
			System.out.println("Selecione como deseja alterar SERVICOS:\n"
					+ " 1 - Cadastrar\n"
					+ " 2 - Procurar\n"
					+ " 3 - Remover\n"
					+ " 4 - Atualizar\n");
			
			//CADASTRAR FUNCIONARIO
			if (in.nextInt() == 1) {
				
			}

			//PROCURAR FUNCIONARIO 
			if (in.nextInt() == 2) {
				
			}

			//REMOVER FUNCIONARIO
			if (in.nextInt() == 3) {

			}

			//ATUALIZAR FUNIONARIO
			if (in.nextInt() == 4) {

			}
		}

		//VENDAS
		if (in.nextInt() == 5) {
			System.out.println("Selecione como deseja alterar VENDAS:\n"
					+ " 1 - Cadastrar\n"
					+ " 2 - Procurar\n"
					+ " 3 - Remover\n"
					+ " 4 - Atualizar\n");
			
			//CADASTRAR FUNCIONARIO
			if (in.nextInt() == 1) {
				
			}

			//PROCURAR FUNCIONARIO 
			if (in.nextInt() == 2) {
				
			}

			//REMOVER FUNCIONARIO
			if (in.nextInt() == 3) {

			}

			//ATUALIZAR FUNIONARIO
			if (in.nextInt() == 4) {

			}
		}
	}

}
