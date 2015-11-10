package mpoo.ufrpe.projetoalergia.gui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mpoo.ufrpe.projetoalergia.R;
import mpoo.ufrpe.projetoalergia.dominio.dominoRemedio.RemedioDTO;

/**
 * Created by Airton on 08/11/2015.
 */
public class AdapterListRemedio extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<RemedioDTO> itens;

    public AdapterListRemedio(Context context, List<RemedioDTO> itens)
    {
        //Itens que preencheram o listview
        this.itens = itens;
        //responsavel por pegar o Layout do item.
        mInflater = LayoutInflater.from(context);
    }
    /**
     * Retorna a quantidade de itens
     *
     * @return
     */
    public int getCount()
    {
        return itens.size();
    }

    /**
     * Retorna o item de acordo com a posicao dele na tela.
     *
     * @param position
     * @return
     */
    public RemedioDTO getItem(int position)
    {
        return itens.get(position);
    }

    /**
     * Sem implementação
     *
     * @param position
     * @return
     */
    public long getItemId(int position)
    {
        return position;
    }

    public View getView(int position, View view, ViewGroup parent)
    {
        //Pega o item de acordo com a posção.
        RemedioDTO item = itens.get(position);
        //infla o layout para podermos preencher os dados
        view = mInflater.inflate(R.layout.item_list_remedio, null);

        //atravez do layout pego pelo LayoutInflater, pegamos cada id relacionado
        //ao item e definimos as informações.
        ((TextView) view.findViewById(R.id.text)).setText(item.getNome());
        ((ImageView) view.findViewById(R.id.imagemview)).setImageResource(item.getIdIcone());

        return view;
    }
}
