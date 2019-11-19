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

		RepositorioClientes repoClientes = new RepositorioClientesLista();
		//RepositorioClientes repoClientes = new RepositorioClientesArray();
		RepositorioFuncionarios repoFuncionarios = new RepositorioFuncionariosLista();
		//RepositorioFuncionarios repoFuncionarios = new RepositorioFuncionariosArray();
		RepositorioProduto repoProdutos = new RepositorioProdutosLista();
		//RepositorioProduto repoProdutos = new RepositorioProdutosArray();
		RepositorioServicos repoServicos = new RepositorioServicoLista();
		//RepositorioServicos repoServicos = new RepositorioServicoArray();
		RepositorioVendas repoVendas = new RepositorioVendasLista();
		//RepositorioVendas repoVendas = new RepositorioVendasArray();

		PetShop petshop = new PetShop (repoClientes, repoFuncionarios, 
				repoProdutos, repoServicos, repoVendas);
		//PetShop petshop = new PetShop(repoClientes, repoFuncionarios, repoProdutos,
		//repoServicos, repoVendas);
		int x = 0;
		int p = 0;
		while (p!=6) {
			System.out.println("Digite um numero correspondente a função que deseja alterar:\n "
					+ "(1) - FUNCIONARIOS\n"
					+ " (2) - CLIENTES\n"
					+ " (3) - PRODUTOS\n"
					+ " (4) - SERVICOS\n"
					+ " (5) - VENDAS\n"
					+ " (6) - SAIR");
			p = in.nextInt();

			x = 0;

			//FUNCIONARIOS
			if ( p == 1) {
				while (x!=5) {
					System.out.println("Selecione como deseja alterar FUNCIONARIOS:\n"
							+ " (1) - Cadastrar\n"
							+ " (2) - Procurar\n"
							+ " (3) - Remover\n"
							+ " (4) - Atualizar\n"
							+ " (5) - Voltar");

					x = in.nextInt();
					//CADASTRAR FUNCIONARIO
					if (x == 1) {

					}

					//PROCURAR FUNCIONARIO 
					if (x == 2) {

					}

					//REMOVER FUNCIONARIO
					if (x == 3) {

					}

					//ATUALIZAR FUNIONARIO
					if (x == 4) {

					}
				} 
			}
			//CLIENTES
			if (p == 2) { //fsfsdf
				while(x!=5) {
					System.out.println("Selecione como deseja alterar CLIENTES:\n"
							+ " (1) - Cadastrar\n"
							+ " (2) - Procurar\n"
							+ " (3) - Remover\n"
							+ " (4) - Atualizar\n"
							+ " (5) - Voltar");

					x = in.nextInt();
					//CADASTRAR CLIENTES
					if (x == 1) {

					}

					//PROCURAR CLIENTES 
					if (x == 2) {

					}

					//REMOVER CLIENTES
					if (x == 3) {

					}

					//ATUALIZAR CLIENTES
					if (x == 4) {

					}
				}
			}

			//PRODUTOS
			if (p == 3) {
				while(x!=5) {
					System.out.println("Selecione como deseja alterar PRODUTOS:\n"
							+ " (1) - Cadastrar\n"
							+ " (2) - Procurar\n"
							+ " (3) - Remover\n"
							+ " (4) - Atualizar\n"
							+ " (5) - Voltar");

					x = Integer.parseInt(in.next());
					//CADASTRAR PRODUTOS
					if (x == 1) {
						System.out.println("Para cadastrar o PRODUTOS insira:");
						System.out.println("-Nome do Produto:"); String nomeProduto = in.next();
						System.out.println("-Codigo do Produto:"); String codeProduto = in.next();
						System.out.println("-Preco do Produto:"); double priceProduto = in.nextDouble();
						System.out.println("-Quantidade:"); int quantidadeProduto = in.nextInt();
						System.out.println("-Fornecedor:"); String fornecedorProduto = in.next();
						Produtos produto = new Produtos(nomeProduto, codeProduto, priceProduto, quantidadeProduto, fornecedorProduto);
						 try {
                             petshop.cadastrarProdutos(produto);
                             
                             System.out.println("\n\n------ Produto Cadastrado com Sucesso ------\n\n");
                         } catch (LimiteProdutosAtingidoException | ProdutoJaCadastradoException | ProdutoNaoEncontradoException e) {
                             System.out.println("\n\n----------------- ERRO -----------------\n\n");
                             System.out.println(e.getMessage());
                             System.out.println("\n\n----------------- ERRO -----------------\n\n");
                         }
					}

					//PROCURAR PRODUTOS 
					if (x == 2) {

					}

					//REMOVER PRODUTOS
					if (x == 3) {

					}

					//ATUALIZAR PRODUTOS
					if (x == 4) {

					}
				}
			}

			//SERVICOS
			if (p == 4) {
				while (x!=5) {
					System.out.println("Selecione como deseja alterar SERVICOS:\n"
							+ " (1) - Cadastrar\n"
							+ " (2) - Procurar\n"
							+ " (3) - Remover\n"
							+ " (4) - Atualizar\n"
							+ " (5) - Voltar");
					x = in.nextInt();
					//CADASTRAR FUNCIONARIO
					if (x == 1) {

					}

					//PROCURAR FUNCIONARIO 
					if (x == 2) {

					}

					//REMOVER FUNCIONARIO
					if (x == 3) {

					}

					//ATUALIZAR FUNIONARIO
					if (x == 4) {

					}
				}
			}

			//VENDAS
			if (p == 5) {
				while (x!=5) {
					System.out.println("Selecione como deseja alterar VENDAS:\n"
							+ " (1) - Cadastrar\n"
							+ " (2) - Procurar\n"
							+ " (3) - Remover\n"
							+ " (4) - Atualizar\n"
							+ " (5) - Voltar");

					x = in.nextInt();
					//CADASTRAR FUNCIONARIO
					if (x == 1) {
                       System.out.print("Digite o id da venda");
                       
					}

					//PROCURAR FUNCIONARIO 
					if (x == 2) {

					}

					//REMOVER FUNCIONARIO
					if (x == 3) {

					}

					//ATUALIZAR FUNIONARIO
					if (x == 4) {

					}
				}
			}
		}
	}

}
