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




    public static final String TABELA_REMEDIO = "tabela_remedio";
    public static final String REMEDIO_ID = "_id_remedio";
    public static final String REMEDIO_NOME = "nome_remedio";
    public static final String REMEDIO_FABRICANTE = "fabricante_remedio";
    public static final String REMEDIO_ID_ICONE = "id_icone_remedio";

    public static final String TABELA_COMPONENTE = "tabela_componente";
    public static final String COMPONENTE_ID = "_id_componente";
    public static final String COMPONENTE_NOME = "nome_componente";

    public static final String TABELA_REMEDIO_COMPONENTE = "tabela_remedio_componente";
    public static final String REMEDIO_COMPONENTE_ID = "_id_remedio_componente";
    public static final String COMPONETE_FK_ID = "id_fk_componente";
    public static final String REMEDIO_FK_ID = "id_fk_remedio";
    public static final String REMEDIO_COMPONENTE_PESO = "peso_remedio_componente";




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
                PESSOA_CPF + " text not null unique,  "+
                PESSOA_DATA + " date );");

        db.execSQL("CREATE TABLE "+ TABELA_USUARIO + "(" +
                USUARIO_ID + " integer primary key autoincrement, " +
                USUARIO_LOGIN + " text not null unique, "+
                USUARIO_SENHA + " text not null, " +
                USUARIO_PESSOA_ID + " integer, "
                +"foreign key (" +USUARIO_PESSOA_ID + ") references "+ TABELA_PESSOA+" ("+PESSOA_ID+"));");


        db.execSQL("CREATE TABLE "+ TABELA_REMEDIO + "(" +
                REMEDIO_ID + " integer primary key autoincrement, " +
                REMEDIO_NOME+ " text not null, "+
                REMEDIO_FABRICANTE+ " text not null, "+
                REMEDIO_ID_ICONE+" int not null);");

        db.execSQL("CREATE TABLE "+ TABELA_COMPONENTE + "(" +
                COMPONENTE_ID + " integer primary key autoincrement, " +
                COMPONENTE_NOME+ " text not null);");

        db.execSQL("CREATE TABLE "+ TABELA_REMEDIO_COMPONENTE + "(" +
                REMEDIO_COMPONENTE_ID + " integer primary key autoincrement, " +
                COMPONENTE_ID + " integer, "+
                REMEDIO_ID + " integer, " +
                REMEDIO_COMPONENTE_PESO + " float not null, "
                +"foreign key (" +COMPONENTE_ID + ") references "+ TABELA_COMPONENTE+" ("+COMPONENTE_ID+"), "
                        +"foreign key (" +REMEDIO_ID+ ") references "+ TABELA_REMEDIO+" ("+REMEDIO_ID+"));");

        db.execSQL("INSERT INTO " + TABELA_USUARIO + "("+USUARIO_LOGIN+","+USUARIO_SENHA +") VALUES ('allan', 'allan') ");
        db.execSQL("INSERT INTO " + TABELA_USUARIO + "("+USUARIO_LOGIN+","+USUARIO_SENHA +") VALUES ('airton', 'airton') ");
        db.execSQL("INSERT INTO " + TABELA_USUARIO + "("+USUARIO_LOGIN+","+USUARIO_SENHA +") VALUES ('stefany', 'stefany') ");
        db.execSQL("INSERT INTO " + TABELA_USUARIO + "("+USUARIO_LOGIN+","+USUARIO_SENHA +") VALUES ('joao', 'joao') ");
        db.execSQL("INSERT INTO " + TABELA_USUARIO + "("+USUARIO_LOGIN+","+USUARIO_SENHA +") VALUES ('carlos', 'carlos') ");
        db.execSQL("INSERT INTO " + TABELA_USUARIO + "("+USUARIO_LOGIN+","+USUARIO_SENHA +") VALUES ('gabriel', 'gabriel') ");
