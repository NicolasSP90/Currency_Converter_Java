package Interface;

import java.util.Scanner;

public class CurrencyMenu {
    Scanner input = new Scanner(System.in);

    public int entryCurrency() {
        System.out.println("Escolha a moeda de entrada:");
        currencyMenu();
        int entryCurr = input.nextInt();
        input.nextLine();
        return entryCurr;
    }

    public int returnCurrency() {
        System.out.println("Escolha a moeda de saída:");
        currencyMenu();
        int returnCurr = input.nextInt();
        input.nextLine();
        return returnCurr;
    }

    private void currencyMenu() {
        System.out.println("""
                1- Dólar - USD
                2- Euro - EUR
                3- Libras - GBP
                4- Real - BRL
                5- Renminbi - CNY
                6- Peso Argentino - ARS
                """);
    }

}