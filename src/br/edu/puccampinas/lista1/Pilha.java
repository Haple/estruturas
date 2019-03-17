package br.edu.puccampinas.lista1;

public class Pilha {

    private Object[] pilha; // vetor de objetos
    private int tamanho; // indicador de topo

    // construtor
    public Pilha(int qtde) {
        //indica que está vazia, pois o topo é a primeira posição
        this.tamanho = 0;
        //criando uma pilha com a quantidade de posições informada
        this.pilha = new Object[qtde];
    }

    // push
    public boolean empilhar(Object valor) {
        if (!this.pilhaCheia()) {
            this.pilha[this.tamanho] = valor;
            this.tamanho++;
            return true;
        }
        return false;
    }

    // pop
    public Object desempilhar() {
        if (this.pilhaVazia()) {
            return null;
        }
        this.tamanho--;
        return this.pilha[this.tamanho];
    }

    // isEmpty
    public boolean pilhaVazia() {
        if (this.tamanho == 0) {
            return true;
        }
        return false;
    }

    // isFull
    public boolean pilhaCheia() {
        if (this.tamanho > this.pilha.length - 1) {
            return true;
        }
        return false;
    }

    // peek
    public Object exibeTopo() {
        if (this.pilhaVazia()) {
            return null;
        }
        return this.pilha[this.tamanho - 1];
    }

    // size
    public int quantosElementos() {
        return this.tamanho;
    }

}
