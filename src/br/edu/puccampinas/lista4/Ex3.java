package br.edu.puccampinas.lista4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex3 {

  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Fila<Registro> fila = new Fila<Registro>();
    Integer n = 0;
    System.out.println("Digite o número de elementos a serem inseridos na fila: ");
    try {
      n = Integer.valueOf(br.readLine());
      for (int i = 0; i < n; i++) {
        System.out.println(new String(new char[50]).replaceAll("\0", "*"));
        System.out.println("Digite o valor do elemento " + (i + 1) + ": ");
        String valor = br.readLine();
        System.out.println("Digite a prioridade do elemento " + (i + 1) + ": ");
        Integer prioridade = Integer.valueOf(br.readLine());
        addRegistro(new Registro(valor, prioridade), fila);
      }
    } catch (NumberFormatException | IOException e) {
      System.err.println("Não foi possível ler a entrada!");
    }
    while (!fila.isVazia()) {
      System.out.println(fila.getItem().getValor());
      fila.removeItem();
    }
  }

  private static void addRegistro(Registro novo, Fila<Registro> f) {
    if (f.isVazia()) {
      f.insereItem(novo);
      return;
    }
    Fila<Registro> aux = new Fila<Registro>();
    while (f.getItem().getPrioridade() <= novo.getPrioridade()) {
      aux.insereItem(f.getItem());
      f.removeItem();
    }
    aux.insereItem(novo);
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
