package mpoo.ufrpe.projetoalergia.gui;

import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Allan on 14/10/2015.
 */
public class GuiUtil {

    public static void showMessage(AppCompatActivity appCompatActivity,String messagem){
        Toast.makeText(appCompatActivity,messagem,Toast.LENGTH_SHORT).show();
    }
    public static void showError(EditText editText, String messagem){
        editText.setError(messagem);
    }
}
