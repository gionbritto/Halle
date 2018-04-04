package com.prointer.halle;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    Button botaocadastro;
    Button botaologin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

                /*if (  ) {


                }*/


            }
        });
    }
}
