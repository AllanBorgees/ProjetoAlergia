package mpoo.ufrpe.projetoalergia.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.SimpleDateFormat;

import mpoo.ufrpe.projetoalergia.dominio.dominioPessoa.Pessoa;
import mpoo.ufrpe.projetoalergia.dominio.dominioPessoa.Usuario;
import mpoo.ufrpe.projetoalergia.gui.LoginActivity;

/**
 * Created by Allan on 16/10/2015.
 */
public class UsuarioDAO {
    private static UsuarioDAO instancia = new UsuarioDAO();
    private UsuarioDAO() {}
    public static UsuarioDAO getInstancia() {
        return instancia;
    }
    private Helper helper = new Helper(LoginActivity.getContexto());
    private SQLiteDatabase db;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

    public Usuario buscarUsuario(String login){
        Usuario usuario = null;
        db = helper.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + Helper.TABELA_USUARIO +
                " WHERE " + Helper.USUARIO_LOGIN + " =?", new String[]{login});
        if (cursor.moveToFirst()){
            usuario = criarUsuario(cursor);
        }
        db.close();
        return usuario;
    }
    public Pessoa buscarCpf(String cpf){
        Pessoa pessoa = null;
        db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Helper.TABELA_PESSOA +
                " WHERE " + Helper.PESSOA_CPF + " = ? ", new String[]{cpf});
        if (cursor.moveToFirst()) {
            pessoa = new Pessoa();
            pessoa.setId(cursor.getInt(0));
            pessoa.setNome(cursor.getString(1));
            pessoa.setCpf(cursor.getString(2));
        }
        return pessoa;
    }

    public void cadastrarUsuario(Pessoa pessoa){
        db = helper.getWritableDatabase();

        dateFormat.applyPattern("MM-dd-yy");

        ContentValues values = new ContentValues();
        values.put(Helper.PESSOA_NOME, pessoa.getNome());
        values.put(Helper.PESSOA_CPF, pessoa.getCpf());
        values.put(Helper.PESSOA_DATA,dateFormat.format(pessoa.getDataDeNascimento()));

        long fk_id_pessoa = db.insert(Helper.TABELA_PESSOA, null, values);

        values = new ContentValues();

        values.put(Helper.USUARIO_LOGIN, pessoa.getUsuario().getLogin());
        values.put(Helper.USUARIO_SENHA, pessoa.getUsuario().getSenha());
        values.put(Helper.USUARIO_PESSOA_ID,fk_id_pessoa);
        db.insert(Helper.TABELA_USUARIO, null, values);

        db.close();

    }

    private Usuario criarUsuario(Cursor cursor) {
        Usuario usuario = new Usuario();
        usuario.setId(cursor.getInt(0));
        usuario.setLogin(cursor.getString(1));
        usuario.setSenha(cursor.getString(2));

        return usuario;
    }

}
