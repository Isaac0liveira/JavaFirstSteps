package testes;
import java.util.Scanner;
   public class teste2{
	   
	   public static void main(String[] args) {
		   Menu inicio = new Menu();
		   inicio.principal(true, null);		   	   
	   }
   }

   class Menu{
	  
	  void principal(boolean menu, Conta destino){
		  if(menu) {
			  System.out.println("Bem vindo!");
			  System.out.println("1 - Selecionar conta\n2 - Sacar \n3 - Depositar");
			  System.out.println("Digite a opera��o a realizar: ");
			  Scanner digitar = new Scanner(System.in);
			  if(digitar.hasNext("1")) {
				 new Gerenciar().contaNova(true); 
			  }
			  else if(digitar.hasNext("2")) {
				 if(destino == null) {
					 System.out.println("N�o h� conta.");
				     new Menu().principal(true, null);
				 }else {
					 new Gerenciar().retirar(true, destino); 	 
				 }
			  }
			  else if(digitar.hasNext("3")) {
				  if(destino == null) {
						 System.out.println("N�o h� conta.");
					     new Menu().principal(true, null);
					 }else {
						 new Gerenciar().depositar(true, destino); 	 
					 }
			  }else {
				 System.out.println("Op��o inv�lida");
				 new Menu().principal(true, destino);
			  }
				 
		  }
	  }
	  
  }
  
	class Gerenciar{
		void contaNova(boolean acionar){
			if(acionar) {
				Conta nova = new Conta();
				System.out.println("Nome:");
				Scanner nome = new Scanner(System.in);
				nova.titular = nome.next();
				new Menu().principal(true, nova);	    
			}
		}
		void retirar(boolean acionar, Conta destino) {
			System.out.println("Quanto deseja sacar? ");
			Scanner valor = new Scanner(System.in);
			destino.saca(valor.nextDouble());
			new Menu().principal(true, destino);
		}
		void depositar(boolean acionar, Conta destino) {
			System.out.println("Quanto deseja depositar? ");
			Scanner valor = new Scanner(System.in);
			destino.deposita(valor.nextDouble());
			new Menu().principal(true, destino);
		}
	}
	
	class Conta{
		public String titular;
		public int numero;
		private double saldo;
	
		public void saca(double quantidade) {
			if(quantidade < this.saldo) {
				this.saldo -= quantidade;
				System.out.println("Saque feito com sucesso! Seu saldo � " + this.saldo);
			}else {
				System.out.println("Voc� atingiu o limite de saque");
			}
		}
		public void deposita(double quantidade) {
			this.saldo += quantidade;
			System.out.println("Dep�sito feito com sucesso! Seu saldo � " + this.saldo);
		}	
}	