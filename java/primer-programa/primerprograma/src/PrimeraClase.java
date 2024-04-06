public class PrimeraClase {
    public static void main(String[] args) {
        System.out.println("Bienvenido(a) a Screen Match");
        System.out.println("Pelicula: Matrix");

        int fechaDeLanzamiento = 1999;
        boolean incluidoEnElPlan = true;
        double notaDeLaPelicula = 8.2;

        double media = (8.2+6.0+9.0) /3;
        System.out.println(String.format("la media de la pelicula es %.2f",media));

        String sinopsis = """
                Matrix es una paradoja 
                La mejor película del fin del milenio
                Fue lanzada en:
                """ + fechaDeLanzamiento;
        System.out.println(sinopsis);

        int clasificacion = (int) media/2;
        System.out.println(clasificacion);

    }
}