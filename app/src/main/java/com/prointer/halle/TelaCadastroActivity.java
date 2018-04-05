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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro);

        camponome = (EditText) findViewById(R.id.campo_cadastro_nome);
        campoemail = (EditText) findViewById(R.id.campo_cadastro_email);
        camposenha = (EditText) findViewById(R.id.campo_cadastro_senha);
        botaosalvarcadastro = (Button) findViewById(R.id.button_salvar);

        //Criando o banco de dados




        botaosalvarcadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Pegando as informações que o usuário digitou
                camponome.getText().toString();
                campoemail.getText().toString();
                camposenha.getText();


                try {

                    SQLiteDatabase banco = openOrCreateDatabase("app", MODE_PRIVATE, null);

                    //Criando as tabelas
                    banco.execSQL("CREATE TABLE IF NOT EXISTS usuario (nome VARCHAR, email VARCHAR, senha VARCHAR)");

                    //Criar tabela com ID único nas colunas com autoincrement para gerar número automático.
                    banco.execSQL("CREATE TABLE IF NOT EXISTS usuario (id INTEGER PRIMARY KEY AUTOINCREMENT, email VARCHAR, senha VARCHAR) ");

                    //Adicionando as informações no banco de dados
                    banco.execSQL("INSERT INTO pessoas (nome, email, senha) VALUES ('camponome','campoemail','camposenha')");


                    //Criando um cursos para pesquisa nas colunas, ele para no última linha da coluna, é necessário retornar o cursos.
                    Cursor cursor = banco.rawQuery("SELECT * FROM usuario ", null);

                    //Recuperar o índice da coluna
                    int indicecolunanome = cursor.getColumnIndex("nome");
                    int indicecolunaemail = cursor.getColumnIndex("email");
                    int indicecolunasenha = cursor.getColumnIndex("senha");
                    int indicecolunaid = cursor.getColumnIndex("id");


                    //Voltando o cursor para a primeira linha da coluna
                    cursor.moveToFirst();


                    while (cursor != null) {

                /*Esses códigos abaixo serve para recuperar as informações da coluna*/

                        cursor.getString(indicecolunanome);

                        Toast.makeText(TelaCadastroActivity.this, cursor.getString(indicecolunanome), Toast.LENGTH_SHORT).show();

                        //Movendo o cursos para a próxima linha
                        cursor.moveToNext();

                    }




                } catch (Exception e) {

                    e.printStackTrace();

                }


            }
        });


    }
}
