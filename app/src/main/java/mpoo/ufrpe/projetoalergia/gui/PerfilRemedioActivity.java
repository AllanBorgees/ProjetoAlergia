package mpoo.ufrpe.projetoalergia.gui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Collections;

import mpoo.ufrpe.projetoalergia.R;
import mpoo.ufrpe.projetoalergia.dao.UsuarioDAO;
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
    private Button btnAddListaNegra;
    private Remedio remedio;
    private UsuarioDAO dao = UsuarioDAO.getInstancia();

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_remedio);

        txtTextRemedio = (TextView)findViewById(R.id.txtNome);
        txtTextFabricante = (TextView)findViewById(R.id.txtCpf);
        lstComponente = (ListView)findViewById(R.id.lstComponente);
        txtComponente = (TextView)findViewById(R.id.txtComponente);
        txtPeso = (TextView)findViewById(R.id.txtPeso);
        btnAddListaNegra = (Button)findViewById(R.id.btnAddListaNegra);
        remedioNegocio= RemedioNegocio.getInstancia();
        contexto = this;


        Intent intent = getIntent();
        int id = intent.getExtras().getInt("REMEDIO");
        remedio = remedioNegocio.retornarRemedioId(id);
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


                Collections.sort(remedio.getComponentes(), new ComparatorComponentePeso());

                lstComponente.setAdapter(adapterListView);
            }
            });
        btnAddListaNegra.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (dao.buscarRemedioLD(remedio.getId()) == null) {
                    dao.addAlergia(remedio.getId());
                }else{
                    dao.removerAlergia(remedio.getId());

                GuiUtil.showMessage(PerfilRemedioActivity.this,"O remedio removido");

            }

        } } );
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_pesquisa, menu);

        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {



        switch (item.getItemId()){

            case R.id.action_perfil:
                Intent intentGoMain = new Intent(PerfilRemedioActivity.this, PerfilUsuarioActivity.class);
                startActivity(intentGoMain);


                break;
            case R.id.action_sair:

                finish();

                break;
        }
        return super.onOptionsItemSelected(item);


    }


    public static Context getContexto() {
        return contexto;
    }

    }







