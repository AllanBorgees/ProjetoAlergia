package mpoo.ufrpe.projetoalergia.gui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import mpoo.ufrpe.projetoalergia.R;
import mpoo.ufrpe.projetoalergia.dominio.dominoRemedio.Componente;
import mpoo.ufrpe.projetoalergia.dominio.dominoRemedio.Remedio;
import mpoo.ufrpe.projetoalergia.negocio.RemedioNegocio;
import mpoo.ufrpe.projetoalergia.negocio.infra.ProjetoAlergiaException;

/**
 * Created by Airton on 01/11/2015.
 */
public class PerfilRemedioActivity extends AppCompatActivity {



    private static Context contexto;
    private RemedioNegocio remedioNegocio;

    private TextView txtTextRemedio;
    private TextView txtTextFabricante;
    private ListView lstComponente;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_remedio);

        txtTextRemedio = (TextView)findViewById(R.id.txtRemedio);
        txtTextFabricante = (TextView)findViewById(R.id.txtFabricante);
        lstComponente = (ListView)findViewById(R.id.lstComponente);
        remedioNegocio= RemedioNegocio.getInstancia();
        contexto = this;

        Intent intent = getIntent();



            String nome = intent.getExtras().getString("REMEDIO");
            try {

                Remedio remedio = remedioNegocio.retornarRemedio(nome);
                ArrayAdapter<Componente> componentes = new ArrayAdapter<Componente>(PerfilRemedioActivity.getContexto(), android.R.layout.simple_list_item_1,remedio.getComponentes());
                txtTextRemedio.setText(remedio.getNome());
                txtTextFabricante.setText(remedio.getFabricante());
                lstComponente.setAdapter(componentes);



            }catch(ProjetoAlergiaException ex){
                AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                dlg.setMessage("Erro procurar remedio " + ex.getMessage());
                dlg.setNeutralButton("ok", null);
                dlg.show();

            }
            }
    public static Context getContexto() {
        return contexto;
    }

    }







