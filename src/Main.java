import menu.CurrencyMenu;
import requests.RequestExchangeAPI;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String entryCurr;
        String returnCurr;
        Scanner input = new Scanner(System.in);

        System.out.println("Conversor de Moedas.");

        CurrencyMenu menu = new CurrencyMenu();

        menu.mainEntry();
        
        while(menu.getMainOption() != 0) {

            RequestExchangeAPI requestExchangeAPI = new RequestExchangeAPI();

            switch (menu.getMainOption()){
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;

                case 1:
                    entryCurr = menu.currencyChoice(menu.entryCurrency());
                    returnCurr = menu.currencyChoice(menu.returnCurrency());
                    try {
                        Double rate = Double.parseDouble(requestExchangeAPI.getExchangeRate(entryCurr, returnCurr));
                        System.out.printf("O câmbio de 1 %s é de %.2f %s\n\n", entryCurr, rate, returnCurr);
                    } catch (Exception e) {
                        System.out.println("Não foi possível resgatar o câmbio. " + e.getMessage());
                    }
                    break;

                case 2:
                    entryCurr = menu.currencyChoice(menu.entryCurrency());
                    returnCurr = menu.currencyChoice(menu.returnCurrency());
                    double amount = input.nextDouble();
                    break;

                default:
                    System.out.println("Valor Inválido");

            }
            
            menu.mainEntry();
        }

    }
}