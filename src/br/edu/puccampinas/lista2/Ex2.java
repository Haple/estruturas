package br.edu.puccampinas.lista2;

public class Ex2 {
  public static void main(String[] args) {
    try {
      System.out.print("Digite a quantidade de elementos da pilha: ");
      int n = Teclado.getUmInt();
      Pilha<Integer> pilha = new Pilha<Integer>(n);
      for (int i = 0; i < n; i++) {
        System.out.print("Elemento " + (i + 1) + ": ");
        pilha.empilhar(Teclado.getUmInt());
      }
      System.out.println("------------------------------------");
      Pilha<Integer> aux = new Pilha<Integer>(n);
      Integer primeiro = pilha.desempilhar();
      aux.empilhar(primeiro);
      int maior = primeiro;
      int menor = primeiro;
      while (!pilha.pilhaVazia()) {
        int valor = (int) pilha.exibeTopo();
        if (valor > maior) {
          maior = valor;
          aux.empilhar(valor);
        } else if (valor < menor) {
          menor = valor;
          aux.empilhar(valor);
        } else if (valor < maior && valor > menor) {
          aux.empilhar(valor);
        }
        pilha.desempilhar();
      }
      while (!aux.pilhaVazia()) {
        pilha.empilhar(aux.desempilhar());
        System.out.println("Elemento " + pilha.getTotal() + ": " + pilha.exibeTopo());
      }
      System.out.println("O maior elemento da pilha é: " + maior);
      System.out.println("O menor elemento da pilha é: " + menor);
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}
