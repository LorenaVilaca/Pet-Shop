package Funcionarios;

import PetShop.Funcionarios.Funcionario;

public interface InterfaceFuncionarios {
	public void inserirFuncionarios(Funcionario funcionario);
	
	public void removerFuncionarios(Funcionario funcionario);
	
	public Funcionario procurarFuncionarios(int codigo);
	
	public boolean existeFuncionario(int codigo);
	
	public void atualizarSalario(double salario);

}
