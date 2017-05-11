package com.android.pedro.aulabanco;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class listaContatos extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contatos);


        ContatosDB db = new ContatosDB(this);
        setListAdapter(new ContatosAdapter(this,  db.listar()));
    }
}
