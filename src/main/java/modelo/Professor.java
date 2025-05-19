package modelo;

public class Professor extends Pessoa{
    private double salario;
    private String titulo;
    
    public Professor(){
        this(0, "",0,0.0,"");
    }
    
    public Professor(int id, String nome, int idade, double salario, String titulo ) {
        super(id, nome, idade);
        this.salario = salario;
        this.titulo = titulo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return super.toString() + ", salario=" + salario + ", titulo=" + titulo + "\n";
    }
}
