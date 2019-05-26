package br.edu.puccampinas.lista6;

public class Ex2 {

  public static void main(String[] args) {
    ArvoreBinariaBalanceada<Integer> arvore = new ArvoreBinariaBalanceada<Integer>();
    try {
      arvore.insereItem(1);
      arvore.insereItem(3);
      arvore.insereItem(4);
      System.out.println(new String(new char[50]).replace("\0", "*"));
      System.out.println("É completa: " + arvore.isCompleta());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  
/*
  Métodos implementados na classe ArvoreBinariaBalanceada do exercício 2
  */
  
  /**
   * Verifica se uma árvore é completa
   * 
   * @return 0 se for completa, 1 caso contrário
   *//*
  public int isCompleta() {
    int alturaRaiz = this.getAltura(this.raiz);
    return isCompleta(this.raiz, alturaRaiz, 0);
  }

  private int isCompleta(No noAtual, int alturaRaiz, int nivelAnterior) {
    // Uma árvore vazia é completa
    if (noAtual == null)
      return 1;

    // Nó folha
    if (noAtual.esquerdo == null && noAtual.direito == null) {
      if (alturaRaiz == nivelAnterior + 1)
        return 1;
      else
        return 0;
    }

    // Se não é folha e tem um nó nulo a árvore nó completa
    if (noAtual.esquerdo == null || noAtual.direito == null)
      return 0;

    if (isCompleta(noAtual.esquerdo, alturaRaiz, nivelAnterior + 1) == 1
        && isCompleta(noAtual.direito, alturaRaiz, nivelAnterior + 1) == 1) {
      return 1;
    } else {
      return 0;
    }
  }
  
  
  */
  
  
  
}
