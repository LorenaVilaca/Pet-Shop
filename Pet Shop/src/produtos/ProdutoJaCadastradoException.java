package produtos;

public class ProdutoJaCadastradoException extends Exception {
	public ProdutoJaCadastradoException() {
		super("O produto j� foi cadastrado.");
	}
}
