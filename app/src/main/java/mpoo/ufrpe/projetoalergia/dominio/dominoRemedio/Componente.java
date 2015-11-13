package mpoo.ufrpe.projetoalergia.dominio.dominoRemedio;

import java.text.Collator;
import java.util.Locale;

/**
 * Created by Allan on 16/10/2015.
 */

public class Componente implements Comparable<Componente> {

    private int id;
    private Float peso;
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

    public String toString() {
        return nome + "        " + peso;
    }

    @Override
    public int compareTo(Componente componente) {
        Collator cot = Collator.getInstance(new Locale("pt", "BR"));
        if (componente != null) {
            return cot.compare(this.getNome(),componente.getNome());
        } else {
            return 0;
        }

    }

}

