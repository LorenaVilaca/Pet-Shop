package fachada;
import clientes.CadastroClientes;
import clientes.ClienteJaCadastradoException;
import clientes.ClienteNaoEncontradoException;
import clientes.Clientes;
import clientes.LimiteClientesAtingidoException;
import clientes.RepositorioClientes;
import funcionarios.CadastroFuncionarios;
import funcionarios.FuncionarioJaCadastradoException;
import funcionarios.FuncionarioNaoEncontradoException;
import funcionarios.LimiteAtingidoException;
import funcionarios.Funcionarios;
import funcionarios.RepositorioFuncionarios;
import produtos.CadastroProdutos;
import produtos.LimiteProdutosAtingidoException;
import produtos.ProdutoJaCadastradoException;
import produtos.ProdutoNaoEncontradoException;
import produtos.Produtos;
import produtos.RepositorioProduto;
import servicos.CadastroServicos;
import servicos.RepositorioServicos;
import servicos.Servicos;
import venda.CadastroVenda;
import venda.RepositorioVendas;

public class PetShop {
	
   private CadastroClientes clientes;
   private CadastroFuncionarios funcionarios;
   private CadastroProdutos produtos;
   private CadastroServicos servicos;
   private CadastroVenda vendas;
   
   public PetShop (RepositorioClientes repoClientes, 
		   RepositorioFuncionarios repoFuncionarios, RepositorioProduto repoProdutos,
		   RepositorioServicos repoServicos, RepositorioVendas repoVendas) {
	   this.clientes = new CadastroClientes (repoClientes);
	   this.funcionarios = new CadastroFuncionarios (repoFuncionarios);
	   this.produtos = new CadastroProdutos (repoProdutos);
	   this.servicos = new CadastroServicos (repoServicos);
	   this.vendas = new CadastroVenda (repoVendas);
   }
   
   public void cadastrarCliente (Clientes cliente)
           throws ClienteJaCadastradoException, LimiteClientesAtingidoException {
       if (this.clientes.existe(cliente.getCpf())) {
           ClienteJaCadastradoException c = new ClienteJaCadastradoException();
           throw c;
       } else {
           clientes.cadastrar(cliente);
       }
   }

   public void removerCliente(String cpf)
           throws ClienteNaoEncontradoException {
       this.clientes.remover(cpf);
   }

   public void atualizarCliente(Clientes cliente)
           throws ClienteNaoEncontradoException {
       if (this.clientes.existe(cliente.getCpf())) {
           this.clientes.atualizar(cliente);
       } else {
           ClienteNaoEncontradoException e;
           e = new ClienteNaoEncontradoException();
           throw e;
       }

   }

   public Clientes procurarCliente(String cpf)
           throws ClienteNaoEncontradoException {
       return this.clientes.procurar(cpf);
   }

   public void cadastrarProdutos(Produtos produto) throws LimiteProdutosAtingidoException, ProdutoJaCadastradoException, ProdutoNaoEncontradoException {
       if (this.produtos.existe(produto.getCode())) {
           ProdutoJaCadastradoException e;
           e = new ProdutoJaCadastradoException();
           throw e;
       } else {
           produtos.cadastrar(produto);
       }
   }

   public void removerProduto (String codeProduto) throws ProdutoNaoEncontradoException {
       this.produtos.remover(codeProduto);
   }

   public void atualizarProduto (Produtos produto) throws ProdutoNaoEncontradoException {
       if (this.produtos.existe(produto.getCode())) {
           this.produtos.atualizarProduto (produto);
       } else {
           ProdutoNaoEncontradoException e;
           e = new ProdutoNaoEncontradoException();
           throw e;
       }

   }

   public Produtos procurarProduto (String codeProduto) throws ProdutoNaoEncontradoException {
       return this.produtos.procurar(codeProduto);
   }

   public boolean existeProduto (String codeProduto) throws ProdutoNaoEncontradoException {
       return this.produtos.existe (codeProduto);
   }

   public void cadastrarFuncionario (Funcionarios funcionario, String codigo, double salario)
           throws LimiteAtingidoException, FuncionarioJaCadastradoException, FuncionarioNaoEncontradoException {
       if (this.funcionarios.existeFuncionario(funcionario.getCodigo())) {
           FuncionarioJaCadastradoException f;
           f = new FuncionarioJaCadastradoException();
           throw f;
       } else {
           funcionarios.cadastrarFuncionario(funcionario, codigo, salario);
       }
   }

   public void removerGerente(String cpf)
           throws GerenteNaoEncontradoException {
       this.gerentes.remover(cpf);
   }

   public void atualizarGerente(Gerentes funcionario)
           throws GerenteNaoEncontradoException {
       if (this.gerentes.existe(funcionario.getCpf())) {
           this.gerentes.atualizar(funcionario);
       } else {
           GerenteNaoEncontradoException e;
           e = new GerenteNaoEncontradoException();
           throw e;
       }

   }

   public Gerentes procurarGerente(String cpf)
           throws GerenteNaoEncontradoException {
       return this.gerentes.procurar(cpf);
   }

   public void cadastrarPokemon(Pokemon pokemon) throws PokemonJaCadastradoException, LimiteAtingidoException {
       if (this.pokemons.existe(pokemon.getId())) {
           PokemonJaCadastradoException e;
           e = new PokemonJaCadastradoException();
           throw e;
       } else {
           pokemons.cadastrar(pokemon);
       }
   }

   public void removerPokemon(int id) throws PokemonNaoEncontradoException {
       this.pokemons.remover(id);
   }

   public Pokemon procurarPokemon(int id) throws PokemonNaoEncontradoException {
       return this.pokemons.procurar(id);
   }

   public void atualizarPokemon(Pokemon pokemon) throws PokemonNaoEncontradoException {
       if (this.pokemons.existe(pokemon.getId())) {
           this.pokemons.atualizar(pokemon);
       } else {
           PokemonNaoEncontradoException e;
           e = new PokemonNaoEncontradoException();
           throw e;
       }
   }
}
