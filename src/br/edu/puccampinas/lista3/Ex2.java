package br.edu.puccampinas.lista3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2 {

  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int brindes = 0;
    try {
      int participantes = Integer.parseInt(br.readLine());
      Pilha<Character> painel = new Pilha<Character>();
      for (int i = 0; i < participantes; i++) {
        // OBS: o método empilhar foi modificado para retornar a própria Pilha
        if (painel.pilhaVazia())
          painel.empilhar('F').empilhar('A').empilhar('C').empilhar('E');
        // Busca as 4 últimas letras do painel
        Pilha<Character> tmp = new Pilha<Character>();
        for (int j = 0; j < 4; j++)
          tmp.empilhar(painel.desempilhar());
        // Carrega as letras do participante separadas por espaço
        String entrada = br.readLine();
        Pilha<Character> combinacao = new Pilha<Character>();
        for (int j = 0; j < 7; j = j + 2)
          combinacao.empilhar(entrada.charAt(j));
        // Se as letras do participantes forem iguais ao inverso
        // das 4 últimas letras do painel (tmp), mais um brinde deve
        // ser oferecido
        if (tmp.equals(combinacao)) {
          brindes++;
        } else {
          // Devolve os itens retirados do painel
          while (!tmp.pilhaVazia())
            painel.empilhar(tmp.desempilhar());
          // Inverte a entrada aproveitando a pilha tmp
          while (!combinacao.pilhaVazia())
            tmp.empilhar(combinacao.desempilhar());
          // Add letras do participante no painel
          while (!tmp.pilhaVazia())
            painel.empilhar(tmp.desempilhar());
        }
      }
    } catch (IOException e) {
      System.err.println("Não foi possível ler a entrada!");
    }
    System.out.println(brindes);
  }

}
