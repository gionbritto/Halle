package com.prointer.halle;

import android.app.Activity;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaCadastroActivity extends Activity {

    EditText camponome;
    EditText campoemail;
    EditText camposenha;
    Button botaosalvarcadastro;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro);

        camponome = (EditText) findViewById(R.id.campo_cadastro_nome);
        campoemail = (EditText) findViewById(R.id.campo_cadastro_email);
        camposenha = (EditText) findViewById(R.id.campo_cadastro_senha);
        botaosalvarcadastro = (Button) findViewById(R.id.button_salvar);

        //Instanciando a class do banco
        db = new DBHelper(this);


        botaosalvarcadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = camponome.getText().toString();
                String email = campoemail.getText().toString();
                String senha = camposenha.getText().toString();

                if (nome.equals("")) {

                    Toast.makeText(TelaCadastroActivity.this, "Campo nome vazio!", Toast.LENGTH_SHORT).show();

                } else if (email.equals("")) {

                    Toast.makeText(TelaCadastroActivity.this, "Campo email vazio!", Toast.LENGTH_SHORT).show();

                } else if (senha.equals("")) {

                    Toast.makeText(TelaCadastroActivity.this, "Campo senha vazio!", Toast.LENGTH_SHORT).show();
                } else {

                    //Todos os campos preenchidos e salvando as informações do usuário no banco de dados

                    long res = db.Criarusuario(nome, email, senha);

                    if (res > 0) {

                        Toast.makeText(TelaCadastroActivity.this, "Usuário cadastrado!", Toast.LENGTH_SHORT).show();
                    } else {

                        Toast.makeText(TelaCadastroActivity.this, "Cadastro inválido, tente novamente!", Toast.LENGTH_SHORT).show();
                    }
                }



            }
        });


    }
}
