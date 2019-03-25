package br.edu.puccampinas.treino1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1 {

  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Pilha<String> p = new Pilha<String>();
    try {
      System.out.println("Digite uma sequência de palavras: ");
      // caneta lápis borracha régua caderno livro
      String entrada = br.readLine();
      String palavra = "";
      for (int i = 0; i < entrada.length(); i++) {
        if (entrada.charAt(i) == ' ') {
          p.empilhar(palavra);
          palavra = "";
        } else {
          palavra += entrada.charAt(i);
          if (i == entrada.length() - 1)
            p.empilhar(palavra);
        }
      }
      System.out.println("Saída: ");
      while (!p.pilhaVazia()) {
        System.out.print(p.desempilhar() + " ");
      }
    } catch (IOException e) {
      System.err.println("Não foi possível ler a entrada!");
    }
  }

}
