package com.ems.imcatividade01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TerceiraActivity extends AppCompatActivity {
    TextView textStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceira);

        textStatus = findViewById(R.id.textStatus);

        Intent it = getIntent();
        Bundle dados = it.getExtras();

        IMC imc = (IMC) dados.getSerializable("objIMC");

        textStatus.setText(imc.getMensagem());

        Button v = findViewById(R.id.btVoltarIMC);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}