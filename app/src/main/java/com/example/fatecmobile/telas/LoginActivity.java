package com.example.fatecmobile.telas;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
//import android.support.*;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

import com.example.fatecmobile.dbs.ControllerUsuario;
import com.example.fatecmobile.modelos.UsuarioBean;
import com.example.fatecmobile.R;
import com.example.fatecmobile.telas.usuario.AddUsuActivity;

public class LoginActivity extends AppCompatActivity {

    EditText login,senha;
    Button addUsu, entrar;
    String slogin;
    String ssenha;
    UsuarioBean usuEnt;
    UsuarioBean usuSai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final ControllerUsuario ge = new ControllerUsuario(getBaseContext());

        login = (EditText) findViewById(R.id.login);
        senha = (EditText) findViewById(R.id.senha);

        slogin = login.getText().toString();
        ssenha = senha.getText().toString();

        usuEnt = new UsuarioBean();
        usuEnt.setLogin(slogin);
        usuEnt.setSenha(ssenha);

        addUsu = (Button) findViewById(R.id.btnovousu);
        addUsu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(LoginActivity.this, AddUsuActivity.class);
                startActivity(it);
            }
        });

        entrar = (Button) findViewById(R.id.btentrar);
        entrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                usuSai = ge.validarUsuarios(usuEnt);
                Intent it = new Intent(LoginActivity.this, MenuActivity.class);
                it.putExtra("UsuarioLogado",usuSai);
                startActivity(it);
            }
        });

    }
}
