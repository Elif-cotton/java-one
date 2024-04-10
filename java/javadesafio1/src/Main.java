import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String nombre = "Tony Stark";
        String tipoCuenta = "Corriente";
        double saldo = 1599.99;
        int opcion = 0;

        System.out.println("**************************************");
        System.out.println("\nNombre del cliente: " + nombre);
        System.out.println("El tipo de cuenta es: " + tipoCuenta);
        System.out.println("Su saldo disponible es: " + saldo + "$");
        System.out.println("\n**************************************");

        String menu = """
                ***Escriba el número de la opción deseada***
                1.- Consultar Saldo
                2.- Retirar
                3.- Depositar
                9.- Salir
                """;

        Scanner teclado= new Scanner(System.in);
        while(opcion != 9){
            System.out.println(menu);
            opcion = teclado.nextInt();

            switch (opcion){
                case 1:
                    break;
            }
        }

    }
}