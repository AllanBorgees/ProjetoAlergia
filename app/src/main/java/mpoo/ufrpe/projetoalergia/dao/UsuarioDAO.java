package mpoo.ufrpe.projetoalergia.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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

    public Usuario buscarUsuario(String login){
        Usuario usuario = null;
        db = helper.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + Helper.TABELA_USUARIO +
                " WHERE " + Helper.USUARIO_LOGIN + " =?", new String[]{login});
        if (cursor.moveToFirst()){
            usuario = new Usuario();
            usuario.setId(cursor.getInt(0));
            usuario.setLogin(cursor.getString(1));
            usuario.setSenha(cursor.getString(2));
        }
        db.close();
        return usuario;
    }

    public void cadastrarUsuario(Pessoa pessoa){
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Helper.PESSOA_NOME, pessoa.getNome());
        values.put(Helper.PESSOA_CPF, pessoa.getCpf());
        db.insert(Helper.TABELA_PESSOA, null, values);
        values = new ContentValues();
        values.put(Helper.USUARIO_LOGIN, pessoa.getUsuario().getLogin());
        values.put(Helper.USUARIO_SENHA, pessoa.getUsuario().getSenha());
        db.insert(Helper.TABELA_USUARIO, null, values);

        db.close();

    }


//    public void inserirUsuario(){
//        db = helper.getWritableDatabase();
//        db.execSQL("INSERT INTO " + Helper.TABELA_USUARIO + "("+Helper.USUARIO_LOGIN+","+Helper.USUARIO_SENHA +") VALUES ('allan', '123') ");
//        db.execSQL("INSERT INTO " + Helper.TABELA_USUARIO + "("+Helper.USUARIO_LOGIN+","+Helper.USUARIO_SENHA +") VALUES ('joao', '123') ");
//        db.execSQL("INSERT INTO " + Helper.TABELA_USUARIO + "("+Helper.USUARIO_LOGIN+","+Helper.USUARIO_SENHA +") VALUES ('carlos', '123') ");
//        db.execSQL("INSERT INTO " + Helper.TABELA_USUARIO + "("+Helper.USUARIO_LOGIN+","+Helper.USUARIO_SENHA +") VALUES ('airton', '123') ");
//        db.execSQL("INSERT INTO " + Helper.TABELA_USUARIO + "("+Helper.USUARIO_LOGIN+","+Helper.USUARIO_SENHA +") VALUES ('stefanie', '123') ");
//    }

}
