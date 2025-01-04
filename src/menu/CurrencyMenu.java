package menu;
import java.util.Scanner;

public class CurrencyMenu {
    int mainOption;

    public int getMainOption() { return this.mainOption; }

    public void mainEntry() {
        System.out.println("Escolha a moeda de entrada:");
        mainMenu();
        this.mainOption = currencyValidation("principal",  1);
    }

    public int entryCurrency() {
        System.out.println("Escolha a moeda de entrada:");
        currencyMenu();
        return currencyValidation("moeda", 6);
    }

    public int returnCurrency() {
        System.out.println("Escolha a moeda de saída:");
        currencyMenu();
        return currencyValidation("moeda", 6);
    }

    public String currencyChoice(int choice){
        return switch (choice) {
            case 1 -> "USD";
            case 2 -> "EUR";
            case 3 -> "GBP";
            case 4 -> "BRL";
            case 5 -> "CNY";
            case 6 -> "ARS";
            default -> "";
        };
    }

    private void mainMenu(){
        System.out.println("""
                1- Consulta Câmbio
                2- Conversão Valores
                
                0- Sair
                """);
    }

    private void currencyMenu() {
        System.out.println("""
                1- Dólar - USD
                2- Euro - EUR
                3- Libras - GBP
                4- Real - BRL
                5- Renminbi - CNY
                6- Peso Argentino - ARS
                
                0- Cancelar
                """);
    }

    private int currencyValidation(String tipoEntrada,  int max) {
        while(true) {
            Scanner input = new Scanner(System.in);
            try{
                int currencyChoice = input.nextInt();
                input.nextLine();
                if ((currencyChoice >= 0) && (currencyChoice <= max)) {
                    return currencyChoice;
                } else {
                    throw new IllegalArgumentException("Valor inválido!");
                }

            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
                System.out.println("Informe um valor válido!");

            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
                System.out.println("Informe um valor válido!");
                input.nextLine();
            }
            if (tipoEntrada.equals("principal")){
                mainMenu();
            } else if (tipoEntrada.equals("moeda")){
                currencyMenu();
            }

        }
    }

}