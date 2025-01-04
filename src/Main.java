import menu.CurrencyMenu;
import requests.RequestExchangeAPI;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Instanciando variáveis e objetos
        String entryCurr;
        String returnCurr;
        Scanner input = new Scanner(System.in);
        CurrencyMenu menu = new CurrencyMenu();
        RequestExchangeAPI requestExchangeAPI = new RequestExchangeAPI();

        // Mensagem de Início
        System.out.println("Conversor de Moedas.");

        // Menu Principal
        menu.mainEntry();

        // Loop para manter o  programa
        while(menu.getMainOption() != 0) {

            // Switch case para opções do menu
            switch (menu.getMainOption()){
                case 0: // Encerrando o programa
                    System.out.println("Encerrando o programa.");
                    break;

                case 1: // Consulta da taxa
                    entryCurr = menu.currencyChoice(menu.entryCurrency());
                    returnCurr = menu.currencyChoice(menu.returnCurrency());
                    try {
                        Double rate = Double.parseDouble(requestExchangeAPI.getExchangeRate(entryCurr, returnCurr));
                        System.out.printf("O câmbio de 1 %s é de %.2f %s\n\n", entryCurr, rate, returnCurr);
                    } catch (Exception e) {
                        System.err.println("Não foi possível resgatar o câmbio. " + e.getMessage());
                    }
                    break;

                case 2: // Consulta e conversão
                    entryCurr = menu.currencyChoice(menu.entryCurrency());
                    returnCurr = menu.currencyChoice(menu.returnCurrency());
                    try {
                        System.out.println("Informe o valor a ser convertido:");
                        double amount = input.nextDouble();
                        input.nextLine();
                        Double conversionResult = Double.parseDouble(requestExchangeAPI.getExchangeAmount(entryCurr, returnCurr, amount));
                        System.out.printf("O câmbio de %.2f %s é de %.2f %s\n\n", amount, entryCurr, conversionResult , returnCurr);
                    } catch (Exception e) {
                        System.err.println("Não foi possível resgatar o câmbio. " + e.getMessage());
                    }
                    break;

                default: // Para valores inválidos de opção
                    System.err.println("Valor Inválido");

            }

            // Chamada do menu principal
            menu.mainEntry();
        }
    }
}