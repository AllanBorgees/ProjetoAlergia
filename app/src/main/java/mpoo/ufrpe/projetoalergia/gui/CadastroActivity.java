package mpoo.ufrpe.projetoalergia.gui;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    private EditText edtPessoaDataDeNascimentoCadastro;
    private Date dataNascimento;

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
        edtPessoaDataDeNascimentoCadastro = (EditText) findViewById(R.id.edtDataDeNascimentoCadastro);



        btnCadastrar = (Button) findViewById(R.id.btnCadastrarCadastro);


        ExibeDataListerner listerner = new ExibeDataListerner();
        edtPessoaDataDeNascimentoCadastro.setOnClickListener(listerner);
        edtPessoaDataDeNascimentoCadastro.setOnFocusChangeListener(listerner);




        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = editPessoaNome.getText().toString().trim();

                String cpf = editPessoaCPF.getText().toString().trim();
                String login = editUsuarioLogin.getText().toString().trim();
                String senha = editUsuarioSenha.getText().toString().trim();
                String senhaConfirmar = editUsuarioSenhaConfirmar.getText().toString().trim();
                String dataDeNascimento = edtPessoaDataDeNascimentoCadastro.getText().toString().trim();

                Usuario usuario = new Usuario(login,senha);
                Pessoa pessoa = new Pessoa(usuario,nome,cpf,dataNascimento);
                cadastro(pessoa, senhaConfirmar);

            }
        });
    }

    public void cadastro(Pessoa pessoa,String confirmarSenha){

                    if(!validarCadastroVazioActivity(pessoa,confirmarSenha)){
                        return;
                    }
                    if(!validarCampoCpf(pessoa.getCpf())){
                        return;
                    }
                    try{
                        usuarioNegocio.validarCadastro(pessoa,confirmarSenha);
                        finish();
                        Intent intentGoLogin = new Intent(CadastroActivity.this, LoginActivity.class);
                        startActivity(intentGoLogin);
                        GuiUtil.showMessage(CadastroActivity.this,"Usuário cadastrado");
                    }catch (Exception e){
                        GuiUtil.showMessage(CadastroActivity.this,e.getMessage());
                    }


    }

       public boolean validarCadastroVazioActivity( Pessoa pessoa , String confirmarSenha){
        if((pessoa.getNome() == null || pessoa.getNome().equals(""))&&(pessoa.getCpf() == null || pessoa.getCpf().equals(""))&&(pessoa.getUsuario().getLogin()==null
                || pessoa.getUsuario().getLogin().equals(""))&&(pessoa.getUsuario().getSenha()==null || pessoa.getUsuario().getSenha().equals(""))&&(confirmarSenha==null ||
                confirmarSenha.equals("")) && (pessoa.getDataDeNascimento()==null)) {

            GuiUtil.showError(editPessoaNome, "Insira o nome");
            GuiUtil.showError(editPessoaCPF, "Insira o CPF");
            GuiUtil.showError(editUsuarioLogin, "Insira o Login");
            GuiUtil.showError(editUsuarioSenha, "Insira a senha");
            GuiUtil.showError(editUsuarioSenhaConfirmar, "Confirme a senha");
            GuiUtil.showError(edtPessoaDataDeNascimentoCadastro,"Selecione a data de nascimento");
            return false;
        }else if(pessoa.getNome() == null || pessoa.getNome().equals("")){
            GuiUtil.showError(editPessoaNome, "Insira o nome");
            return false;
        }else if(pessoa.getCpf() == null || pessoa.getCpf().equals("")) {
            GuiUtil.showError(editPessoaCPF, "Insira o CPF");
            return false;
        }else if(pessoa.getDataDeNascimento()==null){
            GuiUtil.showError(edtPessoaDataDeNascimentoCadastro,"Selecione a data de nascimento");
            return false;
        }else if (pessoa.getUsuario().getLogin()==null || pessoa.getUsuario().getLogin().equals("")){
            GuiUtil.showError(editUsuarioLogin, "Insira o login");
            return false;
        }else if(pessoa.getUsuario().getSenha()==null || pessoa.getUsuario().getSenha().equals("")){
            GuiUtil.showError(editUsuarioSenha, "Insira a senha");
            return false;
        }
        return true;
    }

    public boolean validarCampoCpf(String cpf) {

        if (cpf.length() != 11) {
            GuiUtil.showError(editPessoaCPF, "O CPF deve conter apenas 11 digitos!");
            return false;

        }
        if (cpf == "00000000000" || cpf.equals("00000000000")||cpf == "11111111111" || cpf.equals("11111111111") ||
                cpf == "22222222222" || cpf.equals("22222222222") || cpf == "33333333333" || cpf.equals("33333333333") ||
                cpf == "44444444444" || cpf.equals("44444444444") || cpf == "55555555555" || cpf.equals("55555555555")
                ||cpf == "66666666666" || cpf.equals("66666666666") || cpf == "77777777777" || cpf.equals("77777777777")
                ||cpf == "88888888888" || cpf.equals("99999999999")){
            GuiUtil.showError(editPessoaCPF, "CPF invalido");
            return false;
        }

        Pattern pattern = Pattern.compile("\\d{11}");
        Matcher matcher = pattern.matcher(cpf);
        if(!matcher.find()) {
            GuiUtil.showError(editPessoaCPF, "O CPF deve conter apenas numeros!");
            return false;
        }


        return true;
    }


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

    private void exibeData() {
        Calendar calendar= Calendar.getInstance();

        int ano = calendar.get(Calendar.YEAR);
        int mes = calendar.get(Calendar.MONTH);
        int dia = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dlg = new DatePickerDialog(this,new SelecionaDataListener(), ano, mes, dia);
        dlg.show();

    }
    private class ExibeDataListerner implements View.OnClickListener, View.OnFocusChangeListener
    {
        @Override
        public void onClick(View v) {
            exibeData();
        }
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if(hasFocus)
                exibeData();
        }
    }
    private class SelecionaDataListener implements DatePickerDialog.OnDateSetListener
    {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            Calendar data = Calendar.getInstance();

            data.set(year, monthOfYear, dayOfMonth);

             dataNascimento = data.getTime();

            DateFormat format = DateFormat.getDateInstance(DateFormat.SHORT);
            String dt = format.format(dataNascimento);

            edtPessoaDataDeNascimentoCadastro.setText(dt);
        }
    }

    public void tirarFoto(View view){
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivityForResult(intent, 0);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(data != null){
            Bundle bundle = data.getExtras();
            if(bundle != null){
                Bitmap img = (Bitmap) bundle.get("data");

                ImageView iv = (ImageView) findViewById(R.id.imageView);
                iv.setImageBitmap(img);
            }
        }
    }

}
