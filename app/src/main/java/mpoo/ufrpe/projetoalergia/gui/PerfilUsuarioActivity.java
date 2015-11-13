package mpoo.ufrpe.projetoalergia.gui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import mpoo.ufrpe.projetoalergia.R;
import mpoo.ufrpe.projetoalergia.dao.RemedioDAO;
import mpoo.ufrpe.projetoalergia.dao.UsuarioDAO;
import mpoo.ufrpe.projetoalergia.dominio.dominioPessoa.Pessoa;
import mpoo.ufrpe.projetoalergia.dominio.dominoRemedio.RemedioDTO;
import mpoo.ufrpe.projetoalergia.negocio.RemedioNegocio;
import mpoo.ufrpe.projetoalergia.negocio.SessaoUsuario;

/**
 * Created by Airton on 11/11/2015.
 */
public class PerfilUsuarioActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private static Context contexto;
    private ArrayAdapter<String> adpRemedio;
    private RemedioNegocio remedioNegocio;
    private ListView lstRemedio;
    private TextView txtNome;
    private TextView txtCpf;
    private TextView txtDataNascimento;
    private AdapterListRemedio adapterListView;
    private RemedioDAO dao = RemedioDAO.getInstancia();
    private UsuarioDAO daoUsuario = UsuarioDAO.getInstancia();
    private SessaoUsuario sessao = SessaoUsuario.getInstancia();
    private ImageView iv;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);
        contexto = this;
        lstRemedio = (ListView)findViewById(R.id.lstRemedios);
        txtNome = (TextView)findViewById(R.id.txtNome);
        txtCpf = (TextView)findViewById(R.id.txtCpf);
        txtDataNascimento = (TextView)findViewById(R.id.txtDataNascimento);
        Log.i("ID------->", String.valueOf(sessao.getUsuarioLogado().getId()));
        Pessoa pessoa = daoUsuario.buscarPessoaId(sessao.getUsuarioLogado().getId());

        txtNome.setText(pessoa.getNome());
        txtCpf.setText(pessoa.getCpf());

        Bitmap bitmap = BitmapFactory.decodeFile(pessoa.getCaminhoImagem());
        Log.i("caminho","---------"+ pessoa.getCaminhoImagem());
        iv = (ImageView) findViewById(R.id.imageView2);
        iv.setImageBitmap(bitmap);
//        SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
//        String data = formataData.format(dataHoje);
//        pessoa.getDataDeNascimento()

        SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yy");
        Date dataHoje = new Date();
        String dt = formataData.format(pessoa.getDataDeNascimento());
        txtDataNascimento.setText(dt);

        adapterListView = new AdapterListRemedio(this,dao.buscarListaNegra(pessoa.getId()));


        
        lstRemedio.setAdapter(adapterListView);
        lstRemedio.setOnItemClickListener(this);


    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        RemedioDTO remedioDTO = adapterListView.getItem(position);

        Intent it = new Intent(this, PerfilRemedioActivity.class);

        it.putExtra("REMEDIO",remedioDTO.getId());
        setResult(Activity.RESULT_OK, it);

        startActivityForResult(it, 0);
    }

    public static Context getContexto() {
        return contexto;
    }

    @Override
    public void onClick(View v) {
        Intent it = new Intent(this, PerfilRemedioActivity.class);
        startActivityForResult(it, 0);
    }
}
