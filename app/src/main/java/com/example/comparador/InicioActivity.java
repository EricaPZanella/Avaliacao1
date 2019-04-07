package com.example.comparador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class InicioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        Button botaoIrComparador = (Button) findViewById(R.id.botaoIrComparador);
        Button botaoIrConversor = (Button) findViewById(R.id.botaoIrConversor);

    }

    public void comparador(View v) {

        Intent comparador = new Intent(getApplicationContext(),ComparadorActivity.class);
        startActivity(comparador);
    }

    public void conversor(View v){

        Intent conversor = new Intent(getApplicationContext(),ConversorActivity.class);
        startActivity(conversor);

    }

}
