package Venda;
public class Venda {
	private Funcionario funcionario;
	private Cliente cliente;
	private Produto produto;
	private Servico servico;
	private double valor;
	private int id;
	public Venda(Funcionario funcionario, Cliente cliente, Produto produto, Servico servico, double valor) {
		this.funcionario = funcionario;
		this.cliente = cliente;
		this.produto = produto;
		this.servico = servico;
		this.valor = valor;
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
}
