package mpoo.ufrpe.projetoalergia.gui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import mpoo.ufrpe.projetoalergia.R;
import mpoo.ufrpe.projetoalergia.negocio.UsuarioNegocio;
import mpoo.ufrpe.projetoalergia.negocio.infra.ProjetoAlergiaException;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextLogin;
    private EditText editTextSenha;
    private Button btnLogar;
    private Button btnCadastrar;
    private ImageView img;
    private UsuarioNegocio usuarioNegocio;
    private static Context contexto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        contexto = this;
        usuarioNegocio = UsuarioNegocio.getInstancia();
        editTextLogin = (EditText) findViewById(R.id.edtLogin);
        editTextSenha = (EditText) findViewById(R.id.edtSenha);
        img = (ImageView) findViewById(R.id.img);
        btnLogar = (Button) findViewById(R.id.btnLogar);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        Log.i("ID da foto", String.valueOf(R.drawable.images));
        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = editTextLogin.getText().toString().trim();
                String senha = editTextSenha.getText().toString().trim();
                login(login, senha);
            }
        });

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGoMain = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(intentGoMain);
            }
        });

    }

    private void login(String login, String senha){

        if(!validarLoginActivity(login,senha))
            return ;

        try {
            usuarioNegocio.fazerLogin(login,senha);
            finish();
            Intent intentGoMain = new Intent(LoginActivity.this, PesquisaActivity.class);
            startActivity(intentGoMain);
            GuiUtil.showMessage(LoginActivity.this,"Login efetuado");
        } catch (ProjetoAlergiaException e){
            GuiUtil.showMessage(LoginActivity.this,e.getMessage());
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public boolean validarLoginActivity(String login, String senha){

        if((login==null || login.equals(""))&&(senha==null || senha.equals(""))){
            GuiUtil.showError(editTextLogin,"Login obrigatório");
            GuiUtil.showError(editTextSenha, "Senha Obrigatória");
            return false;
        }else if (login==null || login.equals("")){
            GuiUtil.showError(editTextLogin, "Login obrigatório");
            return false;
        }else if(senha==null || senha.equals("")){
            GuiUtil.showError(editTextSenha, "Senha Obrigatória");

            return false;
        }
        return true;
    }



    public static Context getContexto() {
        return contexto;
    }


    
}
