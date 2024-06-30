import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Bienvenido a tu conversor de moneda");
        var opcion = -1;
        while (opcion !=0) {
            var menu = """
                    1 - Convertir de Dolares Americanos a Coronas Suecas 
                    2 - Convertir de Pesos Colombianos a Coronas Suecas 
                    3 - Convertir de Coronas Suecas a Dolares Americanos
                    4 - Convertir de Coronas Suecas a Pesos Colombianos
                    5 - Converir de Euros a Coronas Suecas 
                    6 - Convertir de Coronas Suecas a Euros 
                                  
                    0 - Salir
                    """;

            System.out.println(menu);
            opcion = teclado.nextInt();
            switch (opcion){
                case 1:
                    convierteDolarACorona();
                    break;
                case 2:
                    conviertePesoColACorona();
                    break;
                case 3:
                    convierteCoronaADolar();
                    break;
                case 4:
                    convierteCoronaAPesoCol();
                    break;
                case 5:
                    convierteEuroACorona();
                    break;
                case 6:
                    convierteCoronaAEuro();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }


                }
            }

    private static void convierteDolarACorona() {
        converidorGeneral("USD","SEK");

    }
    private static void conviertePesoColACorona() {
        converidorGeneral("COP","SEK");
    }
    private static void convierteCoronaADolar() {
        converidorGeneral("SEK","USD");
    }
    private static void convierteCoronaAPesoCol() {
        converidorGeneral("SEK","COP");
    }
    private static void convierteEuroACorona() {
        converidorGeneral("EUR","SEK");
    }
    private static void convierteCoronaAEuro() {
        converidorGeneral("SEK","EUR");
    }


    private static void converidorGeneral(String monedaBase, String monedaDestino){
        Scanner teclado = new Scanner(System.in);
        System.out.printf("Escribe la cantidad de %s que quieres convertir a %s: \n", monedaBase, monedaDestino);
        var valorBase = teclado.nextDouble();
        ConsultaTasas consultaTasas = new ConsultaTasas();
        Map<String, Double> tasas = consultaTasas.buscaTasasPorMonedaBase(monedaBase);
        double tasaConversion = tasas.get(monedaDestino);
        System.out.printf("La tasa de conversión entre %s y %s es %.4f \n", monedaBase, monedaDestino, tasaConversion);
        var resultado = valorBase * tasaConversion;
        System.out.printf("%.2f %s corresponden a %.2f %s \n", valorBase, monedaBase, resultado, monedaDestino);
    }
}
