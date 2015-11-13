package mpoo.ufrpe.projetoalergia.negocio;

import mpoo.ufrpe.projetoalergia.dao.UsuarioDAO;
import mpoo.ufrpe.projetoalergia.dominio.dominioPessoa.Pessoa;
import mpoo.ufrpe.projetoalergia.dominio.dominioPessoa.Usuario;
import mpoo.ufrpe.projetoalergia.negocio.infra.ProjetoAlergiaException;
import mpoo.ufrpe.projetoalergia.negocio.infra.Util;

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

    public void fazerLogin(String login, String senha) throws ProjetoAlergiaException{
        Usuario usuario = dao.buscarUsuario(login);
        StringBuilder builder = new StringBuilder();
        Util.validarStringEspaco(login,"login");
        if (usuario == null){
            builder.append("usuario não existe");
        } else if (!usuario.getSenha().equals(senha)){
            builder.append("login ou senha incorretos");
        }

        if (builder.length() > 0){
            throw new ProjetoAlergiaException(builder.toString());
        }
        SessaoUsuario sessao = SessaoUsuario.getInstancia();
        sessao.setUsuarioLogado(usuario);

    }

    public void validarCadastro(Pessoa pessoa, String confirmarSenha) throws ProjetoAlergiaException{

        Usuario usuario = dao.buscarUsuario(pessoa.getUsuario().getLogin());
        Pessoa p = dao.buscarCpf(pessoa.getCpf());
        StringBuilder builder = new StringBuilder();

        Util.validarStringEspaco(pessoa.getUsuario().getLogin(),"login");
        Util.validarStringEspaco(pessoa.getUsuario().getSenha(),"senha");
        Util.isCPF(pessoa.getCpf());

        if (usuario != null){
            builder.append("Esse usuario já está cadastrado");
        }else if(p!=null){
            builder.append("CPF inválido");
        } else if(!pessoa.getUsuario().getSenha().equals(confirmarSenha)) {
            builder.append("Senha não confere");
        }else{
            dao.cadastrarUsuario(pessoa);
        }
        if (builder.length() > 0){
            throw new ProjetoAlergiaException(builder.toString());
        }
    }


    public void inserirUsuario(Pessoa pessoa){
        dao.cadastrarUsuario(pessoa);
    }
    




}
