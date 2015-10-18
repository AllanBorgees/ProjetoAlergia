package mpoo.ufrpe.projetoalergia.dominio.dominoRemedio;

import java.util.List;

/**
 * Created by Allan on 16/10/2015.
 */
public class Remedio {

    private String nome;
    private List<Componente> componentes;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(List<Componente> componentes) {
        this.componentes = componentes;
    }
}
