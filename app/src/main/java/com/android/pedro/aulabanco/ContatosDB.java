package com.android.pedro.aulabanco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedro on 10/05/17.
 */

public class ContatosDB {

    private SQLiteDatabase sqLiteDb;

    public ContatosDB (Context context){
        sqLiteDb = new DataBaseHelper(context).getWritableDatabase();
    }

    public void inserir(Contatos contatos) throws Exception{
        ContentValues valores = new ContentValues();

        valores.put("nome",contatos.getNome());
        valores.put("telefone", contatos.getTelefone());
        sqLiteDb.insert("contatos",null,valores);

    }

    public List<Contatos> listar(){

        List <Contatos> list = new ArrayList<>();

        String[] colunas = new String[]{"id", "nome", "telefone"};

        Cursor cursor = sqLiteDb.query("contatos",colunas,null,null,null,null, "nome ASC");

        if(cursor.getCount()>0){
            cursor.moveToFirst();

            do{
                Contatos contatos = new Contatos();
                contatos.setId(cursor.getInt(cursor.getColumnIndex("id")));
                contatos.setNome(cursor.getString(cursor.getColumnIndex("nome")));
                contatos.setTelefone(cursor.getString(cursor.getColumnIndex("telefones")));
                list.add(contatos);

            }while (cursor.moveToNext());
        }

        return list;

    }
}
