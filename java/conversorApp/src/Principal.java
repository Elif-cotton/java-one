import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {

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

        ConsultaTasaDeCambio consulta = new ConsultaTasaDeCambio();
        Scanner teclado= new Scanner(System.in);

        GeneradorDeArchivo generador = new GeneradorDeArchivo();

        while(opcion != 9){
            try {
                System.out.println(menu);
                opcion = Integer.parseInt(teclado.nextLine());

                if (opcion < 1 || opcion > 9) {
                    System.out.println("Error: Ingresa una opción válida (del 1 al 9).");
                    continue; // Volver a solicitar la entrada
                }

                switch (opcion){
                    case 1:
                        try {
                            System.out.println("Ingresa el valor que deseas convertir de dólar a peso Argentino: ");
                            Scanner lectura = new Scanner(System.in).useLocale(Locale.US);
                            double usdToArs = lectura.nextDouble();
                            double tasaUsdToArs = consulta.obtenerTasaDeCambio("USD", "ARS");
                            double resultadoUsdToArs = consulta.convertir(usdToArs, tasaUsdToArs);
                            System.out.println("El resultado de la conversión es: " + resultadoUsdToArs + " ARS");


                            TasaDeCambio tasa = consulta.buscarTasa("USD");
                            generador.agregarTasaConsultada(tasa);
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Ingresa un valor numérico válido.");
                        }
                        break;
                    case 2:
                        try {
                            System.out.println("Ingresa el valor que deseas convertir de peso Argentino a dólar: ");
                            Scanner lectura = new Scanner(System.in).useLocale(Locale.US);
                            double arsToUsd = lectura.nextDouble();
                            double tasaArsToUsd = consulta.obtenerTasaDeCambio("ARS", "USD");
                            double resultadoArsToUsd = consulta.convertir(arsToUsd, tasaArsToUsd);
                            System.out.println("El resultado de la conversión es: " + resultadoArsToUsd + " USD");


                            TasaDeCambio tasa = consulta.buscarTasa("ARS");
                            generador.agregarTasaConsultada(tasa);
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Ingresa un valor numérico válido.");
                        }
                        break;
                    case 3:
                        try {
                            System.out.println("Ingresa el valor que deseas convertir de dólar a Real Brasileño:");
                            Scanner lectura = new Scanner(System.in).useLocale(Locale.US);
                            double usdToBrl = lectura.nextDouble();
                            double tasaUsdToBrl = consulta.obtenerTasaDeCambio("USD", "BRL");
                            double resultadoUsdToBrl = consulta.convertir(usdToBrl, tasaUsdToBrl);
                            System.out.println("El resultado de la conversión es: " + resultadoUsdToBrl + " BRL");

                            TasaDeCambio tasa = consulta.buscarTasa("USD");
                            generador.agregarTasaConsultada(tasa);
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Ingresa un valor numérico válido.");
                        }
                        break;
                    case 4:
                        try {
                            System.out.println("Ingresa el valor que deseas convertir de Real Brasileño a dólar: ");
                            Scanner lectura = new Scanner(System.in).useLocale(Locale.US);
                            double brlToUsd = lectura.nextDouble();
                            double tasaBrlToUsd = consulta.obtenerTasaDeCambio("BRL", "USD");
                            double resultadoBrlToUsd = consulta.convertir(brlToUsd, tasaBrlToUsd);
                            System.out.println("El resultado de la conversión es: " + resultadoBrlToUsd + " USD");

                            TasaDeCambio tasa = consulta.buscarTasa("BRL");
                            generador.agregarTasaConsultada(tasa);
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Ingresa un valor numérico válido.");
                        }
                        break;
                    case 5:
                        try {
                            System.out.println("Ingresa el valor que deseas convertir de dólar a peso Colombiano: ");
                            Scanner lectura = new Scanner(System.in).useLocale(Locale.US);
                            double usdToCop = lectura.nextDouble();
                            double tasaUsdToCop = consulta.obtenerTasaDeCambio("USD", "COP");
                            double resultadoUsdToCop = consulta.convertir(usdToCop, tasaUsdToCop);
                            System.out.println("El resultado de la conversión es: " + resultadoUsdToCop + " COP");

                            TasaDeCambio tasa = consulta.buscarTasa("USD");
                            generador.agregarTasaConsultada(tasa);
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Ingresa un valor numérico válido.");
                        }
                        break;
                    case 6:
                        try {
                            System.out.println("Ingresa el valor que deseas convertir de peso colombiano a dólar: ");
                            Scanner lectura = new Scanner(System.in).useLocale(Locale.US);
                            double copToUsd = lectura.nextDouble();
                            double tasaCopToUsd = consulta.obtenerTasaDeCambio("COP", "USD");
                            double resultadoCopToUsd = consulta.convertir(copToUsd, tasaCopToUsd);
                            System.out.println("El resultado de la conversión es: " + resultadoCopToUsd + " USD");

                            TasaDeCambio tasa = consulta.buscarTasa("COP");
                            generador.agregarTasaConsultada(tasa);
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Ingresa un valor numérico válido.");
                        }
                        break;
                    case 7:
                        try {
                            System.out.println("Ingresa el valor que deseas convertir de dólar a peso Chileno: ");
                            Scanner lectura = new Scanner(System.in).useLocale(Locale.US);
                            double usdToClp = lectura.nextDouble();
                            double tasaUsdToClp = consulta.obtenerTasaDeCambio("USD", "CLP");
                            double resultadoUsdToClp = consulta.convertir(usdToClp, tasaUsdToClp);
                            System.out.println("El resultado de la conversión es: " + resultadoUsdToClp + " CLP");

                            TasaDeCambio tasa = consulta.buscarTasa("USD");
                            generador.agregarTasaConsultada(tasa);
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Ingresa un valor numérico válido.");
                        }
                        break;
                    case 8:
                        try {
                            System.out.println("Ingresa el valor que deseas convertir de peso Chileno a dólar: ");
                            Scanner lectura = new Scanner(System.in).useLocale(Locale.US);
                            double clpToUsd = lectura.nextDouble();
                            double tasaClpToUsd = consulta.obtenerTasaDeCambio("CLP", "USD");
                            double resultadoClpToUsd = consulta.convertir(clpToUsd, tasaClpToUsd);
                            System.out.println("El resultado de la conversión es: " + resultadoClpToUsd + " USD");

                            TasaDeCambio tasa = consulta.buscarTasa("CLP");
                            generador.agregarTasaConsultada(tasa);
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Ingresa un valor numérico válido.");
                        }
                        break;
                    case 9:
                        System.out.println("Saliendo del programa, gracias por utilizar nuestros servicios");
                        break;
                    default:
                        System.out.println("Opción no válida");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Ingresa un número entero válido.");
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }
        // Llamar al método para guardar todas las tasas consultadas en el archivo JSON
        generador.guardarJson();
        teclado.close(); // Cerrar el scanner al salir del bucle

    }
}