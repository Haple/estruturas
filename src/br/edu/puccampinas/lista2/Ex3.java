package br.edu.puccampinas.lista2;

/**
 * Exercício da segunda lista
 * 
 * @author aleph
 *
 */
public class Ex3 {

  /**
   * Driver de testes
   * 
   * @param args
   */
  public static void main(String[] args) {
    // Entrada
    Pilha<Integer> p = new Pilha<Integer>(7);
    p.empilhar(12);
    p.empilhar(102);
    p.empilhar(14);
    p.empilhar(76);
    p.empilhar(45);
    p.empilhar(13);
    p.empilhar(12);
    // Solução
    Pilha<Integer> aux = new Pilha<Integer>(p.getTotal());
    while (!p.pilhaVazia()) {
      Integer tmp = p.desempilhar();
      while (!aux.pilhaVazia() && aux.exibeTopo() > tmp) {
        p.empilhar(aux.desempilhar());
      }
      aux.empilhar(tmp);
    }
    while (!aux.pilhaVazia()) {
      p.empilhar(aux.desempilhar());
    }
    // Exibição
    System.out.println("Pilha ordenada: ");
    while (!p.pilhaVazia()) {
      System.out.println(p.desempilhar());
    }
  }
}
