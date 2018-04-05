package com.prointer.halle;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText logincampoemail;
    EditText logincamposenha;

    Button botaocadastro;
    Button botaologin;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logincampoemail = (EditText) findViewById(R.id.campo_login_email);
        logincamposenha = (EditText) findViewById(R.id.campo_login_senha);

        botaologin = (Button) findViewById(R.id.button_Entrar);
        botaocadastro = (Button) findViewById(R.id.button_cadastrar);

        botaocadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TelaCadastroActivity.class));
            }
        });

        botaologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = logincampoemail.getText().toString();
                String senha = logincamposenha.getText().toString();

                if (email.equals("")) { // Verifica se o campo da senha esta vazio
                    Toast.makeText(MainActivity.this, "Campo email vazio!", Toast.LENGTH_SHORT).show();
                } else if (senha.equals("")) {
                    Toast.makeText(MainActivity.this, "Campo senha vazio!", Toast.LENGTH_SHORT).show();
                } else {

                    //Caso o usuário já preencheu as informações irá verificar se tem os dados no banco de dados
                    String res = db.Validarlogin(email, senha);
                    if (res.equals("OK")) { // Caso os dados estajam corretos irá acessar

                        Toast.makeText(MainActivity.this, "Acessando...", Toast.LENGTH_SHORT).show();
                    } else {

                        Toast.makeText(MainActivity.this, "Login errado, tente novamente!", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
    }
}
