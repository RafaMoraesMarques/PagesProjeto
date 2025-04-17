package com.example.pagesprojeto;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConfigActivity extends AppCompatActivity {

    Switch switchSeguranca;
    TextView tituloConfig;
    LinearLayout chave1Layout, chave2Layout, chave3Layout;
    TextView chave1Titulo, chave2Titulo, chave3Titulo;
    EditText editChave1, editChave2, editChave3;
    ImageView botaoVoltar;

    boolean expanded1 = false;
    boolean expanded2 = false;
    boolean expanded3 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Botão voltar personalizado
        botaoVoltar = findViewById(R.id.botaoVoltar);
        botaoVoltar.setOnClickListener(v -> finish());

        // Inicialização dos componentes
        switchSeguranca = findViewById(R.id.switchSeguranca);
        tituloConfig = findViewById(R.id.tituloConfig);

        chave1Layout = findViewById(R.id.chave1Layout);
        chave2Layout = findViewById(R.id.chave2Layout);
        chave3Layout = findViewById(R.id.chave3Layout);

        chave1Titulo = findViewById(R.id.chave1Titulo);
        chave2Titulo = findViewById(R.id.chave2Titulo);
        chave3Titulo = findViewById(R.id.chave3Titulo);

        editChave1 = findViewById(R.id.editChave1);
        editChave2 = findViewById(R.id.editChave2);
        editChave3 = findViewById(R.id.editChave3);

        // Listener para o Switch
        switchSeguranca.setOnCheckedChangeListener((buttonView, isChecked) -> {
            int visibility = isChecked ? View.VISIBLE : View.GONE;
            tituloConfig.setVisibility(visibility);
            chave1Layout.setVisibility(visibility);
            chave2Layout.setVisibility(visibility);
            chave3Layout.setVisibility(visibility);
        });

        // Listeners para expandir/retrair as chaves
        chave1Titulo.setOnClickListener(v -> {
            expanded1 = !expanded1;
            editChave1.setVisibility(expanded1 ? View.VISIBLE : View.GONE);
        });

        chave2Titulo.setOnClickListener(v -> {
            expanded2 = !expanded2;
            editChave2.setVisibility(expanded2 ? View.VISIBLE : View.GONE);
        });

        chave3Titulo.setOnClickListener(v -> {
            expanded3 = !expanded3;
            editChave3.setVisibility(expanded3 ? View.VISIBLE : View.GONE);
        });

        //O menu inferior funcionando

        //BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        //bottomNav.setOnItemSelectedListener(item -> {
            //switch (item.getItemId()) {
                //case R.id.nav_home:
                    //startActivity(new Intent(this, HomeActivity.class));
                    //return true;
                //case R.id.nav_info:
                    //startActivity(new Intent(this, InfoActivity.class));
                    //return true;
                //case R.id.nav_config:
                    //startActivity(new Intent(this, ConfigActivity.class));
                    //return true;
            //}
            //return false;
        //});


    }
}
