package Requests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class RequestExchangeAPI {
    private String apiKey;

    // Carregando API Key do .env
    private void getApiKey() {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(".env")) {
            properties.load(fis);
            this.apiKey = properties.getProperty("ExchangeRateKey");
        } catch (IOException e) {
            System.err.println("Erro ao carregar .env: " + e.getMessage());
        }
    }


}
