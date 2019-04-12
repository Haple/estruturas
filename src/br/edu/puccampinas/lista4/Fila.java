package br.edu.puccampinas.lista4;

public class Fila<T> {
  private class No {
    private T item;
    private No proximo;

    public No(T item, No proximo) {
      this.item = item;
      this.proximo = proximo;
    }

    public T getItem() {
      return this.item;
    }

    public No getProximo() {
      return this.proximo;
    }

    @SuppressWarnings("unused")
    public void setItem(T item) {
      this.item = item;
    }

    public void setProximo(No proximo) {
      this.proximo = proximo;
    }
  } // fim da classe No

  private No primeiro, ultimo;
  private int tamanho;

  public Fila() {
    this.primeiro = null;
    this.ultimo = null;
    this.tamanho = 0;
  }

  // enqueue
  public void insereItem(T item) {
    if (item == null)
      throw new RuntimeException("Valor ausente");

    // guarda o atual ultimo da fila, antes da insercao (sera o penultimo)
    No penultimo = this.ultimo;

    // insere o novo item como ultimo da fila, com proximo null
    this.ultimo = new No(item, null);

    if (this.primeiro == null)
      // se a fila estiver vazia, atribui o ultimo ao primeiro também
      this.primeiro = this.ultimo;
    else
      // senão estiver vazia, define o próximo do penultimo como o ultimo
      penultimo.setProximo(this.ultimo);

    this.tamanho++;
  }

  // dequeue
  public void removeItem() {
    if (this.isVazia())
      throw new RuntimeException("Nada guardado");

    this.primeiro = this.primeiro.getProximo();
    this.tamanho--;
  }

  // first
  public T getItem() {
    if (this.isVazia())
      throw new RuntimeException("Nada guardado");

    return this.primeiro.getItem();
  }

  // isEmpty
  public boolean isVazia() {
    return this.primeiro == null;
  }

  // getSize
  public int getTamanho() {
    return this.tamanho;
  }
}
