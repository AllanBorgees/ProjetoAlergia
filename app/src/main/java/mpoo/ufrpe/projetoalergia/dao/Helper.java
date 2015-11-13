package mpoo.ufrpe.projetoalergia.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import mpoo.ufrpe.projetoalergia.dao.script.ScriptPopularTabelaSQL;
import mpoo.ufrpe.projetoalergia.dao.script.ScriptTabelaSQL;

/**
 * Created by Allan on 16/10/2015.
 */
public class Helper extends SQLiteOpenHelper {
    private static final String NOME_DB = "banco.db";
    private static final int VERSAO_DB = 3;

    /*
        TABELA PESSOA
     */
    public static final String TABELA_PESSOA= "tabela_pessoa";
    public static final String PESSOA_ID = "_id_pessoa";
    public static final String PESSOA_NOME = "nome_pessoa";
    public static final String PESSOA_CPF = "cpf_pessoa";
    public static final String PESSOA_DATA = "data_nascimento_pessoa";
    public static final String PESSOA_IMAGEM = "caminho_imagem";

    /*
    TABELA USUARIO
     */
    public static final String TABELA_USUARIO = "tabela_usuario";
    public static final String USUARIO_ID = "_id_usuario";
    public static final String USUARIO_LOGIN = "login_usuario";
    public static final String USUARIO_SENHA = "senha_usuario";
    public static final String USUARIO_PESSOA_ID = "id_pessoa_usuario";


    /*
    TABELA REMEDIO
     */
    public static final String TABELA_REMEDIO = "tabela_remedio";
    public static final String REMEDIO_ID = "_id_remedio";
    public static final String REMEDIO_NOME = "nome_remedio";
    public static final String REMEDIO_FABRICANTE = "fabricante_remedio";
    public static final String REMEDIO_ID_ICONE = "id_icone_remedio";

    /*
    TABELA COMPONENTE
     */
    public static final String TABELA_COMPONENTE = "tabela_componente";
    public static final String COMPONENTE_ID = "_id_componente";
    public static final String COMPONENTE_NOME = "nome_componente";

    /*
    TABELA REMEDIO_COMPONENTE
     */

    public static final String TABELA_REMEDIO_COMPONENTE = "tabela_remedio_componente";
    public static final String REMEDIO_COMPONENTE_ID = "_id_remedio_componente";
    public static final String COMPONETE_FK_ID = "id_fk_componente";
    public static final String REMEDIO_FK_ID = "id_fk_remedio";
    public static final String REMEDIO_COMPONENTE_PESO = "peso_remedio_componente";

    /*
    TABELA ALERGIA
     */
    public static final String TABELA_ALERGIA = "tabela_alergia";
    public static final String ALERGIA_ID = "_id_alergia";
    public static final String ALERGIA_REMEDIO_FK_ID = "id_fk_remedio";
    public static final String ALERGIA_PESSOA_FK_ID = "id_fk_pessoa";


    public Helper(Context context) {
        super(context, NOME_DB, null, VERSAO_DB);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(ScriptTabelaSQL.getTabelaPessoa());

        db.execSQL(ScriptTabelaSQL.getTabelaUsuario());

        db.execSQL(ScriptTabelaSQL.getTabelaRemedio());

        db.execSQL(ScriptTabelaSQL.getTabelaComponente());

        db.execSQL(ScriptTabelaSQL.getTabelaRemedioComponente());

        db.execSQL(ScriptTabelaSQL.getTabelaAlergia());

        ScriptPopularTabelaSQL.insertRemedioDB(db);

        ScriptPopularTabelaSQL.inserirComponenteDB(db);

        ScriptPopularTabelaSQL.inserirRemedioComponenteDB(db);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+ TABELA_USUARIO);
        db.execSQL("drop table if exists "+ TABELA_PESSOA);
        db.execSQL("drop table if exists "+ TABELA_COMPONENTE);
        db.execSQL("drop table if exists "+ TABELA_REMEDIO);
        db.execSQL("drop table if exists "+ TABELA_REMEDIO_COMPONENTE);

        onCreate(db);
    }

}
