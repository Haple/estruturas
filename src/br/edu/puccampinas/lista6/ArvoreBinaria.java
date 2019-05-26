package br.edu.puccampinas.lista6;

public class ArvoreBinaria<TipoItem extends Comparable<TipoItem>> {
  private class No {
    private TipoItem item;
    private No esquerdo;
    private No direito;

    public No(TipoItem item, No esquerdo, No direito) {
      this.item = item;
      this.esquerdo = esquerdo;
      this.direito = direito;
    }

    public TipoItem getItem() {
      return this.item;
    }

    public No getEsquerdo() {
      return this.esquerdo;
    }

    public No getDireito() {
      return this.direito;
    }

    @SuppressWarnings("unused")
    public void setItem(TipoItem item) {
      this.item = item;
    }

    public void setEsquerdo(No esquerdo) {
      this.esquerdo = esquerdo;
    }

    public void setDireito(No direito) {
      this.direito = direito;
    }
  } // fim da classe No

  private No raiz;
  private int tamanho;

  public ArvoreBinaria() {
    this.raiz = null;
    this.tamanho = 0;
  }

  // insere um item na árvore
  public void insereItem(TipoItem item) throws Exception {
    if (item == null)
      throw new Exception("Valor ausente");

    this.raiz = this.insereItem(item, this.raiz);

    this.tamanho++;
  }

  private No insereItem(TipoItem item, No noAtual) throws Exception {
    if (noAtual == null)
      return new No(item, null, null);

    if (item.compareTo(noAtual.getItem()) == 0)
      throw new Exception("Valor já se encontra na árvore");

    if (item.compareTo(noAtual.getItem()) < 0)
      noAtual.setEsquerdo(insereItem(item, noAtual.getEsquerdo()));
    else
      noAtual.setDireito(insereItem(item, noAtual.getDireito()));

    return noAtual;
  }

  // verifica se um item está na árvore
  public TipoItem getItem(TipoItem item) throws Exception {
    if (this.isVazia())
      throw new Exception("Nada guardado");

    return this.getItem(item, this.raiz);
  }

  public TipoItem getItem(TipoItem item, No noAtual) throws Exception {
    if (noAtual == null)
      throw new Exception("Item não está na árvore");

    if (item.compareTo(noAtual.getItem()) == 0)
      return noAtual.getItem();

    if (item.compareTo(noAtual.getItem()) < 0)
      return this.getItem(item, noAtual.getEsquerdo());
    else
      return this.getItem(item, noAtual.getDireito());
  }

  // remove um item da árvore
  public void removeItem(TipoItem item) throws Exception {
    if (this.isVazia())
      throw new Exception("Nada guardado");

    this.raiz = this.removeItem(item, this.raiz);
    this.tamanho--;

  }

  private No removeItem(TipoItem item, No noAtual) throws Exception {
    // item não encontrado
    if (noAtual == null)
      throw new Exception("Item não está na árvore");

    // busca o item a ser removido na subárvore da esquerda ou da direita
    if (item.compareTo(noAtual.getItem()) < 0)
      noAtual.setEsquerdo(this.removeItem(item, noAtual.getEsquerdo()));
    else if (item.compareTo(noAtual.getItem()) > 0)
      noAtual.setDireito(this.removeItem(item, noAtual.getDireito()));
    else { // item encontrado
      // casos 1 e 2: nó folha (retorna null) ou com apenas um filho (retorna o filho)
      if (noAtual.getEsquerdo() == null)
        return noAtual.getDireito();
      if (noAtual.getDireito() == null)
        return noAtual.getEsquerdo();

      // caso 3: nó com dois filhos, busca o sucessor (menor)
      No menor = menor(noAtual.getDireito());
      // copia o sucessor para o elemento atual
      noAtual.setItem(menor.getItem());
      // deleta o sucessor
      noAtual.setDireito(removeItem(menor.getItem(), noAtual.getDireito()));
    }

    return noAtual;
  }

  // obtém o menor valor de uma árvore (ou subárvore)
  private No menor(No noAtual) {
    if (noAtual.getEsquerdo() == null)
      return noAtual;

    return menor(noAtual.getEsquerdo());
  }

  public boolean isVazia() {
    return this.raiz == null;
  }

  public int getTamanho() {
    return this.tamanho;
  }
}

