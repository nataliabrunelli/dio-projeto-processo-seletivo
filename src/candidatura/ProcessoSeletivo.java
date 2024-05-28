package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {

  public static void main(String[] args) {
    
    System.out.println("Processo Seletivo:");

    String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO"};
    
    for (String candidato : candidatos) {
      entrarEmContato(candidato);
    }

    /* Caso 3 - imprimindo os selecionados 
    * imprimirSelecionados();  
    */

    /* Caso 2 - selecionando os 5 primeiros: 
    * selecionarCandidatos(); 
    */

    /* Caso 1, testando salarioPretendido:
    * analisarCandidato(1900);
    * analisarCandidato(2200);
    * analisarCandidato(2000); 
    */
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
			System.out.println("CONSEGUIMOS CONTATO COM " + candidato +" NA " + tentativasRealizadas + "ª TENTATIVA"); 
    }
		 else {
			System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato ); 
    }
		
	}

  static void imprimirSelecionados () {

    String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO"};

    for (int i = 0; i < candidatos.length; i++) {
      System.out.println("O candidato selecionado de índice: " + (i + 1) + " é o/a " + candidatos[i]);
    }
  }
  static void selecionarCandidatos () {

    String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO","MÔNICA","FABRÍCIO","MIRELA","DANIELA","JORGE"};

    double salarioBase = 2000.00;
    int candidatosSelecionados = 0;
    int candidatoAtual = 0; //indice do array

    while (candidatosSelecionados <= 5 && candidatoAtual < candidatos.length) {
      
      String candidato = candidatos [candidatoAtual];

      double salarioPretendido = valorPretendido();
      System.out.println("O candidato " + (candidato) + " solicitou este valor de salário: " + (salarioPretendido));

      if (salarioBase >= salarioPretendido) {

        System.out.println("O candidato " + candidato + " foi selecionado para a vaga.");
        candidatosSelecionados++;
      }

      candidatoAtual++; //para verificar o próximo candidato do array e não virar um loop infinito
    }

    if (candidatosSelecionados == 5) {
      System.out.println("Todas as vagas foram preenchidas!");
    } 
      else {
        System.out.println("Vagas remanescentes: " + (5 - candidatosSelecionados));
      }
  }

  static double valorPretendido() {

    double valor = ThreadLocalRandom.current().nextDouble(1500, 2500);
    return Math.round(valor * 100.0) / 100.0;
  }

  static void analisarCandidato (double salarioPretendido){

    double salarioBase = 2000.00;

    if (salarioBase > salarioPretendido) {
      System.out.println("Ligar para o candidato.");
    } 
      else if (salarioBase == salarioPretendido) {
        System.out.println("Ligar para o candidato com contraproposta.");
      } 
        else {
          System.out.println("Aguardando resultado dos demais candidatos.");
        }

  }

  
}
