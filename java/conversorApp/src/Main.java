import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int opcion = 0;

        System.out.println("****************************************");
        System.out.println("\nSea Bienvenido al Conversor de monedas =) ");
        System.out.println("\n****************************************");
        System.out.println();

        String menu = """
                ***Escriba el número de la opción deseada***
                1.- Dólar =>> Peso Argentino
                2.- Peso Agentino =>> Dólar
                3.- Dólar =>> Real Brasileño
                4.- Real Brasileño =>> Dólar
                5.- Dólar =>> Peso Colombiano
                6.- Peso Colombiano =>> Dólar
                7.- Dólar =>> Peso Chileno
                8.- Peso Chileno =>> Dólar
                9.- Salir
                Elija una opción válida: 
                **************************************
                """;

        Scanner teclado= new Scanner(System.in);
        while(opcion != 9){
            System.out.println(menu);
            opcion = teclado.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Ingresa el valor que deseas convertir a peso Argentino: ");
                    double dolarA = teclado.nextDouble();

                    break;
                case 2:
                    System.out.println("Ingresa el valor que deseas convertir a dólar: ");
                    double  pesoArgentino= teclado.nextDouble();

                    break;
                case 3:
                    System.out.println("Ingresa el valor que deseas convertir a Real Brasileño:");
                    double dolarB = teclado.nextDouble();

                    break;
                case 4:
                    System.out.println("Ingresa el valor que deseas convertir a dólar: ");
                    double realBrasileno = teclado.nextDouble();

                    break;
                case 5:
                    System.out.println("Ingresa el valor que deseas convertir a peso Colombiano: ");
                    double  dolarC= teclado.nextDouble();

                    break;
                case 6:
                    System.out.println("Ingresa el valor que deseas convertir a dólar: ");
                    double  pesoColombiano= teclado.nextDouble();

                    break;
                case 7:
                    System.out.println("Ingresa el valor que deseas convertir a peso Chileno: ");
                    double  dolarD= teclado.nextDouble();

                    break;
                case 8:
                    System.out.println("Ingresa el valor que deseas convertir a dólar: ");
                    double  pesoChileno= teclado.nextDouble();

                    break;
                case 9:
                    System.out.println("Saliendo del programa, gracias por utilizar nuestros servicios");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}