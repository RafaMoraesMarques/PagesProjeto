package br.com.fecapccp.myapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

import br.com.fecapccp.myapplication.R;
import br.com.fecapccp.myapplication.Utils.BottomNavHelper;


public class InfoPage extends AppCompatActivity {

    ImageView botaoVoltar;
    ImageView imageRight;
    LinearLayout botaoSeguranca, botaoPerfil, botaoHistorico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page);

        botaoVoltar = findViewById(R.id.botaoVoltar);
        imageRight = findViewById(R.id.imageRight);
        botaoSeguranca = findViewById(R.id.botaoSeguranca);
        botaoPerfil = findViewById(R.id.botaoPerfil);
        botaoHistorico = findViewById(R.id.botaoHistorico);

        botaoVoltar.setOnClickListener(v -> finish());

        botaoSeguranca.setOnClickListener(v -> {
            Intent intent = new Intent(InfoPage.this, ConfigActivity.class);
            startActivity(intent);
        });

        botaoPerfil.setOnClickListener(v -> {
            Intent intent = new Intent(InfoPage.this, ProfilePage.class);
            startActivity(intent);
        });

        imageRight.setOnClickListener(v -> {
            Intent intent = new Intent(InfoPage.this, ProfilePage.class);
            startActivity(intent);
        });

        // Menu inferior
        BottomNavHelper.setupBottomNavigation(this, R.id.nav_config);
    }
}