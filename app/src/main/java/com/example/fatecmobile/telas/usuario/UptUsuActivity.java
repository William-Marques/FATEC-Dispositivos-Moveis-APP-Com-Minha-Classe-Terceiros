package com.example.fatecmobile.telas.usuario;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
//import android.support.*;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fatecmobile.R;
import com.example.fatecmobile.dbs.ControllerUsuario;
import com.example.fatecmobile.modelos.UsuarioBean;

public class UptUsuActivity extends AppCompatActivity {

    Button uptUsu, delUsu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upt_usu);
        final ControllerUsuario ge = new ControllerUsuario(getBaseContext());
        final EditText login = (EditText)findViewById(R.id.login);
        final EditText senha = (EditText)findViewById((R.id.senha));
        final EditText status = (EditText)findViewById(R.id.status);
        final EditText tipo = (EditText)findViewById(R.id.tipo);
        Intent it = getIntent();
        final UsuarioBean recuperado = (UsuarioBean) it.getSerializableExtra("Usuario");
        login.setText(recuperado.getLogin());
        senha.setText(recuperado.getSenha());
        status.setText(recuperado.getStatus());
        tipo.setText(recuperado.getTipo());

        uptUsu = (Button) findViewById(R.id.btalterar);
        uptUsu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String loginString = login.getText().toString();
                String senhaString = senha.getText().toString();
                String statusString = status.getText().toString();
                String tipoString = tipo.getText().toString();
                recuperado.setLogin(loginString);
                recuperado.setSenha(senhaString);
                recuperado.setStatus(statusString);
                recuperado.setTipo(tipoString);
                String msg = ge.alterar(recuperado);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });

        delUsu = (Button) findViewById(R.id.btexcluir);
        delUsu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String msg = ge.excluir(recuperado);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });


    }
}
