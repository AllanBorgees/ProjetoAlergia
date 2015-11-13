package mpoo.ufrpe.projetoalergia.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import mpoo.ufrpe.projetoalergia.dominio.dominioPessoa.Pessoa;
import mpoo.ufrpe.projetoalergia.dominio.dominioPessoa.Usuario;
import mpoo.ufrpe.projetoalergia.dominio.dominoRemedio.RemedioDTO;
import mpoo.ufrpe.projetoalergia.gui.LoginActivity;
import mpoo.ufrpe.projetoalergia.negocio.SessaoUsuario;

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
    private SessaoUsuario sessao = SessaoUsuario.getInstancia();
    private Date data;


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
    public Pessoa buscarPessoaId(int id){
        Pessoa pessoa = null;
        db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Helper.TABELA_PESSOA +
                " WHERE " + Helper.PESSOA_ID + " =? ", new String[]{String.valueOf(id)});

        if (cursor.moveToFirst()) {
            pessoa = new Pessoa();
            pessoa.setId(cursor.getInt(0));
            pessoa.setNome(cursor.getString(1));
            pessoa.setCpf(cursor.getString(2));



            try {
               String dateTime = cursor.getString(cursor.getColumnIndexOrThrow(Helper.PESSOA_DATA));
               DateFormat df = new SimpleDateFormat("MM/dd/yy");
               if (dateTime.contains("-")){
                   String dates = dateTime.replace("-","/");
                   df.setLenient(false);
                   Date date = df.parse(dates);
                   pessoa.setDataDeNascimento(date);
                }

           }catch (Exception e){
               e.printStackTrace();
           }
               pessoa.setCaminhoImagem(cursor.getString(4));

        }
        return pessoa;
    }

    public static void dateToString(String[] args){


    }
    public void cadastrarUsuario(Pessoa pessoa){
        db = helper.getWritableDatabase();

        dateFormat.applyPattern("MM-dd-yy");

        ContentValues values = new ContentValues();
        values.put(Helper.PESSOA_NOME, pessoa.getNome());
        values.put(Helper.PESSOA_CPF, pessoa.getCpf());
        values.put(Helper.PESSOA_DATA,dateFormat.format(pessoa.getDataDeNascimento()));
        values.put(Helper.PESSOA_IMAGEM, pessoa.getCaminhoImagem());
        long fk_id_pessoa = db.insert(Helper.TABELA_PESSOA, null, values);

        values = new ContentValues();

        values.put(Helper.USUARIO_LOGIN, pessoa.getUsuario().getLogin());
        values.put(Helper.USUARIO_SENHA, pessoa.getUsuario().getSenha());
        values.put(Helper.USUARIO_PESSOA_ID, fk_id_pessoa);
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



    public void addAlergia(int id_fk_remedio){
        db = helper.getWritableDatabase();
        Log.i("USUARIO------->", String.valueOf(sessao.getUsuarioLogado().getId()));
        ContentValues values = new ContentValues();
        values.put(Helper.ALERGIA_PESSOA_FK_ID, sessao.getUsuarioLogado().getId());
        values.put(Helper.ALERGIA_REMEDIO_FK_ID, id_fk_remedio);
        db.insert(Helper.TABELA_ALERGIA, null, values);
        db.close();
    }
    public void removerAlergia(int id_fk_remedio){
        db = helper.getReadableDatabase();
        db.delete(Helper.TABELA_ALERGIA, Helper.ALERGIA_REMEDIO_FK_ID + " =?", new String[]{String.valueOf(id_fk_remedio)});

    }

    public RemedioDTO buscarRemedioLD(int id_remedio) {

        RemedioDTO remedioDTO = null;
        db = helper.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT " + Helper.TABELA_REMEDIO + "." +
                Helper.REMEDIO_ID + " FROM " + Helper.TABELA_ALERGIA +
                " INNER JOIN " + Helper.TABELA_REMEDIO + " ON (" + Helper.TABELA_ALERGIA + "." + Helper.ALERGIA_REMEDIO_FK_ID +
                " = " + Helper.TABELA_REMEDIO + "." + Helper.REMEDIO_ID + ") WHERE " + Helper.TABELA_ALERGIA + "." + Helper.ALERGIA_PESSOA_FK_ID +
                " =? AND " + Helper.TABELA_REMEDIO + "." + Helper.REMEDIO_ID +
                " =?;", new String[]{String.valueOf(sessao.getUsuarioLogado().getId()),String.valueOf(id_remedio)});
        if (cursor.moveToFirst()) {
            remedioDTO = new RemedioDTO();
            remedioDTO.setId(cursor.getInt(0));


        }

        return remedioDTO;

    }



}