//        db.execSQL("INSERT INTO " + TABELA_USUARIO + "("+USUARIO_LOGIN+","+USUARIO_SENHA +") VALUES ('allan', '123') ");
////        db.execSQL("INSERT INTO " + TABELA_USUARIO + "("+USUARIO_LOGIN+","+USUARIO_SENHA +") VALUES ('joao', '123') ");
//
//        db.execSQL("INSERT INTO "+ TABELA_COMPONENTE +"("+ COMPONENTE_NOME+") VALUES ('componenteA') ");
//        db.execSQL("INSERT INTO " + TABELA_COMPONENTE + "(" + COMPONENTE_NOME + ") VALUES ('componenteB') ");
//        db.execSQL("INSERT INTO " + TABELA_COMPONENTE + "(" + COMPONENTE_NOME + ") VALUES ('componenteC') ");
//
//        db.execSQL("INSERT INTO " + TABELA_REMEDIO + "(" + REMEDIO_NOME + "," + REMEDIO_FABRICANTE + ") VALUES ('RemedioX', 'Tabajara')");
//        db.execSQL("INSERT INTO " + TABELA_REMEDIO + "(" + REMEDIO_NOME + "," + REMEDIO_FABRICANTE + ") VALUES ('RemedioY', 'Tabajara')");
//        db.execSQL("INSERT INTO " + TABELA_REMEDIO + "(" + REMEDIO_NOME + "," + REMEDIO_FABRICANTE + ") VALUES ('RemedioZ', 'Tabajara')");
//
//        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (1, 1, 70.5)");
//        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (2, 1, 70.5)");
//        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (3, 1, 70.5)");

