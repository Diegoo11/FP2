package teoria.homework08;

public class Comentario {
  private String comentario;
  private String estado;

  public void setComentario(String str) { comentario = str; }
  public String getComentario() { return comentario; }

  public void setEstado(String str) { estado = str; }
  public String getEstado() { return estado; }

  public String toString() {
    return "Comentario: " + comentario + " Estado: " + estado;
  }
}
