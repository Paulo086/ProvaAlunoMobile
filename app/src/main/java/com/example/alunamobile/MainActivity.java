package com.example.alunamobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNotas = findViewById(R.id.btnNotas);
        Button btnCadastro = findViewById(R.id.btnCadastro);

        btnNotas.setOnClickListener(v -> startActivity(new Intent(this, NotasActivity.class)));
        btnCadastro.setOnClickListener(v -> startActivity(new Intent(this, CadastroActivity.class)));
    }
}
