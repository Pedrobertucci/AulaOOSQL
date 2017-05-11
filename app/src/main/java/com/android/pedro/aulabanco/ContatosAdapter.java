package com.android.pedro.aulabanco;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.pedro.aulabanco.Contatos;
import com.android.pedro.aulabanco.R;

import java.util.List;

/**
 * Created by pedro on 10/05/17.
 */

public class ContatosAdapter extends BaseAdapter {

    private Context context;
    private List<Contatos> list;

    public ContatosAdapter(Context context, List<Contatos> list) {
        this.context = context;
        this.list =list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int auxPosicao = position;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final RelativeLayout layout = (RelativeLayout)inflater.inflate(R.layout.activity_lista_contatos,null);
        TextView txtnome = (TextView)layout.findViewById(R.id.txtNome);
        txtnome.setText(list.get(position).getNome());
        return layout;
    }
}
