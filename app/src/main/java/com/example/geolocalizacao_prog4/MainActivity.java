package com.example.geolocalizacao_prog4;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.StrictMode;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.appcompat.app.AppCompatActivity;


import org.json.JSONException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    public void carregarLocalizacao(String ip) {
        try {
            Localizacao localizacao = ApiGeolocalizacao.retornarLocalizacaoPorIp(ip);
            TextView resultado = findViewById(R.id.text_resultado);

            StringBuilder builder = new StringBuilder();
            builder.append("Resposta:\n");
            builder.append("Código país: ");
            builder.append(localizacao.getCountryCode());
            builder.append("\n");
            builder.append("País: ");
            builder.append(localizacao.getCountry());
            builder.append("\n");
            builder.append("Estado: ");
            builder.append(localizacao.getRegionName());
            builder.append("\n");
            builder.append("Cidade: ");
            builder.append(localizacao.getCity());
            builder.append("\n");
            builder.append("CEP: ");
            builder.append(localizacao.getZip());

            resultado.setText(builder.toString());
        } catch (Exception e) {

        }

    }

    public void btnLocalizarOnclick(View view){
        EditText txtIp = findViewById(R.id.edit_ip);
        String ip = txtIp.getText().toString();
        try {

            // Está ocorrendo um erro nessa parte, tentei o link https://pt.stackoverflow.com/questions/327308/android-activitycompat para resolver, mas não adiantou
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, 1);
            }else{
                //Chama a logalização
                carregarLocalizacao(ip);
            }
        } catch (Exception e) {

        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if(requestCode == 1){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Puxa o carregamento na view
                EditText txtIp = findViewById(R.id.edit_ip);
                String ip = txtIp.getText().toString();
                carregarLocalizacao(ip);
            } else {
            }
            return;
        }
    }
}