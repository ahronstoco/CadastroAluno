package dao;
import java.util.ArrayList;
import modelo.Aluno;

public class AlunoDAO {
public static ArrayList<Aluno> minhalista = new ArrayList<>();    
     public static ArrayList<Aluno> getMinhaLista() {
        return minhalista;
 }
 public static void setMinhaLista(ArrayList<Aluno> minhaLista) {
    AlunoDAO.minhalista= minhaLista;
 }
 public static int maiorID() {
    int maiorID= 0;
    for (int i = 0; i < minhalista.size(); i++) {
        if (minhalista.get(i).getId() > maiorID) {
        maiorID = minhalista.get(i).getId();
 }
 }
    return maiorID;
 }
 }