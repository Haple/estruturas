package br.edu.puccampinas.lista1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Exercício 1
 * 
 * @author Aleph Santos Oliveira (18710509)
 */
public class Ex1 {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws IOException {
    // Lê uma pilha
    BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
    int valor = 0;
    valor = Integer.parseInt(teclado.readLine());
    Pilha pilha = new Pilha(valor);
    while (!pilha.pilhaCheia()) {
      valor = Integer.parseInt(teclado.readLine());
      pilha.empilhar(valor);
    }

    // Extrai o topo e base, cria uma pilha auxiliar com os elementos que sobraram menos 1, para que
    // essa nova pilha tenha apenas os elementos entre o topo e a base
    int topo = (int) pilha.desempilhar();
    Pilha aux = new Pilha(pilha.quantosElementos() - 1);
    while (!aux.pilhaCheia()) {
      aux.empilhar(pilha.desempilhar());
    }
    int base = (int) pilha.desempilhar();

    // Reorganiza a pilha com o topo no lugar da base, os elementos da pilha auxiliar no meio e a
    // base no lugar do topo
    pilha.empilhar(topo);
    while (!aux.pilhaVazia()) {
      pilha.empilhar(aux.desempilhar());
    }
    pilha.empilhar(base);
    System.out.println("Pilha final: ");
    while (!pilha.pilhaVazia()) {
      System.out.println(pilha.desempilhar());
    }
  }

}
