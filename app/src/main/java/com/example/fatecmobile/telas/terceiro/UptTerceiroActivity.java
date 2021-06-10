package com.example.fatecmobile.telas.terceiro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fatecmobile.R;
import com.example.fatecmobile.dbs.ControllerTerceiro;
import com.example.fatecmobile.modelos.TerceiroBean;

public class UptTerceiroActivity extends AppCompatActivity {

    Button uptTer, delTer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upt_terceiro);
        final ControllerTerceiro ge = new ControllerTerceiro(getBaseContext());
        final EditText nome = (EditText)findViewById(R.id.nome);
        final EditText datanascimento = (EditText)findViewById((R.id.datanascimento));
        final EditText cpf = (EditText)findViewById(R.id.cpf);
        final EditText genero = (EditText)findViewById(R.id.genero);
        final EditText endereco = (EditText)findViewById(R.id.endereco);
        final EditText telefone = (EditText)findViewById(R.id.telefone);
        final EditText email = (EditText)findViewById(R.id.email);
        Intent it = getIntent();
        final TerceiroBean recuperado = (TerceiroBean) it.getSerializableExtra("Terceiro");
        nome.setText(recuperado.getNome());
        datanascimento.setText(recuperado.getDatanascimento());
        cpf.setText(recuperado.getCpf());
        genero.setText(recuperado.getGenero());
        endereco.setText(recuperado.getEndereco());
        telefone.setText(recuperado.getTelefone());
        email.setText(recuperado.getEmail());

        uptTer = (Button) findViewById(R.id.btalterar);
        uptTer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String nomeString = nome.getText().toString();
                String datanascimentoString = datanascimento.getText().toString();
                String cpfString = cpf.getText().toString();
                String generoString = genero.getText().toString();
                String enderecoString = endereco.getText().toString();
                String telefoneString = telefone.getText().toString();
                String emailString = email.getText().toString();
                recuperado.setNome(nomeString);
                recuperado.setDatanascimento(datanascimentoString);
                recuperado.setCpf(cpfString);
                recuperado.setGenero(generoString);
                recuperado.setEndereco(enderecoString);
                recuperado.setTelefone(telefoneString);
                recuperado.setEmail(emailString);
                String msg = ge.alterar(recuperado);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });

        delTer = (Button) findViewById(R.id.btexcluir);
        delTer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String msg = ge.excluir(recuperado);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });


    }
}
