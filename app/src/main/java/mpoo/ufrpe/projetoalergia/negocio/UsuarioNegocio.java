package mpoo.ufrpe.projetoalergia.negocio;

import android.text.TextUtils;

import java.util.InputMismatchException;
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

    public void validarCadastro(Pessoa pessoa, String confirmarSenha) throws Exception{

        Usuario usuario = dao.buscarUsuario(pessoa.getUsuario().getLogin());
        StringBuilder builder = new StringBuilder();

        if (usuario != null){
            builder.append("Esse usuario já está cadastrado");

        }else if(!isCPF(pessoa.getCpf())) {
            builder.append("cpf inválido");
        }else if(!pessoa.getUsuario().getSenha().equals(confirmarSenha)) {
            builder.append("Senha não confere");
        }else{
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

    public void inserirUsuario(Pessoa pessoa){
        dao.cadastrarUsuario(pessoa);
    }
    public boolean isCPF(String CPF) throws Exception{
        if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222") ||
            CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555") ||
            CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888") ||
            CPF.equals("99999999999") || (CPF.length() != 11)){


            return false;

        }
        char dig10, dig11;
        int sm, i, r, num, peso;
            sm = 0;
            peso = 10;

            for (i=0; i<9; i++) {
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1; }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else
                dig10 = (char)(r + 48);
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1; }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else
                dig11 = (char)(r + 48);
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                return true;
            else {
                 return false;
            }

    }
}
