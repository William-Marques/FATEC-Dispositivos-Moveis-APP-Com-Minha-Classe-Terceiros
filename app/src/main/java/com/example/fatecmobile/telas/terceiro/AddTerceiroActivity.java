package com.example.fatecmobile.telas.terceiro;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fatecmobile.R;
import com.example.fatecmobile.dbs.ControllerTerceiro;
import com.example.fatecmobile.modelos.TerceiroBean;

public class AddTerceiroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_terceiro);
        final ControllerTerceiro ge = new ControllerTerceiro(getBaseContext());
        Button Inserir = (Button) findViewById(R.id.btinserirterceiro);

        Inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText nome  = (EditText) findViewById(R.id.nome);
                EditText datanascimento  = (EditText) findViewById((R.id.datanascimento));
                EditText cpf = (EditText) findViewById(R.id.cpf);
                EditText genero   = (EditText) findViewById(R.id.genero);
                EditText endereco   = (EditText) findViewById(R.id.endereco);
                EditText telefone   = (EditText) findViewById(R.id.telefone);
                EditText email   = (EditText) findViewById(R.id.email);

                String nomeString = nome.getText().toString();
                String datanascimentoString = datanascimento.getText().toString();
                String cpfString = cpf.getText().toString();
                String generoString = genero.getText().toString();
                String enderecoString = endereco.getText().toString();
                String telefoneString = telefone.getText().toString();
                String emailString = email.getText().toString();

                TerceiroBean ter = new TerceiroBean();
                ter.setId("");
                ter.setNome(nomeString);
                ter.setDatanascimento(datanascimentoString);
                ter.setCpf(cpfString);
                ter.setGenero(generoString);
                ter.setEndereco(enderecoString);
                ter.setTelefone(telefoneString);
                ter.setEmail(emailString);
                String msg = ge.inserir(ter);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });
    }

}
