package com.example.pagesprojeto.TesteDB;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.pagesprojeto.R;

public class TesteDB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste); // Substitua com o layout correto
        ListMotoristas();
    }

    private void ListMotoristas() {
        String url = "https://6c506741-b719-4ce4-878f-c097893cc0a5-00-lwwpbtowvo9o.janeway.replit.dev/Motorista"; // <-- Coloque sua URL

        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                response -> {
                    // Sucesso
                    Log.d("API", "Motoristas: " + response.toString());
                    // Aqui você pode tratar o JSON como quiser
                },
                error -> {
                    // Erro
                    Log.e("API", "Erro: " + error.toString());
                }
        );

        queue.add(request);
    }
}
