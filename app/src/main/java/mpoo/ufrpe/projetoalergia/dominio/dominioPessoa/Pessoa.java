package mpoo.ufrpe.projetoalergia.dominio.dominioPessoa;

import java.util.Calendar;
import java.util.List;

import mpoo.ufrpe.projetoalergia.dominio.dominoRemedio.Remedio;

/**
 * Created by Allan on 16/10/2015.
 */
public class Pessoa {

    private int id;
    private Usuario usuario;
    private String nome;
    private Calendar dataDeNascimento;
    private String cpf;
    private List<Remedio> remedio;

    public Pessoa(Usuario usuario, String nome, String cpf) {
        this.usuario = usuario;
        this.nome = nome;
        this.cpf = cpf;
    }

    public Pessoa(){

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Remedio> getRemedio() {
        return remedio;
    }

    public void setRemedio(List<Remedio> remedio) {
        this.remedio = remedio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Calendar dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
