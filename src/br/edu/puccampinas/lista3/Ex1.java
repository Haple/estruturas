package br.edu.puccampinas.lista3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1 {

  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Pilha<Character> palavra1 = new Pilha<Character>();
    Pilha<Character> palavra2 = new Pilha<Character>();
    try {
      System.out.println("Vamos verificar se uma palavra é o inverso da outra...");
      System.out.print("Digite a primeira palavra: ");
      String x = br.readLine().toLowerCase();
      System.out.print("Digite a segunda palavra: ");
      String y = br.readLine().toLowerCase();
      for (int i = x.length()-1; i >= 0; i--)
        palavra1.empilhar(x.charAt(i));
      for (int i = 0; i < y.length(); i++)
        palavra2.empilhar(y.charAt(i));
      boolean inverso = palavra1.equals(palavra2);
      if (inverso) {
        System.out.println("A palavra \"" + y + "\" é o inverso de \"" + x + "\".");
      } else {
        System.out.println("A palavra \"" + y + "\" não é o inverso de \"" + x + "\".");
      }
    } catch (IOException e) {
      System.err.println("Não foi possível ler a entrada!");
    }
  }

}
