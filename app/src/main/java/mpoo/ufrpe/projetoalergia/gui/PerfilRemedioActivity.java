package mpoo.ufrpe.projetoalergia.gui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Collections;

import mpoo.ufrpe.projetoalergia.R;
import mpoo.ufrpe.projetoalergia.dominio.dominoRemedio.Remedio;
import mpoo.ufrpe.projetoalergia.negocio.RemedioNegocio;
import mpoo.ufrpe.projetoalergia.negocio.infra.ComparatorComponentePeso;

/**
 * Created by Airton on 01/11/2015.
 */
public class PerfilRemedioActivity extends AppCompatActivity {



    private static Context contexto;
    private RemedioNegocio remedioNegocio;

    private TextView txtTextRemedio;
    private TextView txtTextFabricante;
    private ListView lstComponente;
    private AdapterListComponente adapterListView;
    private TextView txtComponente;
    private TextView txtPeso;
    private Remedio remedio;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_remedio);

        txtTextRemedio = (TextView)findViewById(R.id.txtRemedio);
        txtTextFabricante = (TextView)findViewById(R.id.txtFabricante);
        lstComponente = (ListView)findViewById(R.id.lstComponente);
        txtComponente = (TextView)findViewById(R.id.txtComponente);
        txtPeso = (TextView)findViewById(R.id.txtPeso);
        remedioNegocio= RemedioNegocio.getInstancia();
        contexto = this;


        Intent intent = getIntent();
        int id = intent.getExtras().getInt("REMEDIO");
        remedio = remedioNegocio.retornarRemedioId(id);
//                ArrayAdapter<Componente> componentes = new ArrayAdapter<Componente>(PerfilRemedioActivity.getContexto(), android.R.layout.simple_list_item_1,remedio.getComponentes());
        adapterListView = new AdapterListComponente(this,remedio.getComponentes());
        lstComponente.setAdapter(adapterListView);
        txtTextRemedio.setText(remedio.getNome());
        txtTextFabricante.setText(remedio.getFabricante());



        txtComponente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(remedio.getComponentes());
                lstComponente.setAdapter(adapterListView);
                }
        });

        txtPeso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Collections.sort(remedio.getComponentes());
                Collections.sort(remedio.getComponentes(), new ComparatorComponentePeso());

                lstComponente.setAdapter(adapterListView);


            }
            });


            }
    public static Context getContexto() {
        return contexto;
    }

    }







