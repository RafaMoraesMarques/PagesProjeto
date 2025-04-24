package com.example.pagesprojeto.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pagesprojeto.R;

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

        // botaoHistorico.setOnClickListener(v -> {
        //     Intent intent = new Intent(InfoPage.this, HistoricoActivity.class);
        //     startActivity(intent);
        // });

        // BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        // bottomNav.setOnItemSelectedListener(item -> {
        //     switch (item.getItemId()) {
        //         case R.id.nav_home:
        //             finish();
        //             return true;
        //         case R.id.nav_config:
        //             // Intent intentPerfil = new Intent(this, PerfilActivity.class);
        //             // startActivity(intentPerfil);
        //             return true;
        //         case R.id.nav_info:
        //             // Intent intentHistorico = new Intent(this, HistoricoActivity.class);
        //             // startActivity(intentHistorico);
        //             return true;
        //     }
        //     return false;
        // });
    }
}
