package reference;

public record ExchangeData(String conversion_rate, String conversion_result, String conversion_rates) {

    @Override
    public String toString() {
        return  """
                Taxa Câmbio: %s
                Resultado: %s
                Conversões: %s
                """.formatted(this.conversion_rate, this.conversion_result, this.conversion_rates);
    }
}