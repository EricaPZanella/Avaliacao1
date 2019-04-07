package com.example.comparador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.BigDecimal;

public class ComparadorActivity extends AppCompatActivity implements View.OnClickListener {

            private Spinner unidade;
            private Spinner unidade2;
            private EditText TextPreco1;
            private EditText TextPreco2;
            private EditText TextQuantidade1;
            private EditText TextQuantidade2;
            private TextView TextResultado;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_comparador);

                //listagem spinner unidade
                unidade = (Spinner) findViewById(R.id.spiQuantidade1);

                ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.Unidade_medida, android.R.layout.simple_spinner_item);
                unidade.setAdapter(adapter);

                //listagem spinner unidade2
                unidade2 = (Spinner) findViewById(R.id.spiQuantidade2);
                //ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this. R.array.Unidade_medida, android.R.layout.simple_spinner_item);
                unidade2.setAdapter(adapter);

                TextPreco1 = (EditText) findViewById(R.id.TextPreco1);
                TextPreco2 = (EditText) findViewById(R.id.TextPreco2);
                TextQuantidade1 = (EditText) findViewById(R.id.TextQuantidade1);
                TextQuantidade2 = (EditText) findViewById(R.id.TextQuantidade2);
                Button botaoCalcular = (Button) findViewById(R.id.botaoCalcular);
                botaoCalcular.setOnClickListener(this);
                TextResultado = (TextView) findViewById(R.id.TextResultado);

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.botaoCalcular){

            String quant1 = TextQuantidade1.getText().toString();
            BigDecimal quantidade1 = new BigDecimal(quant1);

            String quant2 = TextQuantidade2.getText().toString();
            BigDecimal quantidade2 = new BigDecimal(quant2);

            String pcVenda1 = TextPreco1.getText().toString();
            BigDecimal precoVenda1 = new BigDecimal(pcVenda1);

            String pcVenda2 = TextPreco2.getText().toString();
            BigDecimal precoVenda2 = new BigDecimal(pcVenda2);

            String strunidade1= (String) unidade.getSelectedItem();
            String strunidade2 = (String) unidade2.getSelectedItem();
            BigDecimal precoCustoPorEmbalagem1 = calculaPrecoCustoEmbalagem(quantidade1, precoVenda1, strunidade1);
            BigDecimal precoCustoPorEmbalagem2 = calculaPrecoCustoEmbalagem(quantidade2, precoVenda2, strunidade2);
            calculaMenorPrecoCusto(precoCustoPorEmbalagem1, precoCustoPorEmbalagem2);
        }

    }

    public BigDecimal calculaPrecoCustoEmbalagem(BigDecimal quantidade, BigDecimal precoVenda, String unid)
    {
        BigDecimal custoEmbalagem =  BigDecimal.ZERO;
        BigDecimal quantidadeAux = BigDecimal.ZERO;
        String unidade = unid;

        if((unidade.equalsIgnoreCase("g")) || (unidade.equalsIgnoreCase("ml")))
         {
             quantidadeAux = quantidade.divide(new BigDecimal(1000));
         }
        try{
            custoEmbalagem = precoVenda.divide(quantidadeAux);
            return custoEmbalagem;
        }catch (ArithmeticException e){
            e.printStackTrace();
        }
        return custoEmbalagem;
    }

    void calculaMenorPrecoCusto(BigDecimal valorCusto1, BigDecimal valorCusto2)
    {
        if (valorCusto1.compareTo(valorCusto2) > 0)
        {
            TextResultado.setText(getResources().getString(R.string.ummais));
        }
        else if (valorCusto1.compareTo(valorCusto2) < 0)
        {
            TextResultado.setText(getResources().getString(R.string.doismais));
        }
        else
        {
            TextResultado.setText(getResources().getString(R.string.iguais));
        }
    }
}
