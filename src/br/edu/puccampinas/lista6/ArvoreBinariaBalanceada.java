package br.edu.puccampinas.lista6;

public class ArvoreBinariaBalanceada<TipoItem extends Comparable<TipoItem>> {
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

  public ArvoreBinariaBalanceada() {
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
    // 1. inserção do nó (mesmo código de inserção da classe ArvoreBinaria)
    if (noAtual == null)
      return new No(item, null, null);

    if (item.compareTo(noAtual.getItem()) == 0)
      throw new Exception("Valor já se encontra na árvore");

    if (item.compareTo(noAtual.getItem()) < 0)
      noAtual.setEsquerdo(insereItem(item, noAtual.getEsquerdo()));
    else
      noAtual.setDireito(insereItem(item, noAtual.getDireito()));

    // 2. obtém balanceamento do nó
    int balanceamento = this.getBalanceamento(noAtual);

    // 3. Verifica se o nó está desbalanceado e aplica a rotação
    // a) Esquerdo-Esquerdo
    if (balanceamento > 1 && item.compareTo(noAtual.getEsquerdo().getItem()) < 0)
      return this.rotacaoDireita(noAtual);

    // b) Esquerdo-Direito
    if (balanceamento > 1 && item.compareTo(noAtual.getEsquerdo().getItem()) > 0) {
      noAtual.setEsquerdo(this.rotacaoEsquerda(noAtual.getEsquerdo()));
      return this.rotacaoDireita(noAtual);
    }

    // c) Direito-Direito
    if (balanceamento < -1 && item.compareTo(noAtual.getDireito().getItem()) > 0)
      return this.rotacaoEsquerda(noAtual);

    // d) Direito-Esquerdo
    if (balanceamento < -1 && item.compareTo(noAtual.getDireito().getItem()) < 0) {
      noAtual.setDireito(this.rotacaoDireita(noAtual.getDireito()));
      return this.rotacaoEsquerda(noAtual);
    }

    // retorna o nó
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

    // 2. obtém balanceamento do nó
    int balanceamento = this.getBalanceamento(noAtual);

    // 3. Verifica se o nó está desbalanceado e aplica a rotação
    // a) Esquerdo-Esquerdo
    if (balanceamento > 1 && this.getBalanceamento(noAtual.getEsquerdo()) >= 0)
      return this.rotacaoDireita(noAtual);

    // b) Esquerdo-Direito
    if (balanceamento > 1 && this.getBalanceamento(noAtual.getEsquerdo()) < 0) {
      noAtual.setEsquerdo(this.rotacaoEsquerda(noAtual.getEsquerdo()));
      return this.rotacaoDireita(noAtual);
    }

    // c) Direito-Direito
    if (balanceamento < -1 && this.getBalanceamento(noAtual.getDireito()) <= 0)
      return this.rotacaoEsquerda(noAtual);

    // d) Direito-Esquerdo
    if (balanceamento < -1 && this.getBalanceamento(noAtual.getDireito()) > 0) {
      noAtual.setDireito(this.rotacaoDireita(noAtual.getDireito()));
      return this.rotacaoEsquerda(noAtual);
    }

    return noAtual;
  }

  // obtém o menor valor de uma árvore (ou subárvore)
  private No menor(No noAtual) {
    if (noAtual.getEsquerdo() == null)
      return noAtual;

    return menor(noAtual.getEsquerdo());
  }

  // verifica se a árvore está vazia
  public boolean isVazia() {
    return this.raiz == null;
  }

  // retorna a qtde de nós da árvore
  public int getTamanho() {
    return this.tamanho;
  }

  // retorna a altura da árvore
  public int getAltura() {
    // chama função recursiva para determinar a altura da árvore a partir da raiz
    return this.getAltura(this.raiz);
  }

  private int getAltura(No noAtual) {
    // se o noAtual é nulo, a árvore está vazia
    if (noAtual == null)
      return 0;

    // calcula altura das subarvores esquerda e direita
    int alturaEsquerda = getAltura(noAtual.getEsquerdo());
    int alturaDireita = getAltura(noAtual.getDireito());

    // verifica qual das duas alturas é maior e retorna
    if (alturaEsquerda > alturaDireita)
      return 1 + alturaEsquerda;

    return 1 + alturaDireita;
  }

  /**
   * Para cada nó da árvore, os nós filhos são invertidos.
   * 
   * @throws Exception caso a árvore esteja vazia
   */
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

  // exibe os nós em ordem
  public void emOrdem() throws Exception {
    if (this.isVazia())
      throw new Exception("Nada guardado");
    this.emOrdem(this.raiz);
  }

  private void emOrdem(No noAtual) {
    if (noAtual != null) {
      this.emOrdem(noAtual.getEsquerdo());
      System.out.println(noAtual.getItem());
      this.emOrdem(noAtual.getDireito());
    }
  }

  // exibe os nós em pré-ordem
  public void preOrdem() throws Exception {
    if (this.isVazia())
      throw new Exception("Nada guardado");
    this.preOrdem(this.raiz);
  }

  private void preOrdem(No noAtual) {
    if (noAtual != null) {
      System.out.println(noAtual.getItem());
      this.preOrdem(noAtual.getEsquerdo());
      this.preOrdem(noAtual.getDireito());
    }
  }

  // exibe os nós em pós-ordem
  public void posOrdem() throws Exception {
    if (this.isVazia())
      throw new Exception("Nada guardado");
    this.posOrdem(this.raiz);
  }

  private void posOrdem(No noAtual) {
    if (noAtual != null) {
      this.posOrdem(noAtual.getEsquerdo());
      this.posOrdem(noAtual.getDireito());
      System.out.println(noAtual.getItem());
    }
  }

  // retorna o balanceamento da árvore
  public int getBalanceamento() {
    if (this.isVazia())
      return 0;
    return this.getBalanceamento(this.raiz);
  }

  private int getBalanceamento(No noAtual) {
    if (noAtual == null)
      return 0;
    return this.getAltura(noAtual.getEsquerdo()) - getAltura(noAtual.getDireito());
  }

  // rotaciona a árvore um nó à direita
  public void rotacaoDireita() throws Exception {
    if (this.isVazia())
      throw new Exception("Nada guardado");
    this.raiz = this.rotacaoDireita(this.raiz);
  }

  private No rotacaoDireita(No noAtual) {
    No novaRaiz = noAtual.getEsquerdo();
    No aux = novaRaiz.getDireito();

    // rotacionar à direita
    novaRaiz.setDireito(noAtual);
    noAtual.setEsquerdo(aux);

    // retorna a nova raiz
    return novaRaiz;
  }

  // rotaciona a árvore um nó à esquerda
  public void rotacaoEsquerda() throws Exception {
    if (this.isVazia())
      throw new Exception("Nada guardado");
    this.raiz = this.rotacaoEsquerda(this.raiz);
  }

  private No rotacaoEsquerda(No noAtual) {
    No novaRaiz = noAtual.getDireito();
    No aux = novaRaiz.getEsquerdo();

    // rotacionar à esquerda
    novaRaiz.setEsquerdo(noAtual);
    noAtual.setDireito(aux);

    // retorna a nova raiz
    return novaRaiz;
  }
}
