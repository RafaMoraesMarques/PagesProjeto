
package com.example.pagesprojeto.api;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class ServidorConfig {

    private static final List<String> SERVIDORES = Arrays.asList(
            "http://10.0.2.2:3000",
            "https://y7yncg-3000.csb.app",
            "https://9dc78641-1bd1-45c8-90c2-5ef78eb75b05-00-1liaz9tknfzel.spock.replit.dev"
    );

    private static String servidorAtivo = null;

    public static void detectarServidor(Activity activity) {
        new Thread(() -> {
            for (String servidor : SERVIDORES) {
                if (testarConexao(servidor)) {
                    servidorAtivo = servidor;
                    String msg = "✅ Conectado ao servidor: " + servidor;
                    Log.d("ServidorConfig", msg);
                    mostrarToast(activity, msg);
                    return;
                }
            }
            mostrarToast(activity, "❌ Nenhum servidor está disponível.");
        }).start();
    }

    public static void testarRota(Activity activity, String rota) {
        new Thread(() -> {
            try {
                String urlStr = getUrl(rota);
                if (urlStr == null) {
                    mostrarToast(activity, "❌ Servidor não detectado.");
                    return;
                }

                URL url = new URL(urlStr);
                HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                conexao.setRequestMethod("GET");
                conexao.setConnectTimeout(2000);

                BufferedReader reader = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
                StringBuilder resposta = new StringBuilder();
                String linha;
                while ((linha = reader.readLine()) != null) {
                    resposta.append(linha);
                }
                reader.close();

                String msg = "✅ Rota [" + rota + "] OK: " + resposta;
                Log.d("ServidorConfig", msg);
                mostrarToast(activity, msg);

            } catch (Exception e) {
                String erro = "❌ Erro ao testar [" + rota + "]: " + e.getMessage();
                Log.e("ServidorConfig", erro);
                mostrarToast(activity, erro);
            }
        }).start();
    }

    private static void mostrarToast(Activity activity, String mensagem) {
        activity.runOnUiThread(() -> Toast.makeText(activity, mensagem, Toast.LENGTH_LONG).show());
    }

    public static String getUrl(String rota) {
        if (servidorAtivo != null) {
            return servidorAtivo + "/" + rota;
        } else {
            return null;
        }
    }

    private static boolean testarConexao(String urlBase) {
        try {
            URL url = new URL(urlBase);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setConnectTimeout(1000);
            conexao.setRequestMethod("GET");

            int codigo = conexao.getResponseCode();
            return (codigo >= 200 && codigo < 400);
        } catch (Exception e) {
            return false;
        }
    }
}