package br.edu.puccampinas.lista4;

public class Registro {
  private String valor;
  private int prioridade;

  public Registro(String valor, int prioridade) {
    this.valor = valor;
    this.prioridade = prioridade;
  }

  public String getValor() {
    return valor;
  }

  public void setValor(String valor) {
    this.valor = valor;
  }

  public int getPrioridade() {
    return prioridade;
  }

  public void setPrioridade(int prioridade) {
    this.prioridade = prioridade;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + prioridade;
    result = prime * result + ((valor == null) ? 0 : valor.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Registro other = (Registro) obj;
    if (prioridade != other.prioridade)
      return false;
    if (valor == null) {
      if (other.valor != null)
        return false;
    } else if (!valor.equals(other.valor))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Registro [valor=" + valor + ", prioridade=" + prioridade + "]";
  }

}
