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

    public static final String TABELA_USUARIO = "tabela_usuario";
    public static final String USUARIO_ID = "_usuario_id";
    public static final String USUARIO_LOGIN = "usuario_login";
    public static final String USUARIO_SENHA = "usuario_senha";

    public Helper(Context context) {
        super(context, NOME_DB, null, VERSAO_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TABELA_USUARIO + "(" +
                USUARIO_ID + " integer primary key autoincrement, " +
                USUARIO_LOGIN + " text not null, "+
                USUARIO_SENHA + " text not null);");

        db.execSQL("INSERT INTO " + TABELA_USUARIO + "("+USUARIO_LOGIN+","+USUARIO_SENHA +") VALUES ('allan', '123') ");
        db.execSQL("INSERT INTO " + TABELA_USUARIO + "("+USUARIO_LOGIN+","+USUARIO_SENHA +") VALUES ('joao', '123') ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+ TABELA_USUARIO);
        onCreate(db);
    }

}
