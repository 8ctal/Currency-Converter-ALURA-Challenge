package main;

import models.ExchangeRateRequest;
import models.ExchangerAPI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExchangeRateRequest request = new ExchangeRateRequest();
        System.out.println("Escriba la abreviatura de la moneda desde la que desea cambiar Ej: USD,COP:");
        var fromCurrency = scanner.nextLine();
        System.out.println("Ahora a la que desea cambiar Ej: USD,COP:");
        var toCurrency = scanner.nextLine();
        try {
            System.out.println("Ingrese el valor a cambiar!:");
            double amount = Double.parseDouble(scanner.nextLine());
            ExchangerAPI exchangerAPI = request.requestRates(fromCurrency);
            System.out.println(exchangerAPI);
            System.out.println("El valor cambiado es:");
            System.out.println(exchangerAPI.exchange(toCurrency, amount));
        } catch (NumberFormatException e) {
            System.out.println("Divisa no encontrada " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Finalizando la aplicación.");
        }

    }

}