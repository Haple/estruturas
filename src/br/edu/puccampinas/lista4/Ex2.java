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
    printSeparator();
    try {
      numElementos = Integer.valueOf(br.readLine());
      for (int i = 0; i < numElementos; i++) {
        System.out.println("Qual é o elemento da posição " + i + "? ");
        fila.insereItem(br.readLine());
      }
      System.out.println("Digite um novo valor: ");
      valor = br.readLine();
      System.out.println("Após qual posição ele deve ser inserido? ");
      Integer posicao = Integer.valueOf(br.readLine());
      addElemento(valor, posicao, fila);
      printSeparator();
      System.out.println("Fila final: ");
      while (!fila.isVazia()) {
        System.out.println(fila.getItem());
        fila.removeItem();
      }
    } catch (NumberFormatException | IOException e) {
      System.err.println("Não foi possível ler a entrada!");
    } catch (Exception e) {
      System.err.println("Não há elemento na posição especificada!");
    }
  }

  private static void printSeparator() {
    System.out.println(new String(new char[50]).replaceAll("\0", "*"));
  }

  private static void addElemento(String novo, Integer posicao, Fila<String> f) throws Exception {
    if (posicao == null || f == null) {
      throw new Exception("Parâmetros nulos não são permitidos!");
    }
    if (posicao < 0 || posicao > f.getTamanho() - 1) {
      throw new Exception("Posição inválida!");
    }
    if (f.isVazia()) {
      f.insereItem(novo);
      return;
    }
    Fila<String> aux = new Fila<String>();
    Integer posicaoAtual = 0;
    while (!f.isVazia()) {
      aux.insereItem(f.getItem());
      f.removeItem();
      if (posicaoAtual == posicao) {
        aux.insereItem(novo);
      }
      posicaoAtual++;
    }
    while (!aux.isVazia()) {
      f.insereItem(aux.getItem());
      aux.removeItem();
    }
  }

}
