package clientes;
import pessoa.PessoaAbstract;

public class Clientes extends PessoaAbstract {
	
	public Clientes (String nome, String cpf, String telefone) {
		super (nome,cpf,telefone);
				
	}

	public double desconto() {
		return 0;
	}

}
