package reference;
import java.util.HashMap;

public class Exchange {
    private double conversion_rate;
    private double conversion_result;
    private HashMap<String, Double> conversion_rates;

    public Exchange(ExchangeData exchangeData) {
        this.conversion_rate = Double.parseDouble(exchangeData.conversion_rate());
        this.conversion_result = Double.parseDouble(exchangeData.conversion_result());
        this.conversion_rates = new HashMap();
        String[] pairs = exchangeData.conversion_rates().split(",");
        for (String pair : pairs) {
            String[] keyValue = pair.split(":"); // Dividindo chave e valor (":")
            if (keyValue.length == 2) { // Verificando se há uma chave e um valor
                conversion_rates.put(keyValue[0], Double.parseDouble(keyValue[1])); // Adicionando ao HashMap
            }
        }


    }
}
