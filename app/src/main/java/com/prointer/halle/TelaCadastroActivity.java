package com.prointer.halle;

import android.app.Activity;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaCadastroActivity extends Activity {

    EditText camponome;
    EditText campoemail;
    EditText camposenha;
    Button botaosalvarcadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro);

        camponome = (EditText) findViewById(R.id.campo_cadastro_nome);
        campoemail = (EditText) findViewById(R.id.campo_cadastro_email);
        camposenha = (EditText) findViewById(R.id.campo_cadastro_senha);
        botaosalvarcadastro = (Button) findViewById(R.id.button_salvar);


        botaosalvarcadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Pegando as informações que o usuário digitou
                camponome.getText().toString();
                campoemail.getText().toString();
                camposenha.getText();


                try {

                    //Criando o banco de dados
                    SQLiteDatabase banco = openOrCreateDatabase("app", MODE_PRIVATE, null);

                    //Criando as tabelas
                    banco.execSQL("CREATE TABLE IF NOT EXISTS usuario (nome VARCHAR, email VARCHAR, senha VARCHAR)");

                    //Criar tabela com ID único nas colunas com autoincrement para gerar número automático.
                    banco.execSQL("CREATE TABLE IF NOT EXISTS usuario (id INTEGER PRIMARY KEY AUTOINCREMENT, email VARCHAR, senha VARCHAR) ");

                    //Adicionando as informações no banco de dados
                    banco.execSQL("INSERT INTO pessoas (nome, email, senha) VALUES ('camponome','campoemail','camposenha')");

                } catch (Exception e) {

                    e.printStackTrace();

                }

                Toast.makeText(TelaCadastroActivity.this, "GRAVOU, TESTAR INFO NO BANCO", Toast.LENGTH_SHORT).show();


            }
        });


    }
}
