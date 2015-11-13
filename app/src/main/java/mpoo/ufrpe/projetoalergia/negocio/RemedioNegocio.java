package mpoo.ufrpe.projetoalergia.negocio;

import java.util.List;

import mpoo.ufrpe.projetoalergia.dao.RemedioDAO;
import mpoo.ufrpe.projetoalergia.dominio.dominoRemedio.Remedio;
import mpoo.ufrpe.projetoalergia.dominio.dominoRemedio.RemedioDTO;
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

    public List<RemedioDTO> consultarRemedio(String nome){

       return dao.buscarRemedios(nome);

    }
    public Remedio retornarRemedioId(int id){
        Remedio remedio = dao.pesquisarUmRemedioId(id);
        return remedio;
    }


    public Remedio retornarRemedioNome(String nome)throws ProjetoAlergiaException {
        Remedio remedio = dao.pesquisarUmRemedioNome(nome);
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
