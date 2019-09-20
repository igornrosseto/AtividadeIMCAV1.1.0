package com.ems.imcatividade01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SegundaActivity extends AppCompatActivity {
    Button btStatus, btVoltar;
    TextView resultadoImc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        Intent it = getIntent();
        Bundle dados = it.getExtras();

        final IMC imc = new IMC();
        imc.setPeso(dados.getFloat("peso"));      // foi declarado valor de peso para o metodo calcular //
        imc.setAltura(dados.getDouble("altura"));  // foi declarado valor de altura para o metodo calcular //
        imc.calcularIMC();

        resultadoImc = findViewById(R.id.textIMC);
        resultadoImc.setText(String.format("%.2f", imc.getImc()));

        btStatus = findViewById(R.id.btMostraStatus);
        btStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), TerceiraActivity.class);
                Bundle dados = new Bundle();
                dados.putSerializable("objIMC", imc);
                it.putExtras(dados);
                startActivity(it);
            }
        });

        btVoltar = findViewById(R.id.btVoltarPrincipal);
        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}