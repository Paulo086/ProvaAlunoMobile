package com.example.alunamobile;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Locale;

public class NotasActivity extends Activity {
    private EditText nota1, nota2, trabalho, atividade;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);
        nota1 = findViewById(R.id.etNota1);
        nota2 = findViewById(R.id.etNota2);
        trabalho = findViewById(R.id.etTrabalho);
        atividade = findViewById(R.id.etAtividade);
        resultado = findViewById(R.id.tvResultado);
        Button btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(v -> calcularMedia());
    }

    private void calcularMedia() {
        String s1 = nota1.getText().toString().trim();
        String s2 = nota2.getText().toString().trim();
        String s3 = trabalho.getText().toString().trim();
        String s4 = atividade.getText().toString().trim();
        if (TextUtils.isEmpty(s1) || TextUtils.isEmpty(s2) || TextUtils.isEmpty(s3) || TextUtils.isEmpty(s4)) {
            Toast.makeText(this, "Preencha todas as notas.", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            double n1 = parseNota(s1), n2 = parseNota(s2), trab = parseNota(s3), ativ = parseNota(s4);
            if (!notaValida(n1) || !notaValida(n2) || !notaValida(trab) || !notaValida(ativ)) {
                Toast.makeText(this, "As notas devem estar entre 0 e 10.", Toast.LENGTH_SHORT).show();
                return;
            }
            double media = (n1 + n2 + trab + ativ) / 4.0;
            resultado.setText(String.format(Locale.getDefault(), "Média final: %.2f", media));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Digite apenas números válidos.", Toast.LENGTH_SHORT).show();
        }
    }

    private double parseNota(String valor) { return Double.parseDouble(valor.replace(",", ".")); }
    private boolean notaValida(double nota) { return nota >= 0 && nota <= 10; }
}
