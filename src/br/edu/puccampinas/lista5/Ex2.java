package br.edu.puccampinas.lista5;

public class Ex2 {

  public static void main(String[] args) {
    try {
      // Entrada
      Lista<Integer> l1 = new Lista<Integer>();
      l1.insereItem(1);
      l1.insereItem(2);
      l1.insereItem(3);
      l1.insereItem(4);
      l1.insereItem(5);
      Lista<Integer> l2 = new Lista<Integer>();
      l2.insereItem(0);
      l2.insereItem(3);
      l2.insereItem(4);
      l2.insereItem(5);
      // Solução
      if (l1.getItem(l1.getTamanho()).equals(l2.getItem(l2.getTamanho()))) {
        // loop começa no fim
        int pontoDeMerge = l1.getItem();
        for (int i = l1.getTamanho(), j = l2.getTamanho(); i >= 1 && j >= 1; i--, j--) {
          if (l1.getItem(i).equals(l2.getItem(j))) {
            pontoDeMerge = l1.getItem(i);
          } else {
            break;
          }
        }
        System.out.println("Ponto de merge: " + pontoDeMerge);
      } else if (l1.getItem().equals(l2.getItem())) {
        // loop começa no início
        int pontoDeMerge = l1.getItem(l1.getTamanho());
        for (int i = 1, j = 1; i < l1.getTamanho() && j < l2.getTamanho(); i++, j++) {
          if (l1.getItem(i).equals(l2.getItem(j))) {
            pontoDeMerge = l1.getItem(i);
          } else {
            break;
          }
        }
        System.out.println("Ponto de merge: " + pontoDeMerge);
      } else {
        System.out.println("Sem ponto de merge");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
