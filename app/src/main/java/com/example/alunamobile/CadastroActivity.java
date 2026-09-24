package com.example.alunamobile;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CadastroActivity extends Activity {
    private EditText etRa, etNome, etEmail;
    private TextView tvStatus;
    private AlunoDao alunoDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etRa = findViewById(R.id.etRa);
        etNome = findViewById(R.id.etNome);
        etEmail = findViewById(R.id.etEmail);
        tvStatus = findViewById(R.id.tvStatus);
        alunoDao = new AlunoDao(this);

        Button btnSalvar = findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(v -> salvarAluno());
    }

    private void salvarAluno() {
        String ra = etRa.getText().toString().trim();
        String nome = etNome.getText().toString().trim();
        String email = etEmail.getText().toString().trim();

        if (TextUtils.isEmpty(ra) || TextUtils.isEmpty(nome) || TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Preencha todos os campos.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Digite um e-mail válido.", Toast.LENGTH_SHORT).show();
            return;
        }

        long id = alunoDao.inserirAluno(ra, nome, email);
        if (id != -1) {
            tvStatus.setText("Cadastro salvo com sucesso! ID: " + id);
            etRa.setText("");
            etNome.setText("");
            etEmail.setText("");
        } else {
            tvStatus.setText("Não foi possível salvar. O RA pode já estar cadastrado.");
        }
    }
}
