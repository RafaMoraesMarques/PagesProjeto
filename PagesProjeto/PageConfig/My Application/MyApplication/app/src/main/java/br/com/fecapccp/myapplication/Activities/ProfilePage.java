package br.com.fecapccp.myapplication.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import br.com.fecapccp.myapplication.Models.Motorista;
import br.com.fecapccp.myapplication.R;

public class ProfilePage extends AppCompatActivity {

    Button botaoAtualizar;
    String nomeOriginal, sobrenomeOriginal, telefoneOriginal, emailOriginal;

    ImageView botaoVoltar, setaNome, setaTelefone, setaEmail;
    LinearLayout layoutNome, layoutTelefone, layoutEmail;
    LinearLayout camposNome, camposTelefone, camposEmail;
    EditText editNome1, editNome2, editTelefone, editEmail;

    boolean expandedNome = false;
    boolean expandedTelefone = false;
    boolean expandedEmail = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(() -> {
            carregarDadosUsuario();
        }, 500); // Aguarda 0.5 segundos antes de recarregar os dados


        // Botão voltar
        botaoVoltar = findViewById(R.id.botaoVoltar);
        botaoVoltar.setOnClickListener(v -> finish());

        // Inicialização dos layouts e setas
        layoutNome = findViewById(R.id.layoutNome);
        layoutTelefone = findViewById(R.id.layoutTelefone);
        layoutEmail = findViewById(R.id.layoutEmail);

        camposNome = findViewById(R.id.camposNome);
        camposTelefone = findViewById(R.id.camposTelefone);
        camposEmail = findViewById(R.id.camposEmail);

        editNome1 = findViewById(R.id.editNome1);
        editNome2 = findViewById(R.id.editNome2);
        editTelefone = findViewById(R.id.editTelefone);
        editEmail = findViewById(R.id.editEmail);

        setaNome = findViewById(R.id.setaNome);
        setaTelefone = findViewById(R.id.setaTelefone);
        setaEmail = findViewById(R.id.setaEmail);

        // Botão para atualizar dados
        botaoAtualizar = findViewById(R.id.botaoAtualizar);
        botaoAtualizar.setOnClickListener(v -> atualizarDados());

        // Clique Nome
        layoutNome.setOnClickListener(v -> {
            expandedNome = !expandedNome;
            camposNome.setVisibility(expandedNome ? View.VISIBLE : View.GONE);
            setaNome.animate().rotation(expandedNome ? 90 : 0).setDuration(200).start();
        });

        // Clique Telefone
        layoutTelefone.setOnClickListener(v -> {
            expandedTelefone = !expandedTelefone;
            camposTelefone.setVisibility(expandedTelefone ? View.VISIBLE : View.GONE);
            setaTelefone.animate().rotation(expandedTelefone ? 90 : 0).setDuration(200).start();
        });

        // Clique Email
        layoutEmail.setOnClickListener(v -> {
            expandedEmail = !expandedEmail;
            camposEmail.setVisibility(expandedEmail ? View.VISIBLE : View.GONE);
            setaEmail.animate().rotation(expandedEmail ? 90 : 0).setDuration(200).start();
        });

        //botão sair

        Button botaoSair = findViewById(R.id.botaoSair);
        botaoSair.setOnClickListener(v -> {
            new androidx.appcompat.app.AlertDialog.Builder(ProfilePage.this)
                    .setTitle("Sair da Conta")
                    .setMessage("Deseja mesmo sair da conta?")
                    .setNegativeButton("Não", (dialog, which) -> dialog.dismiss())
                    .setPositiveButton("Sim", (dialog, which) -> {
                        // Intent intent = new Intent(ProfilePage.this, LoginActivity.class);
                        // startActivity(intent);
                        // finish();
                    })
                    .show();
        });

    }

    private void carregarDadosUsuario() {
        new Thread(() -> {
            Motorista debugMotorista = new Motorista(0, "", "", "", "", "", "", "", "", "", "", "", "");
            List<Motorista> motoristas = debugMotorista.listarMotoristas();

            if (motoristas != null && !motoristas.isEmpty()) {
                Motorista motorista = motoristas.get(0);

                runOnUiThread(() -> {
                    editNome1.setHint(motorista.getNome());           // Preenche o nome
                    editNome2.setHint(motorista.getSobrenome());      // Preenche o sobrenome
                    editTelefone.setHint(motorista.getTelefone());    // Preenche o telefone
                    editEmail.setHint(motorista.getEmail());          // Preenche o email

                    nomeOriginal = motorista.getNome();
                    sobrenomeOriginal = motorista.getSobrenome();
                    telefoneOriginal = motorista.getTelefone();
                    emailOriginal = motorista.getEmail();

                    Toast.makeText(ProfilePage.this, "Dados carregados!", Toast.LENGTH_SHORT).show();
                });
            } else {
                runOnUiThread(() -> {
                    Toast.makeText(ProfilePage.this, "Nenhum motorista encontrado.", Toast.LENGTH_LONG).show();
                });
            }
        }).start();
    }

    private void atualizarDados() {
        String nome = editNome1.getText().toString().trim();
        String sobrenome = editNome2.getText().toString().trim();
        String telefone = editTelefone.getText().toString().trim();
        String email = editEmail.getText().toString().trim();

        new Thread(() -> {
            Motorista debugMotorista = new Motorista(0, "", "", "", "", "", "", "", "", "", "", "", "");
            List<Motorista> motoristas = debugMotorista.listarMotoristas();

            if (motoristas != null && !motoristas.isEmpty()) {
                final Motorista motorista = motoristas.get(0);

                // Atualiza somente os campos preenchidos
                if (!nome.isEmpty()) motorista.setNome(nome);
                if (!sobrenome.isEmpty()) motorista.setSobrenome(sobrenome);
                if (!telefone.isEmpty()) motorista.setTelefone(telefone);
                if (!email.isEmpty()) motorista.setEmail(email);

                String resposta = motorista.atualizar(motorista.getId());

                runOnUiThread(() -> {
                    if (resposta.contains("sucesso") || resposta.toLowerCase().contains("ok")) {
                        Toast.makeText(ProfilePage.this, "Dados atualizados com sucesso!", Toast.LENGTH_SHORT).show();
                        carregarDadosUsuario();  // Recarrega os dados após atualizar
                    } else {
                        Toast.makeText(ProfilePage.this, "Erro: " + resposta, Toast.LENGTH_LONG).show();
                    }
                });
            } else {
                runOnUiThread(() -> {
                    Toast.makeText(ProfilePage.this, "Nenhum motorista encontrado para atualizar.", Toast.LENGTH_LONG).show();
                });
            }
        }).start();
    }

}
