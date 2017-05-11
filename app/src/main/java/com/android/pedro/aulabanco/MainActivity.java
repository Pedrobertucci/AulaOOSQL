package com.android.pedro.aulabanco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nome,telefone;
    Contatos contatos;
    ContatosDB db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = (EditText) findViewById(R.id.edtNome);
        telefone = (EditText) findViewById(R.id.edtTelefone);

        db = new ContatosDB(this);
    }


    public void inserir(View v){
        try{
            contatos = new Contatos();

            contatos.setNome(nome.getText().toString());
            contatos.setTelefone(telefone.getText().toString());

            db.inserir(contatos);

            Toast.makeText(MainActivity.this,"Contato salvo com sucesso", Toast.LENGTH_LONG).show();

        }catch (Exception e){
            Toast.makeText(MainActivity.this,"Errrrooooouu ao salvar o contato", Toast.LENGTH_LONG).show();
        }
    }

    public void listar(View v){
        Intent intent = new Intent(this,listaContatos.class);

    }
}
