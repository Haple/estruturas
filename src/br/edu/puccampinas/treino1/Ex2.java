package br.edu.puccampinas.treino1;

public class Ex2 {

  public static void main(String[] args) {
    // Entrada
    Pilha<Integer> p1 = new Pilha<Integer>();
    p1.empilhar(32);
    p1.empilhar(4);
    p1.empilhar(23);
    p1.empilhar(32);
    p1.empilhar(16);
    p1.empilhar(23);
    System.out.println("Pilha 1: " + p1);
    Pilha<Integer> p2 = new Pilha<Integer>();
    p2.empilhar(16);
    p2.empilhar(23);
    p2.empilhar(199);
    p2.empilhar(45);
    p2.empilhar(1);
    p2.empilhar(32);
    System.out.println("Pilha 2: " + p2);
    // Solução
    Pilha<Integer> interseccao = new Pilha<Integer>();
    interseccao = extraiInterseccao(p1, p2);
    // Exibição do resultado
    System.out.println("Intersecções: " + interseccao);

  }

  /**
   * Organiza uma Pilha de números inteiros, deixando a base com o menor elemento e o topo com o
   * maior
   * 
   * @param pilha Pilha a ser organizada
   * @return Devolve uma pilha organizada
   */
  private static Pilha<Integer> organizaPilha(Pilha<Integer> pilha) {
    Pilha<Integer> desorganizada = new Pilha<Integer>(pilha);
    Pilha<Integer> organizada = new Pilha<Integer>();
    while (!desorganizada.pilhaVazia()) {
      Integer temp = desorganizada.desempilhar();
      while (!organizada.pilhaVazia() && organizada.exibeTopo() > temp) {
        desorganizada.empilhar(organizada.desempilhar());
      }
      // Empilha o menor elemento na pilha organizada
      organizada.empilhar(temp);
    }
    return organizada;
  }

  /**
   * Extrai a interseção entre os valores de duas pilhas de inteiros ordenados
   * 
   * @param p1 Primeira pilha de inteiros ordenados
   * @param p2 Segunda pilha de inteiros ordenados
   * @return Devolve uma pilha com as interseções entre as duas pilhas
   */
  private static Pilha<Integer> extraiInterseccao(Pilha<Integer> pilha1, Pilha<Integer> pilha2) {
    Pilha<Integer> p1 = new Pilha<Integer>(organizaPilha(pilha1));
    Pilha<Integer> p2 = new Pilha<Integer>(organizaPilha(pilha2));
    Pilha<Integer> interseccoes = new Pilha<Integer>();
    while (!p1.pilhaVazia() && !p2.pilhaVazia()) {
      if (p1.exibeTopo() > p2.exibeTopo()) {
        p1.desempilhar();
      } else if (p1.exibeTopo() < p2.exibeTopo()) {
        p2.desempilhar();
      } else if (p1.exibeTopo() == p2.exibeTopo()) {
        interseccoes.empilhar(p1.desempilhar());
        p2.desempilhar();
      }
    }
    return interseccoes;
  }

}
