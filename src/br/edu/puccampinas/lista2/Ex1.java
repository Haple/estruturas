package br.edu.puccampinas.lista2;

/**
 * Exercício 1 da segunda lista
 * 
 * @author aleph
 *
 */
public class Ex1 {

  /**
   * Driver de testes
   * 
   * @param args
   */
  public static void main(String[] args) {
    // Entrada
    Pilha<Integer> p = new Pilha<Integer>(5);
    p.empilhar(1); // Base
    p.empilhar(2);
    p.empilhar(3);
    p.empilhar(4);
    p.empilhar(5); // Topo
    // Solução
    Pilha<Integer> aux1 = new Pilha<Integer>(p.getTotal());
    Pilha<Integer> aux2 = new Pilha<Integer>(p.getTotal());
    while(!p.pilhaVazia()) {
      aux1.empilhar(p.desempilhar());
    }
    while(!aux1.pilhaVazia()) {
      aux2.empilhar(aux1.desempilhar());
    }
    while(!aux2.pilhaVazia()) {
      p.empilhar(aux2.desempilhar());
    }
    // Exibição
    System.out.println("Pilha invertida: \n[Topo]");
    while (!p.pilhaVazia()) {
      System.out.println(p.desempilhar());
    }
    System.out.println("[Base]");
  }
}
