package br.edu.puccampinas.lista6;

public class Ex1 {

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
      arvore.geraEspelho();
      arvore.emOrdem();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
 
/*  
  Métodos implementados na classe ArvoreBinariaBalanceada do exercício 1
  */
  
  /**
   * Para cada nó da árvore, os nós filhos são invertidos.
   * 
   * @throws Exception caso a árvore esteja vazia
   *//*
  public void geraEspelho() throws Exception {
    if (this.isVazia())
      throw new Exception("Nada guardado");
    this.geraEspelho(this.raiz);
  }

  private void geraEspelho(No noAtual) {
    if (noAtual != null) {
      No temp = noAtual.esquerdo;
      noAtual.esquerdo = noAtual.direito;
      noAtual.direito = temp;

      this.geraEspelho(noAtual.getEsquerdo());
      this.geraEspelho(noAtual.getDireito());
    }
  }

  
  */
  
}
