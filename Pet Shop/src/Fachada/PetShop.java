package Fachada;
import Funcionarios.Funcionarios;
import Venda.CadastroVenda;
import Venda.RepositorioVendas;
import clientes.CadastroClientes;
import clientes.ClienteJaCadastradoException;
import clientes.ClienteNaoEncontradoException;
import clientes.Clientes;
import clientes.RepositorioClientes;
import produtos.CadastroProdutos;
import produtos.Produtos;
import produtos.RepositorioProduto;
import servicos.CadastroServicos;
import servicos.RepositorioServicos;
import servicos.Servicos;

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
           throws ClienteJaCadastradoException {
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

   public void cadastrarProdutos(Produtos produto) throws LimiteAtingidoException, ViveiroJaCadastradoException {
       if (this.viveiros.existe(viveiro.getId())) {
           ViveiroJaCadastradoException e;
           e = new ViveiroJaCadastradoException();
           throw e;
       } else {
           viveiros.cadastrar(viveiro);
       }
   }

   public void removerViveiro(int id) throws ViveiroNaoEncontradoException {
       this.viveiros.remover(id);
   }

   public void atualizarViveiro(Viveiro viveiro) throws ViveiroNaoEncontradoException {
       if (this.viveiros.existe(viveiro.getId())) {
           this.viveiros.atualizar(viveiro);
       } else {
           ViveiroNaoEncontradoException e;
           e = new ViveiroNaoEncontradoException();
           throw e;
       }

   }

   public Viveiro procurarViveiro(int id) throws ViveiroNaoEncontradoException {
       return this.viveiros.procurar(id);
   }

   public boolean existeViveiro(int id){
       return this.viveiros.existe(id);
   }

   public void cadastrarGerente(Gerentes gerente)
           throws LimiteAtingidoException, GerenteJaCadastradoException, GerenteNaoEncontradoException {
       if (this.gerentes.existe(gerente.getCpf())) {
           GerenteJaCadastradoException e;
           e = new GerenteJaCadastradoException();
           throw e;
       } else {
           gerentes.cadastrar(gerente);
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
