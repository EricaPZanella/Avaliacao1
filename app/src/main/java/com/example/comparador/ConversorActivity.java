package com.example.comparador;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ConversorActivity extends AppCompatActivity {


    private TextView labelUnidade;
    private EditText TextConverter;
    private TextView labelResultado;
    private Button botaoConverter;
    private Spinner spiUnidade;
    private Spinner spiUnidade2;

    public ConversorActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor);

        labelUnidade = (TextView) findViewById(R.id.labelUnidade);
        TextConverter = (EditText) findViewById(R.id.TextConverter);
        labelResultado = (TextView) findViewById(R.id.labelResultado);
        Button botaoConverter = (Button) findViewById(R.id.botaoConverter);
        spiUnidade = (Spinner) findViewById(R.id.spiUnidade);
        spiUnidade2 = (Spinner) findViewById(R.id.spiUnidade2);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.Unidade_medida, android.R.layout.simple_spinner_item);
        spiUnidade.setAdapter(adapter);
        spiUnidade2.setAdapter(adapter);

    }


    public void converterNum(View v) {

        String converter = TextConverter.getText().toString();
        BigDecimal unidConverter = new BigDecimal(converter);

        BigDecimal conversao = converter(unidConverter);
        if(conversao.equals(BigDecimal.ZERO)) {
            labelResultado.setText(getResources().getString(R.string.naopossivel));
        }
        else {
            String resultado = conversao.toString();
            labelResultado.setText(resultado);
        }
    }

    private BigDecimal converter(BigDecimal unidConverter) {


        BigDecimal valorConvertido = BigDecimal.ZERO;
        String unidade1= (String) spiUnidade.getSelectedItem();
        String unidade2 = (String) spiUnidade2.getSelectedItem();

        //g para kg
        if((unidade1.equalsIgnoreCase("g")) && (unidade2.equalsIgnoreCase("kg"))){

            return valorConvertido = unidConverter.divide(new BigDecimal(1000));

        }
        //kg para g
        if((unidade1.equalsIgnoreCase("kg")) && (unidade2.equalsIgnoreCase("g"))){

            return valorConvertido = unidConverter.multiply(new BigDecimal(1000));
        }
        //ml para l
        if((unidade1.equalsIgnoreCase("ml")) && (unidade2.equalsIgnoreCase("l"))){

            return valorConvertido = unidConverter.divide(new BigDecimal(1000));

       }
        //l para ml
        if((unidade1.equalsIgnoreCase("l")) && (unidade2.equalsIgnoreCase("ml"))){

            return valorConvertido = unidConverter.multiply(new BigDecimal(1000));
        }
        return  valorConvertido;

    }


}
