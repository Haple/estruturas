package br.edu.puccampinas.lista1;

import java.io.IOException;

/**
 * Exercício 3
 * 
 * @author Aleph Santos Oliveira (18710509)
 */
public class Ex3 {

  /**
   * Programa principal para testar a função de extração de interseções
   * @param args the command line arguments
   */
  public static void main(String[] args) throws IOException {
    Pilha p1 = new Pilha(5);
    p1.empilhar(1);
    p1.empilhar(2);
    p1.empilhar(3);
    p1.empilhar(4);
    p1.empilhar(5);

    Pilha p2 = new Pilha(3);
    p2.empilhar(2);
    p2.empilhar(3);
    p2.empilhar(4);

    Pilha intersecoes = extraiIntersecao(p1, p2);

    /**
     * Exibe as pilhas finais
     */
    System.out.println("Interseções: ");
    while (!intersecoes.pilhaVazia()) {
      System.out.println(intersecoes.desempilhar());
    }
    System.out.println("Pilha1: ");
    while (!p1.pilhaVazia()) {
      System.out.println(p1.desempilhar());
    }
    System.out.println("Pilha2: ");
    while (!p2.pilhaVazia()) {
      System.out.println(p2.desempilhar());
    }
  }

  /**
   * Extrai a interseção entre os valores de duas pilhas de inteiros ordenados
   * 
   * @param p1 Primeira pilha de inteiros ordenados
   * @param p2 Segunda pilha de inteiros ordenados
   * @return Devolve uma pilha com as interseções entre as duas pilhas
   */
  private static Pilha extraiIntersecao(Pilha p1, Pilha p2) {
    Pilha aux1 = new Pilha(p1.quantosElementos());
    Pilha aux2 = new Pilha(p2.quantosElementos());
    // a pilha de interseções terá o tamanho da menor das pilhas
    Pilha intersecoes;
    if (p1.quantosElementos() > p2.quantosElementos()) {
      intersecoes = new Pilha(p2.quantosElementos());
    } else {
      intersecoes = new Pilha(p1.quantosElementos());
    }

    while (!p1.pilhaVazia() && !p2.pilhaVazia()) {
      // se a os topos forem iguais, temos uma interseção, caso contrário, desempilhamos o maior
      // topo entre as duas pilhas
      if ((int) p1.exibeTopo() > (int) p2.exibeTopo()) {
        aux1.empilhar(p1.desempilhar());
      } else if ((int) p1.exibeTopo() < (int) p2.exibeTopo()) {
        aux2.empilhar(p2.desempilhar());
      } else if ((int) p1.exibeTopo() == (int) p2.exibeTopo()) {
        int intersecao = (int) p1.desempilhar();
        intersecoes.empilhar(intersecao);
        aux1.empilhar(intersecao);
        aux2.empilhar(p2.desempilhar()); ;
      }
    }
    // reorganiza as pilhas originais
    while(!aux1.pilhaVazia()) {
      p1.empilhar(aux1.desempilhar());
    }
    while(!aux2.pilhaVazia()) {
      p2.empilhar(aux2.desempilhar());
    }
    return intersecoes;
  }

}
