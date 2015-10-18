package mpoo.ufrpe.projetoalergia.negocio;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import mpoo.ufrpe.projetoalergia.dao.UsuarioDAO;
import mpoo.ufrpe.projetoalergia.dominio.dominioPessoa.Usuario;
import mpoo.ufrpe.projetoalergia.dominio.dominioPessoa.Pessoa;
/**
 * Created by Allan on 15/10/2015.
 */
public class UsuarioNegocio {

    private static UsuarioNegocio instancia = new UsuarioNegocio();
    private UsuarioNegocio() {}
    public static UsuarioNegocio getInstancia() {
        return instancia;
    }

    private UsuarioDAO dao = UsuarioDAO.getInstancia();


    public void fazerLogin(String login, String senha) throws Exception{
        Usuario usuario = dao.buscarUsuario(login);
        StringBuilder builder = new StringBuilder();
        if (usuario == null){
            builder.append("usuario não existe");
        } else if (!usuario.getSenha().equals(senha)){
            builder.append("login ou senha incorretos");
        }

        if (builder.length() > 0){
            throw new Exception(builder.toString());
        }
    }

    public void validarCadastro(Pessoa pessoa) throws Exception{
        Usuario usuario = dao.buscarUsuario(pessoa.getUsuario().getLogin());
        StringBuilder builder = new StringBuilder();

        if (usuario != null){
            builder.append("Esse usuario já está cadastrado");
        } else {
            dao.cadastrarUsuario(pessoa);
        }



        if (builder.length() > 0){
            throw new Exception(builder.toString());
        }

    }


    public void validarString(String login)throws Exception{
        Pattern pattern = Pattern.compile("\\s+");
        Matcher matcher = pattern.matcher(login);
        if(matcher.find()){
            String messagem = "O login não deve conter espaço";
            throw new Exception(messagem);
        }
    }

    public void inserirUsuario(){
        dao.inserirUsuario();
    }

}
