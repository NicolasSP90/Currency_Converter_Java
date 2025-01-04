package requests;

import com.google.gson.Gson;
import reference.ExchangeData;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class RequestExchangeAPI {

    // Get Request
    public ExchangeData getRequest(String url) {
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
            HttpResponse<String> response;
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ExchangeData.class);

        } catch (Exception e){
            System.out.println("Erro ao objter dados da API: " + e.getMessage());
            return null;
        }
    }

    // Câmbio de duas moedas
    public String getExchangeRate(String entrySymbol, String returnSymbol) {
        String apiKey = getApiKey();
        String url = "https://v6.exchangerate-api.com/v6/%s/pair/%s/%s".formatted(apiKey, entrySymbol, returnSymbol);
        ExchangeData resposta = getRequest(url);
        return resposta.conversion_rate();
    }

    // Câmbio e conversão de valor
    public String getExchangeAmount(String entrySymbol, String returnSymbol, double amount) {
        String apiKey = getApiKey();
        String url = "https://v6.exchangerate-api.com/v6/%s/pair/%s/%s/%f".formatted(apiKey, entrySymbol, returnSymbol, amount);
        ExchangeData resposta = getRequest(url);
        return resposta.conversion_rate();
    }

    // Lista de Câmbio da moeda de referência
    public String getExchangeReference(String entrySymbol) {
        String apiKey = getApiKey();
        String url = "https://v6.exchangerate-api.com/v6/%s/latest/%s".formatted(apiKey, entrySymbol);
        ExchangeData resposta = getRequest(url);
        return resposta.conversion_rate();
    }

    // Carregando API Key do .env
    private String getApiKey() {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(".env")) {
            properties.load(fis);
            return properties.getProperty("ExchangeRateKey");
        } catch (IOException e) {
            System.err.println("Erro ao carregar .env: " + e.getMessage());
        }
        return "";
    }


    

}
