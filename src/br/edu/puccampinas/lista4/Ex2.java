package br.edu.puccampinas.lista4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2 {

  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Fila<String> fila = new Fila<String>();
    Integer numElementos = 0;
    String valor = "";
    System.out.println("Digite o número de elementos a serem inseridos na fila: ");
    System.out.println(new String(new char[50]).replaceAll("\0", "*"));
    try {
      numElementos = Integer.valueOf(br.readLine());
      for (int i = 0; i < numElementos; i++) {
        System.out.println("Qual é o elemento número " + (i + 1) + "? ");
        valor = br.readLine();
        fila.insereItem(valor);
      }
      System.out.println("Digite um novo valor: ");
      valor = br.readLine();
      System.out.println("Após qual posição ele deve ser inserido? ");
      Integer posicao= Integer.valueOf(br.readLine());
      addElemento(valor, posicao, fila);
    } catch (NumberFormatException | IOException e) {
      System.err.println("Não foi possível ler a entrada!");
    }
    while (!fila.isVazia()) {
      System.out.println(fila.getItem());
      fila.removeItem();
    }
  }

  private static void addElemento(String novo, Integer posicao, Fila<String> f) {
    if (f.isVazia()) {
      f.insereItem(novo);
      return;
    }
    Fila<String> aux = new Fila<String>();
    Integer posicaoAtual = 0;
    while (!f.isVazia()) {
      if (posicaoAtual == posicao) {
        aux.insereItem(novo);
        break;
      }
      aux.insereItem(f.getItem());
      f.removeItem();
      posicaoAtual++;
    }
    while (!f.isVazia()) {
      aux.insereItem(f.getItem());
      f.removeItem();
    }
    while (!aux.isVazia()) {
      f.insereItem(aux.getItem());
      aux.removeItem();
    }
  }

}
