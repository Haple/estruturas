package br.edu.puccampinas.lista1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Exercício 2
 * 
 * @author Aleph Santos Oliveira (18710509)
 */
public class Ex2 {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws IOException {
    /**
     *  Lê uma pilha
     */
    BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
    int valor = 0;
    valor = Integer.parseInt(teclado.readLine());
    Pilha pilha = new Pilha(valor);
    while (!pilha.pilhaCheia()) {
      valor = Integer.parseInt(teclado.readLine());
      pilha.empilhar(valor);
    }

    /**
     *  Conta os números pares e coloca os valores em uma pilha auxiliar
     */
    Pilha aux = new Pilha(pilha.quantosElementos());
    int countImpares = 0;
    while (!pilha.pilhaVazia()) {
      valor = (int) pilha.desempilhar();
      if (valor % 2 != 0) {
        countImpares++;
      }
      aux.empilhar(valor);
    }

    /**
     * Cria uma pilha com os números ímpares e coloca os pares devolta na base da pilha original
     */
    Pilha impares = new Pilha(countImpares);
    while (!aux.pilhaVazia()) {
      valor = (int) aux.desempilhar();
      if (valor % 2 == 0) {
        pilha.empilhar(valor);
      } else {
        impares.empilhar(valor);
      }
    }

    /**
     * Empilha os números ímpares no topo da pilha original
     */
    while (!impares.pilhaVazia()) {
      pilha.empilhar(impares.desempilhar());
    }

    /**
     * Exibe a pilha final
     */
    System.out.println("Pilha final: ");
    while (!pilha.pilhaVazia()) {
      System.out.println(pilha.desempilhar());
    }
  }

}
