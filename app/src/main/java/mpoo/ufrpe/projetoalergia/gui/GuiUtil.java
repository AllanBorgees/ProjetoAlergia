package mpoo.ufrpe.projetoalergia.gui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.net.URI;

import mpoo.ufrpe.projetoalergia.R;

/**
 * Created by Allan on 14/10/2015.
 */
public class GuiUtil extends AppCompatActivity {

    public static final Uri FOTO_PADRAO = Uri.parse("android.resources://drawable/usuario_padrao.jpg");
    public static Uri FOTO_TEMP = Uri.parse("android.resources://drawable/usuario_padrao.jpg");

    private static GuiUtil instancia = new GuiUtil();
    private GuiUtil(){}

    public static GuiUtil getInstancia() {
        return instancia;
    }

    public static void showMessage(AppCompatActivity appCompatActivity,String messagem){
        Toast.makeText(appCompatActivity,messagem,Toast.LENGTH_SHORT).show();
    }

    public static void showError(EditText editText, String messagem){
        editText.setError(messagem);
    }

    public String getImagePath(Context context, Uri contentUri) {
        String[] campos = { MediaStore.Images.Media.DATA };
        Cursor cursor = getContentResolver().query(contentUri, campos, null, null, null);
        cursor.moveToFirst();
        String path = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA));
        cursor.close();
        return path;
    }

    public int getImageId(Context context, Uri contentUri) {
        String[] campos = { MediaStore.Images.Media.DATA };
        Cursor cursor = getContentResolver().query(contentUri, campos, null, null, null);
        cursor.moveToFirst();
        int id = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA));
        cursor.close();
        return id;
    }

}

