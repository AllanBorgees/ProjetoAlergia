package mpoo.ufrpe.projetoalergia.gui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import mpoo.ufrpe.projetoalergia.R;
import mpoo.ufrpe.projetoalergia.negocio.RemedioNegocio;

public class PesquisaActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private static Context contexto;
    private ArrayAdapter<String> adpRemedio;
    private RemedioNegocio remedioNegocio;
    private ListView lstRemedio;
    private EditText edtPesquisa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa);


        contexto = this;
        lstRemedio = (ListView)findViewById(R.id.lstRemedios);
        edtPesquisa = (EditText)findViewById(R.id.edtPesquisa);
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


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pesquisa, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static Context getContexto() {
        return contexto;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String remedio = adpRemedio.getItem(position);

        Intent it = new Intent(this, PerfilRemedioActivity.class);

        it.putExtra("REMEDIO", remedio);
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
        if (nome.length() == 0) {
            adpRemedio = null;
        } else {
            List<String> listaRemedio = remedioNegocio.consultarRemedio(nome);
            adpRemedio = new ArrayAdapter<String>(PesquisaActivity.getContexto(), android.R.layout.simple_list_item_1,listaRemedio);
        }
        lstRemedio.setAdapter(adpRemedio);

    }

}


