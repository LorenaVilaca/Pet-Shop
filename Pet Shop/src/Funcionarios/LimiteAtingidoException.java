package Funcionarios;

public class LimiteAtingidoException extends Exception{
	
	public LimiteAtingidoException () {
		super ("Sinto muito, o limite de funcionarios foi atingido.");
	}
}
