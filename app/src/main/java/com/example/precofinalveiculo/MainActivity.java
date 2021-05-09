package com.example.precofinalveiculo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText precoFabrica;
    EditText percentualLucro;
    EditText percentualImpostos;
    Button calcular;
    TextView valorDistribuidor;
    TextView valorImpostos;
    TextView precoFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoFabrica = (EditText) findViewById(R.id.editTextTextPersonName);
        percentualLucro = (EditText) findViewById(R.id.editTextTextPersonName2);
        percentualImpostos = (EditText) findViewById(R.id.editTextTextPersonName3);
        calcular = (Button) findViewById(R.id.button);
        valorDistribuidor = (TextView) findViewById(R.id.textView5);
        valorImpostos = (TextView) findViewById(R.id.textView6);
        precoFinal = (TextView) findViewById(R.id.textView7);

        calcular.setOnClickListener(c->{
            if (precoFabrica.getText().toString().contains(",") || percentualImpostos.getText().toString().contains(",")
            || percentualLucro.getText().toString().contains(",")){
                Toast.makeText(this, "Caso pretenda inserir um valor decimal substitua a vírgula pelo ponto.", Toast.LENGTH_SHORT).show();
            } else {
                double valorDoDistribuidor, valorDosImpostos, valorDoPrecoFinal;

                valorDoDistribuidor = (Double.parseDouble(precoFabrica.getText().toString()) * Double.parseDouble(percentualLucro.getText().toString()))/100;
                valorDosImpostos = (Double.parseDouble(precoFabrica.getText().toString()) * Double.parseDouble(percentualImpostos.getText().toString())) / 100;
                valorDoPrecoFinal = Double.parseDouble(precoFabrica.getText().toString()) + valorDoDistribuidor + valorDosImpostos;
                valorDistribuidor.setText(Double.toString(valorDoDistribuidor));
                valorImpostos.setText(Double.toString(valorDosImpostos));
                precoFinal.setText(Double.toString(valorDoPrecoFinal));
            }
        });
    }
}