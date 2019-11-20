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
			System.out.println("Digite um numero correspondente a funcao que deseja alterar:\n "
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
						System.out.println("Para cadastrar um FUNCIONARIO insira:");
						System.out.println("-Nome do Funcionario:"); 
						String nomeFunc=in.next();
						System.out.println("-CPF do Funcionario:"); 
						String cpfFunc=in.next();
						System.out.println("-Telefone do Funcionario:"); 
						String telFunc=in.next();
						System.out.println("-Codigo do Funcionario:"); 
						String codeFunc=in.next();
						System.out.println("-Salario do Funcionario");
						double salarioFunc=in.nextDouble();
						Funcionarios funcionario = new Funcionarios(nomeFunc, cpfFunc, telFunc, codeFunc, salarioFunc);
						try {
							petshop.cadastrarFuncionario(funcionario);
							System.out.println("\n\n------ Funcionario Cadastrado com Sucesso ------\n\n");
                        } catch (LimiteFuncionariosAtingidoException | FuncionarioJaCadastradoException e) {
                            System.out.println("\n\n----------------- ERRO -----------------\n\n");
                            System.out.println(e.getMessage());
                            System.out.println("\n\n----------------- ERRO -----------------\n\n");
						}
					}

					//PROCURAR FUNCIONARIO 
					if (x == 2) {
						System.out.println("Digite o codigo do FUNCIONARIO que deseja procurar");
						String codeFunc = in.next();
						try {
							petshop.procurarFuncionario(codeFunc);
                        } catch (FuncionarioNaoEncontradoException e) {
                            System.out.println("\n\n----------------- ERRO -----------------\n\n");
                            System.out.println(e.getMessage());
                            System.out.println("\n\n----------------- ERRO -----------------\n\n");
						}
					}

					//REMOVER FUNCIONARIO
					if (x == 3) {
						System.out.println("Digite o codigo do FUNCIONARIO que deseja remover");
						String codeFunc = in.next();
						try {
							petshop.removerFuncionario(codeFunc);
                        } catch (FuncionarioNaoEncontradoException e) {
                            System.out.println("\n\n----------------- ERRO -----------------\n\n");
                            System.out.println(e.getMessage());
                            System.out.println("\n\n----------------- ERRO -----------------\n\n");
						}
					}

					//ATUALIZAR
					if (x == 4) {
						System.out.println("Primeiro, insira os dados do FUNCIONARIO que deseja atualizar:");
						System.out.println("-Nome do Funcionario:"); 
						String nomeFunc=in.next();
						System.out.println("-CPF do Funcionario:"); 
						String cpfFunc=in.next();
						System.out.println("-Telefone do Funcionario:"); 
						String telFunc=in.next();
						System.out.println("-Codigo do Funcionario:"); 
						String codeFunc=in.next();
						System.out.println("-Salario do Funcionario");
						double salarioFunc=in.nextDouble();
						Funcionarios funcionario = new Funcionarios(nomeFunc, cpfFunc, telFunc, codeFunc, salarioFunc);
						System.out.println("Agora, escolha o que deseja fazer\n"
							+ " (1) - ATUALIZAR UM CADASTRO DE FUNCIONARIO\n"
							+ " (2) - GERAR BONUS PARA UM FUNCIONARIO JA EXISTENTE\n");
							int y = in.nextInt();
						//ATUALIZAR FUNCIONARIO
							if (y == 1) {
								try {
									petshop.atualizarFuncionario(funcionario);
									System.out.println("\n\n------ Funcionario Atualizado com Sucesso ------\n\n");
								} catch (FuncionarioNaoEncontradoException e) {
									System.out.println("\n\n----------------- ERRO -----------------\n\n");
									System.out.println(e.getMessage());
									System.out.println("\n\n----------------- ERRO -----------------\n\n");
								}
							}
							//GERAR BONUS
							if (y == 2) {
								System.out.println("Digite o valor da VENDA efetuada");
								double valor = in.nextDouble();
								try {
									petshop.gerarBonus(funcionario, valor);
									System.out.println("\n\n------ Bonus Gerado com Sucesso ------\n\n");
								} catch (FuncionarioNaoEncontradoException e) {
									System.out.println("\n\n----------------- ERRO -----------------\n\n");
									System.out.println(e.getMessage());
									System.out.println("\n\n----------------- ERRO -----------------\n\n");
								}
							}
					}
				} 
			}
			//CLIENTES
			if (p == 2) { 
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
						System.out.println("Digite o codigo do PRODUTO que deseja procurar");
						String codeProduto = in.next();
						try {
							petshop.procurarProduto(codeProduto);
						} catch ( ProdutoNaoEncontradoException e) {
                            System.out.println("\n\n----------------- ERRO -----------------\n\n");
                            System.out.println(e.getMessage());
                            System.out.println("\n\n----------------- ERRO -----------------\n\n");
                        }
					}

					//REMOVER PRODUTOS
					if (x == 3) {
						System.out.println("Digite o codigo do PRODUTO que deseja remover");
						String codeProduto = in.next();
						try {
							petshop.removerProduto(codeProduto);
						} catch (ProdutoNaoEncontradoException e){
							System.out.println("\n\n----------------- ERRO -----------------\n\n");
                            System.out.println(e.getMessage());
                            System.out.println("\n\n----------------- ERRO -----------------\n\n");
						}

					}

					//ATUALIZAR PRODUTOS
					if (x == 4) {
						System.out.println("Para atualizar o PRODUTOS insira:");
						System.out.println("-Novo nome:"); String nomeProduto = in.next();
						System.out.println("-Codigo do Produto:"); String codeProduto = in.next();
						System.out.println("-Novo Preco:"); double priceProduto = in.nextDouble();
						System.out.println("-Nova Quantidade:"); int quantidadeProduto = in.nextInt();
						System.out.println("-Nova Fornecedor:"); String fornecedorProduto = in.next();
						Produtos produto = new Produtos(nomeProduto, codeProduto, priceProduto, quantidadeProduto, fornecedorProduto);
						 try {
                             petshop.atualizarProduto(produto);
                             
                             System.out.println("\n\n------ Produto Cadastrado com Sucesso ------\n\n");
                         } catch (ProdutoNaoEncontradoException e) {
                             System.out.println("\n\n----------------- ERRO -----------------\n\n");
                             System.out.println(e.getMessage());
                             System.out.println("\n\n----------------- ERRO -----------------\n\n");
                         }
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
					//CADASTRAR SERVICO
					if (x == 1) {
						System.out.println("Para cadastrar o SERVICO insira:");
						System.out.println("-Nome do SERVICO:"); 
						String nomeServico = in.next();
						System.out.println("-Codigo do SERVICO:"); 
						String codeServico= in.next();
						System.out.println("-Preco do SERVICO:"); 
						double priceServico = in.nextDouble();
						System.out.println("-");
						try {
							Servicos objetoServico = new Servicos (nomeServico, codeServico, priceServico);
							petshop.cadastrarServico(objetoServico);
							System.out.println("\n\nSERVICO cadastrado com sucesso!\n\n");
						}
						catch (ServicoJaCadastradoException e){
							System.out.println("\n\n********************ERRO********************");
							System.out.println(e.getMessage() + "\n\n");
						}
						catch (LimiteServicoAtingidoException e) {
							System.out.println("\n\n********************ERRO********************");
							System.out.println(e.getMessage() + "\n\n");
						}
					}

					//PROCURAR SERVICO 
					if (x == 2) {
						System.out.println("Para procurar o SERVICO insira:");
						System.out.println("-Codigo do SERVICO:"); 
						String codeServico= in.next();
						try {
							Servicos servicoProcurado = petshop.procurarServico(codeServico);
							System.out.println("-Nome do SERVICO: " + servicoProcurado.getNome());
							System.out.println("-Codigo do SERVICO: " + servicoProcurado.getCodigo());
							System.out.println("-Valos do SERVICO: R$" + servicoProcurado.getPreco() );
							System.out.println("-\n\n");
						}
						catch (ServicoNaoEncontradoException e) {
							System.out.println("\n\n********************ERRO********************");
							System.out.println(e.getMessage() + "\n\n");
						}
					}

					//REMOVER SERVICO
					if (x == 3) {
						System.out.println("Para remover o SERVICO insira:");
						System.out.println("-Codigo do SERVICO:\n");
						String codeServico = in.next();
						try {
							petshop.removerServico(codeServico);
							System.out.println("\n\nSERVICO removido com sucesso!\n\n");
						}
						catch(ServicoNaoEncontradoException e) {
							System.out.println("\n\n********************ERRO********************");
							System.out.println(e.getMessage() + "\n\n");
						}
					}

					//ATUALIZAR SERVICO
					if (x == 4) {
						System.out.println("Para atualizar o SERVICO insira:");
						System.out.println("-Codigo do SERVICO a ser atualizado:\n");
						String codeServico = in.next();
						try {
							petshop.existeServico(codeServico);
							System.out.println("Insira o novo nome do SERVICO:");
							String newName = in.next();
							System.out.println("Insira o novo preco do SERVICO");
							double newPrice = in.nextDouble();
							Servicos objetoServico = new Servicos(newName, codeServico, newPrice);
							petshop.atualizarServico(objetoServico);
						}
						catch (ServicoNaoEncontradoException e) {
							System.out.println("\n\n********************ERRO********************");
							System.out.println(e.getMessage() + "\n\n");
						}
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