//        db.execSQL("SELECT * FROM "+TABELA_REMEDIO_COMPONENTE+" INNER JOIN "+TABELA_COMPONENTE+" ON ("+TABELA_REMEDIO_COMPONENTE+"."+COMPONETE_FK_ID+" = "+
//                TABELA_COMPONENTE+"."+COMPONENTE_ID+") INNER JOIN "+TABELA_REMEDIO+" ON ("+TABELA_REMEDIO_COMPONENTE+"."+REMEDIO_FK_ID+" = "+TABELA_REMEDIO+"."+REMEDIO_ID+")");

        //      2130837566

        db.execSQL("INSERT INTO " + TABELA_REMEDIO + "(" + REMEDIO_NOME + "," + REMEDIO_FABRICANTE +","+REMEDIO_ID_ICONE+ ") VALUES ('ASS 100mg','Sanofi-Aventis Farmacêutica Ltda','2130837567')");
        db.execSQL("INSERT INTO " + TABELA_REMEDIO + "(" + REMEDIO_NOME + "," + REMEDIO_FABRICANTE +","+REMEDIO_ID_ICONE+ ") VALUES ('ADVI 200mg','WYETH INDÚSTRIA FARMACÊUTICA LTDA','2130837567')");
        db.execSQL("INSERT INTO " + TABELA_REMEDIO + "(" + REMEDIO_NOME + "," + REMEDIO_FABRICANTE +","+REMEDIO_ID_ICONE+ ") VALUES ('ANADOR 500mg','Boehringer Ingelheim do Brasil Química e Farmacêutica LTDA','2130837567')");
        db.execSQL("INSERT INTO " + TABELA_REMEDIO + "(" + REMEDIO_NOME + "," + REMEDIO_FABRICANTE +","+REMEDIO_ID_ICONE+ ") VALUES ('ATROVERAN COMPOSTO','Cosmed Indústria de Cosméticos e Medicamentos S.A.','2130837567')");
        db.execSQL("INSERT INTO " + TABELA_REMEDIO + "(" + REMEDIO_NOME + "," + REMEDIO_FABRICANTE +","+REMEDIO_ID_ICONE+") VALUES ('BUSCOPAN COMPOSTO','Boehringer Ingelheim do Brasil Química e Farmacêutica Ltda.','2130837567')");
        db.execSQL("INSERT INTO " + TABELA_REMEDIO + "(" + REMEDIO_NOME + "," + REMEDIO_FABRICANTE +","+REMEDIO_ID_ICONE+ ") VALUES ('Cataflam D','Novartis Biociências SA','2130837567')");
        db.execSQL("INSERT INTO " + TABELA_REMEDIO + "(" + REMEDIO_NOME + "," + REMEDIO_FABRICANTE +","+REMEDIO_ID_ICONE+ ") VALUES ('CORISTINA® D','Cosmed Indústria de Cosméticos e Medicamentos S.A.','2130837567')");
        db.execSQL("INSERT INTO " + TABELA_REMEDIO + "(" + REMEDIO_NOME + "," + REMEDIO_FABRICANTE +","+REMEDIO_ID_ICONE+ ") VALUES ('diclofenaco resinato','LABORATÓRIO TEUTO BRASILEIRO S/A.','2130837567')");
        db.execSQL("INSERT INTO " + TABELA_REMEDIO + "(" + REMEDIO_NOME + "," + REMEDIO_FABRICANTE +","+REMEDIO_ID_ICONE+ ") VALUES ('IBUPROFENO 50mg/mL','Brainfarma Indústria Química e Farmacêutica S.A.','2130837567')");
        db.execSQL("INSERT INTO " + TABELA_REMEDIO + "(" + REMEDIO_NOME + "," + REMEDIO_FABRICANTE +","+REMEDIO_ID_ICONE+ ") VALUES ('DIPIRONA SÓDICA 500mg/mL','Geolab Indústria Farmacêutica S/A','2130837567')");
        db.execSQL("INSERT INTO " + TABELA_REMEDIO + "(" + REMEDIO_NOME + "," + REMEDIO_FABRICANTE +","+REMEDIO_ID_ICONE+ ") VALUES ('DORFLEX','Sanofi-Aventis Farmacêutica Ltda.','2130837567')");
        db.execSQL("INSERT INTO " + TABELA_REMEDIO + "(" + REMEDIO_NOME + "," + REMEDIO_FABRICANTE +","+REMEDIO_ID_ICONE+ ") VALUES ('EXCEDRIN','Novartis Biociências S.A.','2130837567')");
        db.execSQL("INSERT INTO " + TABELA_REMEDIO + "(" + REMEDIO_NOME + "," + REMEDIO_FABRICANTE +","+REMEDIO_ID_ICONE+ ") VALUES ('TYLENOL 500mg','Janssen-Cilag Farmacêutica Ltda.','2130837567')");
        db.execSQL("INSERT INTO " + TABELA_REMEDIO + "(" + REMEDIO_NOME + "," + REMEDIO_FABRICANTE +","+REMEDIO_ID_ICONE+ ") VALUES ('TYLENOL 750mg','Janssen-Cilag Farmacêutica Ltda.','2130837567')");
        db.execSQL("INSERT INTO " + TABELA_REMEDIO + "(" + REMEDIO_NOME + "," + REMEDIO_FABRICANTE +","+REMEDIO_ID_ICONE+ ") VALUES ('NEOSALDINA','Takeda Pharma Ltda.','2130837567')");
        db.execSQL("INSERT INTO " + TABELA_REMEDIO + "(" + REMEDIO_NOME + "," + REMEDIO_FABRICANTE +","+REMEDIO_ID_ICONE+ ") VALUES ('PARACETAMOL','Medley Indústria Farmacêutica Ltda.','2130837567')");
        db.execSQL("INSERT INTO " + TABELA_REMEDIO + "(" + REMEDIO_NOME + "," + REMEDIO_FABRICANTE +","+REMEDIO_ID_ICONE+ ") VALUES ('Sonrisal','GlaxoSmithKline','2130837567')");
        db.execSQL("INSERT INTO " + TABELA_REMEDIO + "(" + REMEDIO_NOME + "," + REMEDIO_FABRICANTE +","+REMEDIO_ID_ICONE+ ") VALUES ('Sonrisal® Limão','GlaxoSmithKline','2130837567')");
        db.execSQL("INSERT INTO " + TABELA_REMEDIO + "(" + REMEDIO_NOME + "," + REMEDIO_FABRICANTE +","+REMEDIO_ID_ICONE+ ") VALUES ('TORSILAX®','Brainfarma Indústria Química e Farmacêutica S.A.','2130837567')");

        db.execSQL("INSERT INTO "+ TABELA_COMPONENTE +"("+ COMPONENTE_NOME+") VALUES ('ácido acetilsalicílico')");
        db.execSQL("INSERT INTO "+ TABELA_COMPONENTE +"("+ COMPONENTE_NOME+") VALUES ('bicarbonato de sódio')");
        db.execSQL("INSERT INTO "+ TABELA_COMPONENTE +"("+ COMPONENTE_NOME+") VALUES ('carbonato de sódio')");
        db.execSQL("INSERT INTO "+ TABELA_COMPONENTE +"("+ COMPONENTE_NOME+") VALUES ('ácido acetilsalicílico')");
        db.execSQL("INSERT INTO "+ TABELA_COMPONENTE +"("+ COMPONENTE_NOME+") VALUES ('ácido cítrico')");
        db.execSQL("INSERT INTO "+ TABELA_COMPONENTE +"("+ COMPONENTE_NOME+") VALUES ('butilbrometo de escopolamina')");
        db.execSQL("INSERT INTO "+ TABELA_COMPONENTE +"("+ COMPONENTE_NOME+") VALUES ('cafeína')");
        db.execSQL("INSERT INTO "+ TABELA_COMPONENTE +"("+ COMPONENTE_NOME+") VALUES ('carisoprodol')");
        db.execSQL("INSERT INTO "+ TABELA_COMPONENTE +"("+ COMPONENTE_NOME+") VALUES ('citrato de orfenadrina')");
        db.execSQL("INSERT INTO "+ TABELA_COMPONENTE +"("+ COMPONENTE_NOME+") VALUES ('cloridrato de fenilefrina')");
        db.execSQL("INSERT INTO "+ TABELA_COMPONENTE +"("+ COMPONENTE_NOME+") VALUES ('diclofenaco ')");
        db.execSQL("INSERT INTO "+ TABELA_COMPONENTE +"("+ COMPONENTE_NOME+") VALUES ('dipirona')");
        db.execSQL("INSERT INTO "+ TABELA_COMPONENTE +"("+ COMPONENTE_NOME+") VALUES ('ibuprofeno')");
        db.execSQL("INSERT INTO "+ TABELA_COMPONENTE +"("+ COMPONENTE_NOME+") VALUES ('maleato de dexclorfeniramina')");
        db.execSQL("INSERT INTO "+ TABELA_COMPONENTE +"("+ COMPONENTE_NOME+") VALUES ('mucato de isometepteno')");
        db.execSQL("INSERT INTO "+ TABELA_COMPONENTE +"("+ COMPONENTE_NOME+") VALUES ('paracetamol')");
        db.execSQL("INSERT INTO "+ TABELA_COMPONENTE +"("+ COMPONENTE_NOME+") VALUES ('sulfato de hiosciamina')");
        db.execSQL("INSERT INTO "+ TABELA_COMPONENTE +"("+ COMPONENTE_NOME+") VALUES ('cloridrato de papaverina')");


        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (1,1,100)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (13,2,200)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (12,3,433.03)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (18,4,30)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (12,4,250)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (17,4,0.9)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (6,5,10)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (12,5,250)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (11,6,44.3)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (1,7,400)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (14,7,1)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (10,7,10)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (7,7,30)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (11,8,44.3)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (13,9,50)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (12,10,500)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (12,11,300)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (9,11,35)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (7,11,50)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (16,12,500)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (7,12,65)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (16,13,500)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (16,14,700)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (12,15,300)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (15,15,30)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (7,15,30)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (16,16,750)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (2,17,1854)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (3,17,400)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (1,17,25)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (5,17,1413)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (2,18,1644)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (3,18,400)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (1,18,325)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (5,18,1507.8)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (8,19,125)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (11,19,50)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (16,19,300)");
        db.execSQL("INSERT INTO "+TABELA_REMEDIO_COMPONENTE+ "("+COMPONENTE_ID+","+REMEDIO_ID+","+REMEDIO_COMPONENTE_PESO+") VALUES (7,19,30)");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+ TABELA_USUARIO);
        onCreate(db);
    }

}
