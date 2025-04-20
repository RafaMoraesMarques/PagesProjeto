package com.example.pagesprojeto;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfilePage extends AppCompatActivity {

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

        // Menu inferior (se quiser ativar depois)
//        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
//        bottomNav.setOnItemSelectedListener(item -> {
//            switch (item.getItemId()) {
//                case R.id.nav_home:
//                    finish(); // ou startActivity(new Intent(...));
//                    return true;
//                case R.id.nav_config:
//                    // startActivity(new Intent(this, ConfigActivity.class));
//                    return true;
//                case R.id.nav_info:
//                    // startActivity(new Intent(this, InfoPage.class));
//                    return true;
//            }
//            return false;
//        });
    }
}
