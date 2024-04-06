public class Temperatura {
    public static void main(String[] args) {
        System.out.println("Convertir temperatura de Celcius a Fahrenheit");

        double celcius = 30.4;
        double fahrenheit;
        fahrenheit=  (celcius * 1.8) + 32;

        String mensaje = String.format("La temperatura de %f Celsius es equivalente a %f Fahrenheit", celcius,fahrenheit);
        System.out.println(mensaje);

        int fahrenheitEntero = (int) fahrenheit;
        System.out.println("La temperatura en Fahrenheit entera es: " + fahrenheitEntero);
    }
}