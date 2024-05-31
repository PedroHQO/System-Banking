package com.pedro.ads.portfolio;

import java.util.Scanner;

public class GerenciaBanco {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
	
		
		DadosPessoais dadosPessoais = new DadosPessoais();
		
		System.out.print("Digite seu Nome e Sobrenome: ");
		dadosPessoais.setNome(ler.nextLine());
		
		System.out.print("Digite apenas os números do seu CPF: ");
		dadosPessoais.setCpf(ler.next());
		
		System.out.println("Seja Bem-Vindo " + dadosPessoais.getNome().toUpperCase() + "!");
		
		OperacoesBancarias operacoesbanco = new OperacoesBancarias();
		
		GerenciaBanco view = new GerenciaBanco();
		view.exibirMenu(operacoesbanco, ler, dadosPessoais);
		
		
	}
	
	public void exibirMenu(OperacoesBancarias operacoesbanco, Scanner ler, DadosPessoais dadosPessoais) {
		//Scanner ler = new Scanner(System.in);
		int opcao = 0;
		boolean sair = false;
		
		do {
			System.out.println("-----------------------------");
			System.out.println("NOSSOS SERVIÇOS");
			System.out.println("1. Consulta de Saldo");
			System.out.println("2. Depósito");
			System.out.println("3. Saque");
			System.out.println("4. Sair");
			System.out.println("-----------------------------");
			
			System.out.print("Digite uma opção: ");
			opcao = ler.nextInt();
			
			switch(opcao) {
			case 1:
				System.out.printf("Saldo Atual: %.2f\n", operacoesbanco.consutarSaldo());
				break;
			case 2:
				System.out.print("Digite o Valor do Depósito: ");
				double valorDposito = ler.nextDouble();
				operacoesbanco.deposito(valorDposito);
				System.out.println("DEPÓSITO REALIZADO COM SUCESSO!");
				break;
			case 3:
				System.out.print("Digite o Valor Que Deseja Sacar:");
				double valorSaque = ler.nextDouble();
				operacoesbanco.sacar(valorSaque);
				
				if(operacoesbanco.sacar(valorSaque)) {
					System.out.println("SAQUE REALIZADO COM SUCESSO!");
				}else {
					System.out.println("SALDO INSULFICIENTE PARA SAQUE!");
				}
				break;
			case 4:
				sair = true;
				System.out.println("Encerrando seção, até mais " + dadosPessoais.getNome().toUpperCase()+ "...");
				break;
			default:
				System.out.println("OPÇÃO INVÁLIDA!");
			}
			
			
		}while(!sair);
		
	}

}

class DadosPessoais{
	private String nome;
	private String cpf;
	
	
	/*Métodos acessadores set/get, são eles que permitem acessar as variaveis de forma
	 * externa da classe, normalmente eles andam em pares, porém podem ser usados
	 * individualmente também. 
	 * Temos um construtor + acessador = retorna nossa variavel privada e para o set
	 * temos this.(a váriavel privada que escolhemos)
	 * 
	 * O this pode ser opcional em diversos casos mas alguns programadores gostam de usar
	 *  sempre para garantir não haver ambiguidade, não confundir uma variável de classe 
	 *  com uma variável local ou parâmetro.
	 *  this.nome = parametro*/
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}

class OperacoesBancarias{
	private double saldo;
	
	public OperacoesBancarias() {
		this.saldo = 0.0;
	}
	
	public double consutarSaldo() {
		return saldo;
	}
	
	public void deposito(double valor){
		if(valor > 0) {
			saldo+= valor;
		}
	}
	
	public boolean sacar(double valor) {
		if(valor > 0 && saldo >= valor ) {
			saldo-= valor;
			return true;
		}else {
			return false;
		}
			
		
	}
	
	
}
	


