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
					String codeF = null; String cpf = null; String codeP = null; String codeS = null; double valor = 0;
					
					//procurando as classes pertencentes a venda
					if (x == 1) {

						System.out.println("Digite o cpf do cliente:"); cpf = in.next();
						System.out.println("Digite o codigo do funcionario que efetuou a venda:"); codeF = in.next();
						System.out.println("Digite o codigo do produto vendido:"); codeP = in.next();
						System.out.println("Digite o codigo do servico prestado:"); codeS = in.next();
						System.out.println("Digite o valor total da venda:"); valor = in.nextDouble();
						System.out.println("Digite o id da venda:"); String id = in.next();

						try {

							Clientes cliente = petshop.procurarCliente(cpf);
							Funcionarios funcionario = petshop.procurarFuncionario(codeF);
							Produtos produto = petshop.procurarProduto(codeP);
							Servicos servico = petshop.procurarServico(codeS);
							Vendas venda = new Vendas (petshop.procurarFuncionario(codeF),
									petshop.procurarCliente(cpf),
									petshop.procurarProduto(codeP),
									petshop.procurarServico(codeS),
									valor, id);
							//cadastrando
							petshop.cadastrarVenda(venda);
							System.out.println("\n\n------ Venda Cadastrada com Sucesso ------\n\n");

						} catch (ClienteNaoEncontradoException | 
								FuncionarioNaoEncontradoException |
								ProdutoNaoEncontradoException |
								ServicoNaoEncontradoException |  
								VendaJaCadastradaException |
								LimiteAtingidoException | 
								AlgoNaoFoiEncontradoException c) {
							System.out.println("\n\n----------------- ERRO -----------------\n\n");
							System.out.println(c.getMessage());
							System.out.println("\n\n----------------- ERRO -----------------\n\n");	   
						}
					}

					//PROCURAR VENDA
					if (x == 2) {
						System.out.println("Digite o id da venda que voce quer procurar:");
						String idP = in.next();
						try {
							Vendas procura = petshop.procurarVenda(idP);
							System.out.println("nome do cliente: " + procura.getCliente().getNome() + "\n" + "cpf do cliente: " + procura.getCliente().getCpf() 
									+ "\n" + "telefone do cliente: " + procura.getCliente().getTelefone() + "\n" + "desconto que o cliente possui: " 
									+ procura.getCliente().getCredito() + "\n");
							System.out.println("nome do funcionario: " + procura.getFuncionario().getNome() + "\n" + "cpf do funcionario: " + procura.getFuncionario().getCpf() 
									+ "\n" + "codigo do funcionario: " + procura.getFuncionario().getCodigo() + "\n" + "telefone do funcionario: " 
									+ procura.getFuncionario().getTelefone() + "\n" + "salario do funcionario: " + procura.getFuncionario().getSalario());
							System.out.println("nome do produto: " + procura.getProduto().getNome() + "\n" + "codigo do produto" + procura.getProduto().getCode() + "\n" 
									+ "nome do fornecedor do produto: " + procura.getProduto().getFornecedor() + "\n" + "preco do produto: " + procura.getProduto().getPrice() 
									+ "\n" + "quantidade do produto em estoque: " + procura.getProduto().getQuantidade());
							System.out.println("nome do servico prestado: " + procura.getServico().getNome() + "\n" + "codigo do servico prestado: " + procura.getServico().getCodigo() 
									+ "\n" + "preco do servico prestado: " +  procura.getServico().getPreco());
							System.out.println("valor total da venda: " + procura.getValor() + "\n" + "id da venda: " + procura.getId());
						} catch (VendaNaoEncontradaException v) {
							System.out.println("\n\n----------------- ERRO -----------------\n\n");
							System.out.println(v.getMessage());
							System.out.println("\n\n----------------- ERRO -----------------\n\n");
						}
					}

					//REMOVER VENDA
					if (x == 3) {
						System.out.println("Digite o id da venda que voce quer remover:");
						String idR = in.next();
						try {
							petshop.removerVenda(idR);
							System.out.println("\n\n------ Venda Removida com Sucesso ------\n\n");
						} catch (VendaNaoEncontradaException v) {
							System.out.println("\n\n----------------- ERRO -----------------\n\n");
							System.out.println(v.getMessage());
							System.out.println("\n\n----------------- ERRO -----------------\n\n");
						}
					}

					//ATUALIZAR VENDA
					if (x == 4) {

						System.out.println("Digite o id da venda que voce quer atualizar:");
						String idA = in.next();
						System.out.println("Deseja atualizar a venda inteira ou apenas um aspecto da venda?" + "\n" 
								+ "(1) Venda inteira" + "\n" + "(2) apenas um aspecto");
						int comandoC = in.nextInt();

						String nomeNovoCliente; String cpfNovoCliente; String telefoneNovoCliente;
						double credNovoCliente; String cpfNovoFunc = ""; String nomeNovoFunc;
						String telefoneNovoFunc; String codNovoFunc; double SalarioNovoFunc;
						String nomeNovoProd; String codNovoProd; String FornNovoProd;
						int qntdNovoProd; double PrecoNovoProd; String nomeNovoServ;
						String codNovoServ; double precoNovoServ; double valorNovaVenda;

						//mudando tudo (venda com o mesmo id)
						if (comandoC == 1) {

							//atualizando cliente da venda
							System.out.println("Digite os dados do novo cliente");
							nomeNovoCliente = in.next();
							cpfNovoCliente = in.next();
							telefoneNovoCliente = in.next();
							credNovoCliente = in.nextDouble();
							Clientes novoCliente = new Clientes(nomeNovoCliente, cpfNovoCliente, telefoneNovoCliente);
							novoCliente.setCredito(credNovoCliente);

							//atualizando funcionario da venda
							System.out.println("Digite os dados do novo Funcionario");
							nomeNovoFunc = in.next();
							cpfNovoFunc = in.next();
							telefoneNovoFunc = in.next();
							codNovoFunc = in.next();
							SalarioNovoFunc = in.nextDouble();
							Funcionarios novoFunc = new Funcionarios(nomeNovoFunc, cpfNovoFunc, telefoneNovoFunc, codNovoFunc, SalarioNovoFunc);

							//atualizando produto da venda
							System.out.println("Digite os dados do novo produto");
							nomeNovoProd = in.next();
							codNovoProd = in.next();
							FornNovoProd = in.next();
							qntdNovoProd = in.nextInt();
							PrecoNovoProd = in.nextDouble();
							Produtos novoProd = new Produtos(nomeNovoProd, codNovoProd, PrecoNovoProd, qntdNovoProd, FornNovoProd);

							//atualizando servico da venda
							System.out.println("Digite os dados do novo servico");
							nomeNovoServ = in.next();
							codNovoServ = in.next();
							precoNovoServ = in.nextDouble();
							Servicos novoServ = new Servicos(nomeNovoServ, codNovoServ, precoNovoServ);

							//atualizando o valor da venda
							System.out.println("Digite o valor total da nova venda");
							valorNovaVenda = in.nextDouble();
							Vendas vendaNova = new Vendas(novoFunc, novoCliente, novoProd, novoServ, valorNovaVenda, idA);

							try {
								petshop.atualizarVenda(vendaNova);
								System.out.println("\n\n------ Venda Atualizada com Sucesso ------\n\n");
							} catch (VendaNaoEncontradaException v) {
								System.out.println("\n\n----------------- ERRO -----------------\n\n");
								System.out.println(v.getMessage());
								System.out.println("\n\n----------------- ERRO -----------------\n\n");
							}
						} 
						
						//atualizando apenas um aspecto
						else if (comandoC == 2) {

							System.out.println("Qual parte voce quer modificar na venda atual?" + "\n" +
									"(1) Cliente" + "\n" +
									"(2) Funcionario" + "\n" +
									"(3) Produto" + "\n" + 
									"(4) Servico" + "\n" +
									"(5) Valor");
							int comandoX = in.nextInt();

							//atualizando apenas o cliente
							if (comandoX == 1) {
								System.out.println("Digite os dados do novo cliente");
								nomeNovoCliente = in.next();
								cpfNovoCliente = in.next();
								telefoneNovoCliente = in.next();
								credNovoCliente = in.nextDouble();
								Clientes novoCliente = new Clientes(nomeNovoCliente, cpfNovoFunc, telefoneNovoCliente);
								novoCliente.setCredito(credNovoCliente);
								try {
									Vendas vendaNova = new Vendas(petshop.procurarFuncionario(codeF), 
											novoCliente, petshop.procurarProduto(codeP), petshop.procurarServico(codeS), valor, idA);
									petshop.atualizarVenda(vendaNova);
									System.out.println("\n\n------ Venda Atualizada com Sucesso ------\n\n");
								} catch (FuncionarioNaoEncontradoException | 
										ProdutoNaoEncontradoException |
										VendaNaoEncontradaException |
										ServicoNaoEncontradoException v) {
									System.out.println("\n\n----------------- ERRO -----------------\n\n");
									System.out.println(v.getMessage());
									System.out.println("\n\n----------------- ERRO -----------------\n\n");
								}
							} 

							//atualizando apenas o funcionario
							else if (comandoX == 2) {

								System.out.println("Digite os dados do novo Funcionario");
								nomeNovoFunc = in.next();
								cpfNovoFunc = in.next();
								telefoneNovoFunc = in.next();
								codNovoFunc = in.next();
								SalarioNovoFunc = in.nextDouble();
								Funcionarios novoFunc = new Funcionarios(nomeNovoFunc, cpfNovoFunc, telefoneNovoFunc, codNovoFunc, SalarioNovoFunc);

								try {
									Vendas vendaNova = new Vendas(novoFunc, 
											petshop.procurarCliente(cpf), petshop.procurarProduto(codeP), petshop.procurarServico(codeS), valor, idA);
									petshop.atualizarVenda(vendaNova);
									System.out.println("\n\n------ Venda Atualizada com Sucesso ------\n\n");
								} catch (ClienteNaoEncontradoException | 
										ProdutoNaoEncontradoException |
										VendaNaoEncontradaException |
										ServicoNaoEncontradoException v) {
									System.out.println("\n\n----------------- ERRO -----------------\n\n");
									System.out.println(v.getMessage());
									System.out.println("\n\n----------------- ERRO -----------------\n\n");
								}
							} 

							//atualizando apenas o produto
							else if (comandoX == 3) {

								System.out.println("Digite os dados do novo produto");
								nomeNovoProd = in.next();
								codNovoProd = in.next();
								FornNovoProd = in.next();
								qntdNovoProd = in.nextInt();
								PrecoNovoProd = in.nextDouble();
								Produtos novoProd = new Produtos(nomeNovoProd, codNovoProd, PrecoNovoProd, qntdNovoProd, FornNovoProd);

								try {
									Vendas vendaNova = new Vendas(petshop.procurarFuncionario(codeF), 
											petshop.procurarCliente(cpf), novoProd, petshop.procurarServico(codeS), valor, idA);
									petshop.atualizarVenda(vendaNova);
									System.out.println("\n\n------ Venda Atualizada com Sucesso ------\n\n");
								} catch (ClienteNaoEncontradoException | 
										VendaNaoEncontradaException |
										FuncionarioNaoEncontradoException |
										ServicoNaoEncontradoException v) {
									System.out.println("\n\n----------------- ERRO -----------------\n\n");
									System.out.println(v.getMessage());
									System.out.println("\n\n----------------- ERRO -----------------\n\n");
								}
							} 

							//atualizando apenas o servico
							else if (comandoX == 4) {

								System.out.println("Digite os dados do novo servico");
								nomeNovoServ = in.next();
								codNovoServ = in.next();
								precoNovoServ = in.nextDouble();
								Servicos novoServ = new Servicos(nomeNovoServ, codNovoServ, precoNovoServ);

								try {
									Vendas vendaNova = new Vendas(petshop.procurarFuncionario(codeF), 
											petshop.procurarCliente(cpf), petshop.procurarProduto(codeP), novoServ, valor, idA);
									petshop.atualizarVenda(vendaNova);
									System.out.println("\n\n------ Venda Atualizada com Sucesso ------\n\n");
								} catch (ClienteNaoEncontradoException | 
										ProdutoNaoEncontradoException |
										VendaNaoEncontradaException | 
										FuncionarioNaoEncontradoException v) {
									System.out.println("\n\n----------------- ERRO -----------------\n\n");
									System.out.println(v.getMessage());
									System.out.println("\n\n----------------- ERRO -----------------\n\n");
								}	
							} 

							//atualizando apenas o valor da venda
							else if (comandoX == 5) {
								valorNovaVenda = in.nextDouble();

								try {
									Vendas vendaNova = new Vendas(petshop.procurarFuncionario(codeF), 
											petshop.procurarCliente(cpf), petshop.procurarProduto(codeP), 
											petshop.procurarServico(codeS), valorNovaVenda, idA);
									petshop.atualizarVenda(vendaNova);
									System.out.println("\n\n------ Venda Atualizada com Sucesso ------\n\n");
								} catch (ClienteNaoEncontradoException | 
										ProdutoNaoEncontradoException |
										ServicoNaoEncontradoException | 
										FuncionarioNaoEncontradoException | 
										VendaNaoEncontradaException v) {
									System.out.println("\n\n----------------- ERRO -----------------\n\n");
									System.out.println(v.getMessage());
									System.out.println("\n\n----------------- ERRO -----------------\n\n");
								}
							}
						}
					}
				}
			}
		}
	}

}
