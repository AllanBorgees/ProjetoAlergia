package mpoo.ufrpe.projetoalergia.dao.script;

import android.database.sqlite.SQLiteDatabase;

import mpoo.ufrpe.projetoalergia.dao.Helper;

/**
 * Created by Airton on 12/11/2015.
 */
public class ScriptPopularTabelaSQL {
    public static void insertRemedioDB(SQLiteDatabase db){

        db.execSQL("INSERT INTO " + Helper.TABELA_REMEDIO + "(" + Helper.REMEDIO_NOME + "," + Helper.REMEDIO_FABRICANTE +","+Helper.REMEDIO_ID_ICONE+ ") VALUES ('ASS 100mg','Sanofi-Aventis Farmacêutica Ltda','2130837566')");
        db.execSQL("INSERT INTO " + Helper.TABELA_REMEDIO + "(" + Helper.REMEDIO_NOME + "," + Helper.REMEDIO_FABRICANTE +","+Helper.REMEDIO_ID_ICONE+ ") VALUES ('ADVI 200mg','WYETH INDÚSTRIA FARMACÊUTICA LTDA','2130837566')");
        db.execSQL("INSERT INTO " + Helper.TABELA_REMEDIO + "(" + Helper.REMEDIO_NOME + "," + Helper.REMEDIO_FABRICANTE +","+Helper.REMEDIO_ID_ICONE+ ") VALUES ('ANADOR 500mg','Boehringer Ingelheim do Brasil Química e Farmacêutica LTDA','2130837566')");
        db.execSQL("INSERT INTO " + Helper.TABELA_REMEDIO + "(" + Helper.REMEDIO_NOME + "," + Helper.REMEDIO_FABRICANTE +","+Helper.REMEDIO_ID_ICONE+ ") VALUES ('ATROVERAN COMPOSTO','Cosmed Indústria de Cosméticos e Medicamentos S.A.','2130837566')");
        db.execSQL("INSERT INTO " + Helper.TABELA_REMEDIO + "(" + Helper.REMEDIO_NOME + "," + Helper.REMEDIO_FABRICANTE +","+Helper.REMEDIO_ID_ICONE+ ") VALUES ('BUSCOPAN COMPOSTO','Boehringer Ingelheim do Brasil Química e Farmacêutica Ltda.','2130837566')");
        db.execSQL("INSERT INTO " + Helper.TABELA_REMEDIO + "(" + Helper.REMEDIO_NOME + "," + Helper.REMEDIO_FABRICANTE +","+Helper.REMEDIO_ID_ICONE+ ") VALUES ('Cataflam D','Novartis Biociências SA','2130837566')");
        db.execSQL("INSERT INTO " + Helper.TABELA_REMEDIO + "(" + Helper.REMEDIO_NOME + "," + Helper.REMEDIO_FABRICANTE +","+Helper.REMEDIO_ID_ICONE+ ") VALUES ('CORISTINA® D','Cosmed Indústria de Cosméticos e Medicamentos S.A.','2130837566')");
        db.execSQL("INSERT INTO " + Helper.TABELA_REMEDIO + "(" + Helper.REMEDIO_NOME + "," + Helper.REMEDIO_FABRICANTE +","+Helper.REMEDIO_ID_ICONE+ ") VALUES ('diclofenaco resinato','LABORATÓRIO TEUTO BRASILEIRO S/A.','2130837566')");
        db.execSQL("INSERT INTO " + Helper.TABELA_REMEDIO + "(" + Helper.REMEDIO_NOME + "," + Helper.REMEDIO_FABRICANTE +","+Helper.REMEDIO_ID_ICONE+ ") VALUES ('IBUPROFENO 50mg/mL','Brainfarma Indústria Química e Farmacêutica S.A.','2130837566')");
        db.execSQL("INSERT INTO " + Helper.TABELA_REMEDIO + "(" + Helper.REMEDIO_NOME + "," + Helper.REMEDIO_FABRICANTE +","+Helper.REMEDIO_ID_ICONE+ ") VALUES ('DIPIRONA SÓDICA 500mg/mL','Geolab Indústria Farmacêutica S/A','2130837566')");
        db.execSQL("INSERT INTO " + Helper.TABELA_REMEDIO + "(" + Helper.REMEDIO_NOME + "," + Helper.REMEDIO_FABRICANTE +","+Helper.REMEDIO_ID_ICONE+ ") VALUES ('DORFLEX','Sanofi-Aventis Farmacêutica Ltda.','2130837566')");
        db.execSQL("INSERT INTO " + Helper.TABELA_REMEDIO + "(" + Helper.REMEDIO_NOME + "," + Helper.REMEDIO_FABRICANTE +","+Helper.REMEDIO_ID_ICONE+ ") VALUES ('EXCEDRIN','Novartis Biociências S.A.','2130837566')");
        db.execSQL("INSERT INTO " + Helper.TABELA_REMEDIO + "(" + Helper.REMEDIO_NOME + "," + Helper.REMEDIO_FABRICANTE +","+Helper.REMEDIO_ID_ICONE+ ") VALUES ('TYLENOL 500mg','Janssen-Cilag Farmacêutica Ltda.','2130837566')");
        db.execSQL("INSERT INTO " + Helper.TABELA_REMEDIO + "(" + Helper.REMEDIO_NOME + "," + Helper.REMEDIO_FABRICANTE +","+Helper.REMEDIO_ID_ICONE+ ") VALUES ('TYLENOL 750mg','Janssen-Cilag Farmacêutica Ltda.','2130837566')");
        db.execSQL("INSERT INTO " + Helper.TABELA_REMEDIO + "(" + Helper.REMEDIO_NOME + "," + Helper.REMEDIO_FABRICANTE +","+Helper.REMEDIO_ID_ICONE+ ") VALUES ('NEOSALDINA','Takeda Pharma Ltda.','2130837566')");
        db.execSQL("INSERT INTO " + Helper.TABELA_REMEDIO + "(" + Helper.REMEDIO_NOME + "," + Helper.REMEDIO_FABRICANTE +","+Helper.REMEDIO_ID_ICONE+ ") VALUES ('PARACETAMOL','Medley Indústria Farmacêutica Ltda.','2130837566')");
        db.execSQL("INSERT INTO " + Helper.TABELA_REMEDIO + "(" + Helper.REMEDIO_NOME + "," + Helper.REMEDIO_FABRICANTE +","+Helper.REMEDIO_ID_ICONE+ ") VALUES ('Sonrisal','GlaxoSmithKline','2130837566')");
        db.execSQL("INSERT INTO " + Helper.TABELA_REMEDIO + "(" + Helper.REMEDIO_NOME + "," + Helper.REMEDIO_FABRICANTE +","+Helper.REMEDIO_ID_ICONE+ ") VALUES ('Sonrisal® Limão','GlaxoSmithKline','2130837566')");
        db.execSQL("INSERT INTO " + Helper.TABELA_REMEDIO + "(" + Helper.REMEDIO_NOME + "," + Helper.REMEDIO_FABRICANTE +","+Helper.REMEDIO_ID_ICONE+ ") VALUES ('TORSILAX®','Brainfarma Indústria Química e Farmacêutica S.A.','2130837566')");


    }
    public static void inserirComponenteDB(SQLiteDatabase db){

        db.execSQL("INSERT INTO "+ Helper.TABELA_COMPONENTE +"("+ Helper.COMPONENTE_NOME+") VALUES ('ácido acetilsalicílico')");
        db.execSQL("INSERT INTO "+ Helper.TABELA_COMPONENTE +"("+ Helper.COMPONENTE_NOME+") VALUES ('bicarbonato de sódio')");
        db.execSQL("INSERT INTO "+ Helper.TABELA_COMPONENTE +"("+ Helper.COMPONENTE_NOME+") VALUES ('carbonato de sódio')");
        db.execSQL("INSERT INTO "+ Helper.TABELA_COMPONENTE +"("+ Helper.COMPONENTE_NOME+") VALUES ('ácido acetilsalicílico')");
        db.execSQL("INSERT INTO "+ Helper.TABELA_COMPONENTE +"("+ Helper.COMPONENTE_NOME+") VALUES ('ácido cítrico')");
        db.execSQL("INSERT INTO "+ Helper.TABELA_COMPONENTE +"("+ Helper.COMPONENTE_NOME+") VALUES ('butilbrometo de escopolamina')");
        db.execSQL("INSERT INTO "+ Helper.TABELA_COMPONENTE +"("+ Helper.COMPONENTE_NOME+") VALUES ('cafeína')");
        db.execSQL("INSERT INTO "+ Helper.TABELA_COMPONENTE +"("+ Helper.COMPONENTE_NOME+") VALUES ('carisoprodol')");
        db.execSQL("INSERT INTO "+ Helper.TABELA_COMPONENTE +"("+ Helper.COMPONENTE_NOME+") VALUES ('citrato de orfenadrina')");
        db.execSQL("INSERT INTO "+ Helper.TABELA_COMPONENTE +"("+ Helper.COMPONENTE_NOME+") VALUES ('cloridrato de fenilefrina')");
        db.execSQL("INSERT INTO "+ Helper.TABELA_COMPONENTE +"("+ Helper.COMPONENTE_NOME+") VALUES ('diclofenaco ')");
        db.execSQL("INSERT INTO "+ Helper.TABELA_COMPONENTE +"("+ Helper.COMPONENTE_NOME+") VALUES ('dipirona')");
        db.execSQL("INSERT INTO "+ Helper.TABELA_COMPONENTE +"("+ Helper.COMPONENTE_NOME+") VALUES ('ibuprofeno')");
        db.execSQL("INSERT INTO "+ Helper.TABELA_COMPONENTE +"("+ Helper.COMPONENTE_NOME+") VALUES ('maleato de dexclorfeniramina')");
        db.execSQL("INSERT INTO "+ Helper.TABELA_COMPONENTE +"("+ Helper.COMPONENTE_NOME+") VALUES ('mucato de isometepteno')");
        db.execSQL("INSERT INTO "+ Helper.TABELA_COMPONENTE +"("+ Helper.COMPONENTE_NOME+") VALUES ('paracetamol')");
        db.execSQL("INSERT INTO "+ Helper.TABELA_COMPONENTE +"("+ Helper.COMPONENTE_NOME+") VALUES ('sulfato de hiosciamina')");
        db.execSQL("INSERT INTO "+ Helper.TABELA_COMPONENTE +"("+ Helper.COMPONENTE_NOME+") VALUES ('cloridrato de papaverina')");
    }
    public static void inserirRemedioComponenteDB(SQLiteDatabase db){

        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (1,1,100)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (13,2,200)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (12,3,433.03)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (18,4,30)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (12,4,250)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (17,4,0.9)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (6,5,10)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (12,5,250)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (11,6,44.3)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (1,7,400)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (14,7,1)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (10,7,10)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (7,7,30)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (11,8,44.3)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (13,9,50)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (12,10,500)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (12,11,300)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (9,11,35)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (7,11,50)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (16,12,500)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (7,12,65)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (16,13,500)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (16,14,700)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (12,15,300)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (15,15,30)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (7,15,30)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (16,16,750)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (2,17,1854)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (3,17,400)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (1,17,25)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (5,17,1413)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (2,18,1644)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (3,18,400)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (1,18,325)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (5,18,1507.8)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (8,19,125)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (11,19,50)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (16,19,300)");
        db.execSQL("INSERT INTO "+Helper.TABELA_REMEDIO_COMPONENTE+ "("+Helper.COMPONENTE_ID+","+Helper.REMEDIO_ID+","+Helper.REMEDIO_COMPONENTE_PESO+") VALUES (7,19,30)");
    }





}
