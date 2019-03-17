package br.edu.puccampinas.diamantesareia;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DiamantesAreia {

  /**
   * Driver de teste do exercício "Diamantes e areia"
   * .<...<<..>>....>....>>>
   * @param args
   */
  public static void main(String[] args) {
    try {
      int diamantes = 0;
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.print("Digite a representação dos objetos na mina: ");
      char[] caracteres = br.readLine().toCharArray();
      Pilha<Character> p = new Pilha<Character>(caracteres.length);
      p.empilhar('.');
      for (int i = 0; i < caracteres.length; i++) {
        if (p.exibeTopo() =='<' && caracteres[i]=='>') {
          p.desempilhar();
          diamantes++;
        }else if (caracteres[i] =='<' || caracteres[i]=='>') {
          p.empilhar(caracteres[i]);
        }
      }
      System.out.println("Quantidade de diamantes possíveis: " + diamantes);
    } catch (Exception e) {
      System.out.println("Falha ao ler entrada do usuário.");
    }

  }

}
