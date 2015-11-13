package mpoo.ufrpe.projetoalergia.dominio.dominoRemedio;

/**
 * Created by Airton on 08/11/2015.
 */
public class RemedioDTO {

    private int id;
    private String nome;
    private int idIcone;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdIcone() {
        return idIcone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdIcone(int idIcone) {
        this.idIcone = idIcone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString(){
        return nome;
    }

}
