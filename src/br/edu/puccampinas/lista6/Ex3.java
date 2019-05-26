package br.edu.puccampinas.lista6;

public class Ex3 {

  public static void main(String[] args) {
    ArvoreBinariaBalanceada<Integer> arvore = new ArvoreBinariaBalanceada<Integer>();
    try {
      arvore.insereItem(1);
      arvore.insereItem(3);
      arvore.insereItem(4);
      arvore.insereItem(5);
      arvore.insereItem(8);
      arvore.insereItem(9);
      arvore.emOrdem();
      System.out.println(new String(new char[50]).replace("\0", "*"));
      arvore.removeFolhas();
      arvore.emOrdem();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

/*  
  Métodos implementados na classe ArvoreBinariaBalanceada do exercício 3
  */
  
  /**
   * Encontra os nós folhas (o qual não possui nós filhos) e os remove.
   *//*
  public void removeFolhas() {
    removeFolhas(this.raiz);
  }

  private void removeFolhas(No noAtual) {
    // Uma árvore vazia é completa
    if (noAtual != null) {
      // Nó folha
      if (noAtual.esquerdo == null && noAtual.direito == null) {
        try {
          this.removeItem(noAtual.getItem());
        } catch (Exception e) {
        }
        return;
      }
      removeFolhas(noAtual.esquerdo);
      removeFolhas(noAtual.direito);
    }
  }
  
  */
  
}
