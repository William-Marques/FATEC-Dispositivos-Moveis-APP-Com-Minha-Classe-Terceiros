package com.example.fatecmobile.telas.terceiro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fatecmobile.R;
import com.example.fatecmobile.dbs.ControllerTerceiro;
import com.example.fatecmobile.modelos.TerceiroBean;

import java.util.List;

public class ListTerceiroParamActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView ListaDeAlunos;
    List<TerceiroBean> terceiros;
    Button pesqTer;
    ArrayAdapter<TerceiroBean> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_terceiro_param);
        final Context con = getBaseContext();
        final ControllerTerceiro ge = new ControllerTerceiro(con);
        ListaDeAlunos = (ListView) findViewById(R.id.listater);
        ListaDeAlunos.setOnItemClickListener(this); // Clique no item
        ListaDeAlunos.setOnItemLongClickListener(this); //
        final EditText nome = (EditText)findViewById(R.id.nome);

        pesqTer = (Button) findViewById(R.id.btpesquisar);
        pesqTer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String nomeString = nome.getText().toString();
                TerceiroBean ter = new TerceiroBean();
                ter.setNome(nomeString);
                terceiros = ge.listarTerceiros(ter);
                adapter = new ArrayAdapter<TerceiroBean>(con,android.R.layout.simple_list_item_1,terceiros);
                ListaDeAlunos.setAdapter(adapter);
            }
        });
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi pressionado
        // position é a posição do item no adapter
        TerceiroBean ter = (TerceiroBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListTerceiroParamActivity.this, UptTerceiroActivity.class);
        it.putExtra("Terceiro",ter);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + ter.getId(),Toast.LENGTH_LONG).show();
        return true;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi clicado
        // position é a posição do item no adapter
        TerceiroBean ter = (TerceiroBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListTerceiroParamActivity.this, UptTerceiroActivity.class);
        it.putExtra("Terceiro",ter);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Click :-" + position + " ID= " + ter.getId(),Toast.LENGTH_LONG).show();
    }
}