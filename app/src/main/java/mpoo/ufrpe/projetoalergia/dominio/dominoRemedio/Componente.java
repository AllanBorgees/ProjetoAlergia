package mpoo.ufrpe.projetoalergia.dominio.dominoRemedio;

/**
 * Created by Allan on 16/10/2015.
 */

public class Componente {

    private  int id;
    private float peso;
    private String nome;

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString()
    {
        return nome +"        "+peso;


    }
}

