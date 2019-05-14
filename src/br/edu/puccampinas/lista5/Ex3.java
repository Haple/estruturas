package br.edu.puccampinas.lista5;

import br.edu.puccampinas.lista2.Teclado;


public class Ex3 {

  public static void main(String[] args) {
    Lista<Lista<String>> listas = new Lista<Lista<String>>();
    try {
      // Entrada
      int casosDeTeste = Teclado.getUmInt();
      for (int i = 0; i < casosDeTeste; i++) {
        Lista<String> lista = new Lista<String>();
        String[] linha = Teclado.getUmString().split(" ");
        for (String item : linha) {
          insereOrdenadoUnico(item, lista);
        }
        listas.insereItem(lista);
      }
      // Saída
      while (!listas.isVazia()) {
        Lista<String> lista = listas.getItem();
        System.out.print(lista);
        listas.removeItem();
        System.out.println();
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }

  private static void insereOrdenadoUnico(String item, Lista<String> lista) {
    try {
      if (lista.isVazia()) {
        lista.insereItem(item);
        return;
      }
      int pos = 1;
      while (pos <= lista.getTamanho() && item.compareTo(lista.getItem(pos)) > 0) {
        pos++;
      }
      lista.insereItem(item, pos);
      if (pos < lista.getTamanho() && lista.getItem(pos + 1).equals(item)) {
        lista.removeItem(pos);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}


