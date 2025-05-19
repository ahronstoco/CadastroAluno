 package modelo;

 import dao.AlunoDAO;
 import java.util.ArrayList;
 import java.util.Collections;
 import java.util.Comparator;

 public class Aluno extends Pessoa {
    private String curso;
    private int fase;
 // Construtor de Objeto Vazio
    public Aluno() {
     this(0,"",0,"",0);
    }
 // Construtor com parâmetro
 public Aluno(int id, String nome, int idade, String curso, int fase) {
 super(id, nome, idade);
 this.curso= curso;
 this.fase= fase;
 }
 // Métodos GET e SET
 public String getCurso() {
 return curso;
 }
 public void setCurso(String curso) {
 this.curso= curso;
 }
 public int getFase() {
 return fase;
 }
 public void setFase(int fase) {
 this.fase= fase;
 }
 @Override
 public String toString() {
 return super.toString() + "curso=" + curso + ", fase=" + fase + "\n";
 }
 /*ABAIXO OS MÉTODOS PARA USO JUNTO COM O DAO SIMULANDO
 A ESTRUTURA EM CAMADAS PARA USAR COM BANCOS DE DADOS. */
 // Retorna a Lista de Alunos(objetos)
 public ArrayList<Aluno>getMinhaLista() {
 return AlunoDAO.getMinhaLista();
 }
 // Cadastra novo aluno
 public boolean insertAlunoBD(String nome, int idade, String curso,int fase) {
 int id = this.maiorID() + 1;
 Aluno objeto = new Aluno(id, nome, idade,curso, fase);
 getMinhaLista().add(objeto);
 return true;
 }
 // Deleta um aluno específico pelo seu campo ID
 public boolean deleteAlunoBD(int id) {
 int indice = procuraIndice(id);
 if (indice != -1) {
     AlunoDAO.getMinhaLista().remove(indice);
     return true;
} else {
     return false;
 }
 }
  public boolean updateAlunoBD(int id, String nome, int idade, String curso, int fase) {
     Aluno objeto = new Aluno(id, nome, idade, curso, fase);
     int indice = this.procuraIndice(id);
     getMinhaLista().set(indice, objeto);
     return true;
      }
  public int procuraIndice(int id) {
      int indice = -1;
      for (int i = 0; i < AlunoDAO.getMinhaLista().size(); i++) {
          if (AlunoDAO.getMinhaLista().get(i).getId() == id) {
              indice = i;
          }
      }
      return indice;
  }
  public void classificar() {
      Collections.sort(AlunoDAO.getMinhaLista(), new Comparator(){
          @Override
          public int compare(Object o1, Object o2) {
              Aluno a1 = (Aluno) o1;
              Aluno a2 = (Aluno) o2;
              return a1.getNome().compareToIgnoreCase (a2.getNome());
          }
      });
  }
  public int maiorID() {
      return AlunoDAO.maiorID();
  }
 }