package com.example.fatecmobile.telas.terceiro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fatecmobile.R;
import com.example.fatecmobile.dbs.ControllerTerceiro;
import com.example.fatecmobile.modelos.TerceiroBean;

import java.util.List;

public class ListTerceiroActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView ListaDeAlunos;
    List<TerceiroBean> terceiros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_terceiro);
        final ControllerTerceiro ge = new ControllerTerceiro(getBaseContext());
        ListaDeAlunos = (ListView) findViewById(R.id.listater);
        terceiros = ge.listarTerceiros();
        ArrayAdapter<TerceiroBean> adapter = new ArrayAdapter<TerceiroBean>(this,android.R.layout.simple_list_item_1,terceiros);
        ListaDeAlunos.setAdapter(adapter);
        ListaDeAlunos.setOnItemClickListener(this); // Clique no item
        ListaDeAlunos.setOnItemLongClickListener(this); // Pressão sobre o item
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi pressionado
        // position é a posição do item no adapter
        TerceiroBean ter = (TerceiroBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListTerceiroActivity.this, UptTerceiroActivity.class);
        it.putExtra("Terceiro",ter);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + ter.getId(),Toast.LENGTH_LONG).show();
        return true;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi clicado
        // position é a posição do item no adapter
        TerceiroBean ter = (TerceiroBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListTerceiroActivity.this, UptTerceiroActivity.class);
        it.putExtra("Terceiro",ter);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Click :-" + position + " ID= " + ter.getId(),Toast.LENGTH_LONG).show();
    }
}
