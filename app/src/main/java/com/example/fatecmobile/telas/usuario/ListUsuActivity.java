package com.example.fatecmobile.telas.usuario;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
//import android.support.*;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
import android.view.View;

import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import com.example.fatecmobile.R;
import com.example.fatecmobile.dbs.ControllerUsuario;
import com.example.fatecmobile.modelos.UsuarioBean;

public class ListUsuActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView ListaDeAlunos;
    List<UsuarioBean> usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_usu);
        final ControllerUsuario ge = new ControllerUsuario(getBaseContext());
        ListaDeAlunos = (ListView) findViewById(R.id.listausu);
        usuarios = ge.listarUsuarios();
        ArrayAdapter<UsuarioBean> adapter = new ArrayAdapter<UsuarioBean>(this,android.R.layout.simple_list_item_1,usuarios);
        ListaDeAlunos.setAdapter(adapter);
        ListaDeAlunos.setOnItemClickListener(this); // Clique no item
        ListaDeAlunos.setOnItemLongClickListener(this); // Pressão sobre o item
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi pressionado
        // position é a posição do item no adapter
        UsuarioBean usu = (UsuarioBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListUsuActivity.this, UptUsuActivity.class);
        it.putExtra("Usuario",usu);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + usu.getId(),Toast.LENGTH_LONG).show();
        return true;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi clicado
        // position é a posição do item no adapter
        UsuarioBean usu = (UsuarioBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListUsuActivity.this, UptUsuActivity.class);
        it.putExtra("Usuario",usu);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Click :-" + position + " ID= " + usu.getId(),Toast.LENGTH_LONG).show();
    }
}
