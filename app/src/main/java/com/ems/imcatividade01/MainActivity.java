package com.ems.imcatividade01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText objPeso, objAltura;
    Button btCalcular;
    float peso;             // Alterado tipo variavel //
    double altura;         // Alterado tipo variavel //
    TextView erro;          // adicionado msg erro //
    TextView integrantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        erro = findViewById(R.id.msgErro) ;
        objPeso = findViewById(R.id.editPeso);
        objAltura = findViewById(R.id.editAltura);

        btCalcular = findViewById(R.id.btCalcular);
        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Adicionada mensagem de erro caso não sejam digitados os valores //

                if (objPeso.getText().toString().isEmpty() | objAltura.getText().toString().isEmpty()){
                    erro.setText("necessario preencher os dois campos para prosseguir.");
                }
                else {

                    peso = Float.parseFloat(objPeso.getText().toString());        // Alterado tipo variavel //
                    altura = Double.parseDouble(objAltura.getText().toString());  // Alterado tipo variavel //

                    Intent it = new Intent(getApplicationContext(), SegundaActivity.class);
                    Bundle dados = new Bundle();
                    dados.putFloat("peso", peso); // Inserido nos dados - peso //
                    dados.putDouble("altura", altura); // Inserido nos dados - altura //
                    it.putExtras(dados);
                    startActivity(it);
                }
            }
        });
    }
}
