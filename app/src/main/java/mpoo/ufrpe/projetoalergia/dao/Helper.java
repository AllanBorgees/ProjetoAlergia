package mpoo.ufrpe.projetoalergia.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Allan on 16/10/2015.
 */
public class Helper extends SQLiteOpenHelper {
    private static final String NOME_DB = "banco";
    private static final int VERSAO_DB = 1;

    /*
        TABELA PESSOA
     */
    public static final String TABELA_PESSOA= "tabela_pessoa";
    public static final String PESSOA_ID = "_id_pessoa";
    public static final String PESSOA_NOME = "nome_pessoa";
    public static final String PESSOA_CPF = "cpf_pessoa";
    public static final String PESSOA_DATA = "data_nascimento_pessoa";


    /*
    TABELA USUARIO
     */
    public static final String TABELA_USUARIO = "tabela_usuario";
    public static final String USUARIO_ID = "_id_usuario";
    public static final String USUARIO_LOGIN = "login_usuario";
    public static final String USUARIO_SENHA = "senha_usuario";
    public static final String USUARIO_PESSOA_ID = "id_pessoa_usuario";


    public Helper(Context context) {
        super(context, NOME_DB, null, VERSAO_DB);
    }



//    CREATE TABLE Pessoa (
//            id_pessoa integer PRIMARY KEY auto_increment,
//            dataNascimento date not null,
//            nome text not null,
//            cpf text not null unique
//    );
//    CREATE TABLE Usuario (
//            id_usuario integer PRIMARY KEY auto_increment,
//            senha text not null,
//            login text unique not null,
//            id_pessoa integer,
//            FOREIGN KEY(id_pessoa) REFERENCES Pessoa (id_pessoa)
//            );


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TABELA_PESSOA + "(" +
                PESSOA_ID + " integer primary key autoincrement, " +
                PESSOA_NOME+ " text not null, "+
                PESSOA_CPF + " text not null );");
                //PESSOA_DATA + " date not null); ");

        db.execSQL("CREATE TABLE "+ TABELA_USUARIO + "(" +
                USUARIO_ID + " integer primary key autoincrement, " +
                USUARIO_LOGIN + " text not null, "+
                USUARIO_SENHA + " text not null, " +
                USUARIO_PESSOA_ID + " integer, "
                +"foreign key (" +USUARIO_PESSOA_ID + ") references "+ TABELA_PESSOA+" ("+PESSOA_ID+"));");

//        db.execSQL("INSERT INTO " + TABELA_USUARIO + "("+USUARIO_LOGIN+","+USUARIO_SENHA +") VALUES ('allan', '123') ");
//        db.execSQL("INSERT INTO " + TABELA_USUARIO + "("+USUARIO_LOGIN+","+USUARIO_SENHA +") VALUES ('joao', '123') ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+ TABELA_USUARIO);
        onCreate(db);
    }

}
