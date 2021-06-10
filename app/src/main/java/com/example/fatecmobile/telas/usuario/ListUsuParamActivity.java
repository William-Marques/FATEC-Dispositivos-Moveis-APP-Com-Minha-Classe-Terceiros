package com.example.fatecmobile.telas.usuario;

import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
//import android.support.*;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.fatecmobile.R;
import com.example.fatecmobile.dbs.ControllerUsuario;
import com.example.fatecmobile.modelos.UsuarioBean;

import java.util.List;

public class ListUsuParamActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView ListaDeAlunos;
    List<UsuarioBean> usuarios;
    Button pesqUsu;
    ArrayAdapter<UsuarioBean> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_usu_param);
        final Context con = getBaseContext();
        final ControllerUsuario ge = new ControllerUsuario(con);
        ListaDeAlunos = (ListView) findViewById(R.id.listausu);
        ListaDeAlunos.setOnItemClickListener(this); // Clique no item
        ListaDeAlunos.setOnItemLongClickListener(this); //
        final EditText login = (EditText)findViewById(R.id.login);

        pesqUsu = (Button) findViewById(R.id.btpesquisar);
        pesqUsu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String loginString = login.getText().toString();
                UsuarioBean usu = new UsuarioBean();
                usu.setLogin(loginString);
                usuarios = ge.listarUsuarios(usu);
                adapter = new ArrayAdapter<UsuarioBean>(con,android.R.layout.simple_list_item_1,usuarios);
                ListaDeAlunos.setAdapter(adapter);
            }
        });
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi pressionado
        // position é a posição do item no adapter
        UsuarioBean usu = (UsuarioBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListUsuParamActivity.this, UptUsuActivity.class);
        it.putExtra("Usuario",usu);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + usu.getId(),Toast.LENGTH_LONG).show();
        return true;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi clicado
        // position é a posição do item no adapter
        UsuarioBean usu = (UsuarioBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListUsuParamActivity.this, UptUsuActivity.class);
        it.putExtra("Usuario",usu);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Click :-" + position + " ID= " + usu.getId(),Toast.LENGTH_LONG).show();
    }
}