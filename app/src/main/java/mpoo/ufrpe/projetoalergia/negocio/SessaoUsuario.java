package mpoo.ufrpe.projetoalergia.negocio;

import mpoo.ufrpe.projetoalergia.dominio.dominioPessoa.Usuario;

/**
 * Created by Carlos Ivan on 28/10/2015.
 */
public class SessaoUsuario {
    private Usuario usuarioLogado;
    private static SessaoUsuario instancia = new SessaoUsuario();
    private SessaoUsuario(){}
    public static SessaoUsuario getInstancia() {
        return instancia;
    }

    public void setUsuarioLogado(Usuario usuario) {
        this.usuarioLogado = usuario;
    }
}
