package mpoo.ufrpe.projetoalergia.gui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import mpoo.ufrpe.projetoalergia.R;
import mpoo.ufrpe.projetoalergia.dominio.dominoRemedio.RemedioDTO;
import mpoo.ufrpe.projetoalergia.negocio.RemedioNegocio;

public class PesquisaActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private static Context contexto;
    private ArrayAdapter<String> adpRemedio;
    private RemedioNegocio remedioNegocio;
    private ListView lstRemedio;
    private EditText edtPesquisa;
    private Button btnMenu;
    private AdapterListRemedio adapterListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa);


        contexto = this;
        lstRemedio = (ListView) findViewById(R.id.lstRemedios);
        edtPesquisa = (EditText) findViewById(R.id.edtPesquisa);
        btnMenu = (Button)findViewById(R.id.btnMenu);
        lstRemedio.setOnItemClickListener(this);
        remedioNegocio = RemedioNegocio.getInstancia();

        edtPesquisa.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                autoComplete();
            }
        });

        btnMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intentGoMain = new Intent(PesquisaActivity.this, PerfilUsuarioActivity.class);
                startActivity(intentGoMain);

            }
        });
    }

        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_pesquisa, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {



        switch (item.getItemId()){

            case R.id.action_perfil:
                Intent intentGoMain = new Intent(PesquisaActivity.this, PerfilUsuarioActivity.class);
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

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        RemedioDTO remedioDTO = adapterListView.getItem(position);

        Intent it = new Intent(this, PerfilRemedioActivity.class);
        it.putExtra("REMEDIO",remedioDTO.getId());
        setResult(Activity.RESULT_OK, it);

        startActivityForResult(it, 0);
    }

    @Override
    public void onClick(View v) {
        Intent it = new Intent(this, PerfilRemedioActivity.class);
        startActivityForResult(it, 0);

    }

    public void autoComplete(){
        String nome = edtPesquisa.getText().toString();
        adapterListView = null;
        if (nome.length() > 0) {
            List<RemedioDTO> listaRemedio = remedioNegocio.consultarRemedio(nome);
//            adpRemedio = new ArrayAdapter<String>(PesquisaActivity.getContexto(), android.R.layout.simple_list_item_1,listaRemedio);
            adapterListView = new AdapterListRemedio(this,listaRemedio);
        }
        lstRemedio.setAdapter(adapterListView);

    }

}


