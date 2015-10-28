package mpoo.ufrpe.projetoalergia.gui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.util.InputMismatchException;

import mpoo.ufrpe.projetoalergia.R;
import mpoo.ufrpe.projetoalergia.dominio.dominioPessoa.Pessoa;
import mpoo.ufrpe.projetoalergia.dominio.dominioPessoa.Usuario;
import mpoo.ufrpe.projetoalergia.negocio.UsuarioNegocio;

public class CadastroActivity extends AppCompatActivity {

    private EditText editPessoaNome;
    private EditText editPessoaCPF;
    private EditText editUsuarioLogin;
    private EditText editUsuarioSenha;
    private EditText editUsuarioSenhaConfirmar;
    private Button btnCadastrar;
    private UsuarioNegocio usuarioNegocio;
    private static Context contexto;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        contexto = this;
        usuarioNegocio = UsuarioNegocio.getInstancia();

        editPessoaNome = (EditText) findViewById(R.id.edtNomePessoa);
        editPessoaCPF = (EditText) findViewById(R.id.edtCpf);
        editUsuarioLogin= (EditText) findViewById(R.id.edtLoginCadastro);
        editUsuarioSenha = (EditText) findViewById(R.id.edtSenhaCadastro);
        editUsuarioSenhaConfirmar = (EditText) findViewById(R.id.edtConfirmarSenhaCadastro);



//        MaskEditTextChangedListener maskCPF = new MaskEditTextChangedListener("###.###.###-##", cpf);


        btnCadastrar = (Button) findViewById(R.id.btnCadastrarCadastro);



        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = editPessoaNome.getText().toString().trim();

                String cpf = editPessoaCPF.getText().toString().trim();
                String login = editUsuarioLogin.getText().toString().trim();
                String senha = editUsuarioSenha.getText().toString().trim();
                String senhaConfirmar = editUsuarioSenhaConfirmar.getText().toString().trim();

                Usuario usuario = new Usuario(login,senha);
                Pessoa pessoa = new Pessoa(usuario,nome,cpf);

                cadastro(pessoa, senhaConfirmar);

            }
        });
    }

    public void cadastro(Pessoa pessoa,String confirmarSenha){

                    if(!validarCadastroVazioActivity(pessoa.getNome(),pessoa.getCpf(),pessoa.getUsuario().getLogin(),pessoa.getUsuario().getSenha(),confirmarSenha)){
                        return;
                    }
                    try{
                        usuarioNegocio.validarCadastro(pessoa,confirmarSenha);
                        finish();
//                        Intent intentGoLogin = new Intent(CadastroActivity.this, LoginActivity.class);
//                        startActivity(intentGoLogin);
                    }catch (Exception e){
                        GuiUtil.showMessage(CadastroActivity.this,e.getMessage());
                    }


    }

    public boolean validarCadastroVazioActivity( String nome, String cpf, String login, String senha, String confirmarSenha){

        if((nome == null || nome.equals(""))&&(cpf == null || cpf.equals(""))&&(login==null || login.equals(""))&&(senha==null || senha.equals(""))&&(confirmarSenha==null || confirmarSenha.equals(""))) {
            GuiUtil.showError(editPessoaNome, "Insira o nome");
            GuiUtil.showError(editPessoaCPF, "Insira o CPF");
            GuiUtil.showError(editUsuarioLogin, "Insira o Login");
            GuiUtil.showError(editUsuarioSenha, "Insira a senha");
            GuiUtil.showError(editUsuarioSenhaConfirmar, "Confirme a senha");
            return false;
        }else if(nome == null || nome.equals("")){
            GuiUtil.showError(editPessoaNome, "Insira o nome");
            return false;
        }else if(cpf == null || cpf.equals("")){
            GuiUtil.showError(editPessoaCPF, "Insira o CPF");
            return false;
        }else if (login==null || login.equals("")){
            GuiUtil.showError(editUsuarioLogin, "Insira o login");
            return false;
        }else if(senha==null || senha.equals("")){
            GuiUtil.showError(editUsuarioSenha, "Insira a senha");
            return false;
        }
        return true;
    }







    public String imprimeCPF(String CPF) {
        return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." + CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cadastro, menu);
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
}
