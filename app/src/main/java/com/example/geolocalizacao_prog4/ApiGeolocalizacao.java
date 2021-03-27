package com.example.geolocalizacao_prog4;

import org.json.JSONException; // biblioteca para Tratamento de erro de Json
import org.json.JSONObject; // Biblioteca para trabalhar com objetos Json.

//OBS: Em minhas pesquisas, vi também que existe uma biblioteca chamada GSON, essa biblioteca
// É do google e também pode ser utilizada para trabalhar com JSON.

import java.io.BufferedInputStream; //bibilioteca para leitura de requisição
import java.io.BufferedReader;//bibilioteca para leitura de input
import java.io.InputStream; //bibilioteca para leitura de input
import java.io.InputStreamReader; //bibilioteca para leitura de input
import java.net.HttpURLConnection; //bibilioteca conexão com API (Endpointes)
import java.net.URL; //bibilioteca conexão com API (Endpoints)

public class ApiGeolocalizacao {

    //Aqui é onde recebe o input do aplicativo (IP do usuario)
    private static String readStream(InputStream in){
        BufferedReader r = new BufferedReader(new InputStreamReader(in));
        StringBuilder total = new StringBuilder();
        String line;

        try {
            while ((line = r.readLine()) != null) { //recebe input da linha da entrada do usuuario
                total.append(line).append('\n');
            }
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return total.toString();
    }


    // Esse método é o que vai mandar a requisição da Request para a API de geocalização.
    // No caso, utilizei a API https://ip-api.com/docs/api:json que inclusive possui a documentação dos campos a ser utilizado nos endpoints
    private static String request(String stringUrl){ //rece string url
        URL url = null; // Cria variavel do tipo URL e zera ela
        HttpURLConnection urlConnection = null; // url connection também zerada
        try {
            url = new URL(stringUrl); //url recebe o que veio de parametro no metodo
            urlConnection = (HttpURLConnection) url.openConnection(); //inicia e abre conexão com o endpoint
            InputStream in = new BufferedInputStream(urlConnection.getInputStream()); // recebe o retorno atraves do getInputStream
            return readStream(in); //retorna o resultado
        }
        catch (Exception e) {
            e.printStackTrace(); //tratativa de excepetion por parte da requisição.
        }
        finally {
            urlConnection.disconnect(); //fecha conexão.
        }
        return "";
    }

    //Esse método é o que chama o metodo de quisição com a url base da API e o dado que veio retornado
    // do Input do aplicativo através da variavel ip.
    // Os parametros são retornados em JSON.
    // No final cria uma nova instância da Classe Localização, onde será atribuído os valores através do construtor.
    public static Localizacao retornarLocalizacaoPorIp(String ip) throws JSONException {
        String responseBody = request("http://ip-api.com/json/" + ip);
        JSONObject obj = new JSONObject(responseBody);
        String codigoPais = obj.get("countryCode").toString();
        String cidade = obj.get("city").toString();
        String pais = obj.get("country").toString();
        String estado = obj.get("regionName").toString();
        String cep = obj.get("zip").toString();

        return new Localizacao(codigoPais, pais, cidade, estado, cep); // Retora instancia atraves do contrutor.
    }
}
