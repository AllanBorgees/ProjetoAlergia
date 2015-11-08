package mpoo.ufrpe.projetoalergia.negocio;

import android.widget.ArrayAdapter;

import java.util.List;

import mpoo.ufrpe.projetoalergia.dao.RemedioDAO;
import mpoo.ufrpe.projetoalergia.dominio.dominoRemedio.Remedio;
import mpoo.ufrpe.projetoalergia.negocio.infra.ProjetoAlergiaException;

/**
 * Created by Allan on 17/10/2015.
 */
public class RemedioNegocio {

    private static RemedioNegocio instancia = new RemedioNegocio();
    private RemedioNegocio(){}
    public static RemedioNegocio getInstancia(){
        return instancia;
    }

    private RemedioDAO dao = RemedioDAO.getInstancia();

    public List<String> consultarRemedio(String nome){

       return dao.buscarRemedios(nome);

    }

    public Remedio retornarRemedio(String nome)throws ProjetoAlergiaException {
        Remedio remedio = dao.pesquisarUmRemedio(nome);
        StringBuilder builder = new StringBuilder();

        if (remedio == null) {
            builder.append("Não existe remedios no banco");
        }

        if (builder.length() > 0) {
            throw new ProjetoAlergiaException(builder.toString());
        }
        return remedio;
    }

}
