package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoRefatorado {

  public static void main(String[] args) {
    
    String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO","MÔNICA","FABRÍCIO","MIRELA","DANIELA","JORGE"};
    double salarioBase = 2000.00;

    selecionarCandidatos(candidatos, salarioBase);
  }

  
  static void selecionarCandidatos (String [] candidatos, double salarioBase){

    for (String candidato : candidatos) {

      double salarioPretendido = salarioPretendido();
      System.out.println("O salário pretendido pelo candidato " + candidato + " é de: " + salarioPretendido);
      
      if (salarioBase > salarioPretendido) {
        System.out.println("Ligar para o candidato " + candidato);
        entrarEmContato(candidato);
      } 
        else if (salarioBase == salarioPretendido) {
          System.out.println("Ligar para o candidato " + candidato + "com contraproposta.");
          entrarEmContato(candidato);
        } 
          else {
            System.out.println("Aguardando resultado dos demais candidatos.");
          }
    }
  }

  static double salarioPretendido() {

    double salario = ThreadLocalRandom.current().nextDouble(1500, 2500);
    return Math.round(salario * 100.0) / 100.0;
  }

  static boolean atender() {
		return new Random().nextInt(2)==1;	
	}

  static void entrarEmContato(String candidato) {

    int tentativasRealizadas = 1;
		boolean continuarTentando = true;
		boolean atendeu = false;

		do {
			atendeu= atender();
			continuarTentando = !atendeu;
			if(continuarTentando) {
				tentativasRealizadas++; 
      }
			 
		} while(continuarTentando && tentativasRealizadas < 3);
		
		if(atendeu) {
			System.out.println("CONSEGUIMOS CONTATO COM " + candidato +" NA " + tentativasRealizadas + "ª TENTATIVA.");
    }
		 else {
			System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato ); 
    }
	}
}
