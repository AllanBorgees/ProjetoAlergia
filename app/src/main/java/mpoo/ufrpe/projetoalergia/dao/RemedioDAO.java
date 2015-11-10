package mpoo.ufrpe.projetoalergia.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import mpoo.ufrpe.projetoalergia.dominio.dominoRemedio.Componente;
import mpoo.ufrpe.projetoalergia.dominio.dominoRemedio.Remedio;
import mpoo.ufrpe.projetoalergia.dominio.dominoRemedio.RemedioDTO;
import mpoo.ufrpe.projetoalergia.gui.PesquisaActivity;


/**
 * Created by Allan on 17/10/2015.
 */
public class RemedioDAO {

    private Helper helper = new Helper(PesquisaActivity.getContexto());
    private SQLiteDatabase db;

    private static RemedioDAO instancia = new RemedioDAO();
    private RemedioDAO(){}
    public static RemedioDAO getInstancia(){
        return instancia;
    }

    public List<RemedioDTO> buscarRemedios(String nome) {

        db = helper.getWritableDatabase();


        List<RemedioDTO> listRemedio = new ArrayList<RemedioDTO>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + Helper.TABELA_REMEDIO + " WHERE "
                +helper.REMEDIO_NOME+" LIKE '%"+nome+"%'",null);

        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                RemedioDTO remedioDTO = new RemedioDTO();
                remedioDTO.setId(cursor.getInt(0));
                remedioDTO.setNome(cursor.getString(1));
                remedioDTO.setIdIcone(cursor.getInt(3));
                listRemedio.add(remedioDTO);
            }
            }
        return listRemedio;
    }

    public Remedio pesquisarUmRemedioId(int id){

        db = helper.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT "+Helper.TABELA_REMEDIO+"."+
                Helper.REMEDIO_ID+", "+Helper.TABELA_REMEDIO+"."+
                Helper.REMEDIO_NOME+", "+Helper.TABELA_REMEDIO+"."+Helper.REMEDIO_FABRICANTE+", "+Helper.TABELA_COMPONENTE+"."+
                Helper.COMPONENTE_ID+", "+Helper.TABELA_COMPONENTE+"."+
                Helper.COMPONENTE_NOME+", "+Helper.TABELA_REMEDIO_COMPONENTE+
                "."+Helper.REMEDIO_COMPONENTE_PESO+" FROM " + Helper.TABELA_REMEDIO_COMPONENTE + " INNER JOIN " + Helper.TABELA_COMPONENTE + " ON (" +
                Helper.TABELA_REMEDIO_COMPONENTE + "." + Helper.COMPONENTE_ID + " = " + Helper.TABELA_COMPONENTE + "." + Helper.COMPONENTE_ID + ") INNER JOIN " +
                Helper.TABELA_REMEDIO + " ON (" + Helper.TABELA_REMEDIO_COMPONENTE + "." + Helper.REMEDIO_ID+ " = " +
                Helper.TABELA_REMEDIO + "." + Helper.REMEDIO_ID + ") WHERE "+Helper.TABELA_REMEDIO+"."+ Helper.REMEDIO_ID+" =?;", new String[]{String.valueOf(id)});


        return criarUmRemedio(cursor);

    }

    public Remedio pesquisarUmRemedioNome(String nome){
        Remedio remedio = null;
        db = helper.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT "+Helper.TABELA_REMEDIO+"."+
                Helper.REMEDIO_ID+", "+Helper.TABELA_REMEDIO+"."+
                Helper.REMEDIO_NOME+", "+Helper.TABELA_REMEDIO+"."+Helper.REMEDIO_FABRICANTE+", "+Helper.TABELA_COMPONENTE+"."+
                Helper.COMPONENTE_ID+", "+Helper.TABELA_COMPONENTE+"."+
                Helper.COMPONENTE_NOME+", "+Helper.TABELA_REMEDIO_COMPONENTE+
                "."+Helper.REMEDIO_COMPONENTE_PESO+" FROM " + Helper.TABELA_REMEDIO_COMPONENTE + " INNER JOIN " + Helper.TABELA_COMPONENTE + " ON (" +
                Helper.TABELA_REMEDIO_COMPONENTE + "." + Helper.COMPONENTE_ID + " = " + Helper.TABELA_COMPONENTE + "." + Helper.COMPONENTE_ID + ") INNER JOIN " +
                Helper.TABELA_REMEDIO + " ON (" + Helper.TABELA_REMEDIO_COMPONENTE + "." + Helper.REMEDIO_ID+ " = " +
                Helper.TABELA_REMEDIO + "." + Helper.REMEDIO_ID + ") WHERE "+Helper.TABELA_REMEDIO+"."+ Helper.REMEDIO_NOME+" =?;", new String[]{nome});


        return criarUmRemedio(cursor);

    }

    public Remedio criarUmRemedio(Cursor cursor){
        Remedio remedio = null;

        if(cursor.getCount()>0) {
            remedio = new Remedio();

            List<Componente> componentes = new ArrayList<Componente>();
            while (cursor.moveToNext()){
                    remedio.setId(cursor.getInt(0));
                    remedio.setNome(cursor.getString(1));
                    remedio.setFabricante(cursor.getString(2));
                    Componente componente = new Componente();
                    componente.setId(cursor.getInt(3));
                    componente.setNome(cursor.getString(4));
                    componente.setPeso(Float.parseFloat(cursor.getString(5)));
                    componentes.add(componente);
            }
            remedio.setComponentes(componentes);

        }
        return remedio;
    }

}
