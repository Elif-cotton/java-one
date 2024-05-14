package com.aluracursos.literatura.principal;

import com.aluracursos.literatura.model.Autor;
import com.aluracursos.literatura.model.Datos;
import com.aluracursos.literatura.model.DatosLibro;
import com.aluracursos.literatura.model.Libro;
import com.aluracursos.literatura.repository.LibroRepository;
import com.aluracursos.literatura.service.ConsumoAPI;
import com.aluracursos.literatura.service.ConvierteDatos;

import java.util.*;

public class Principal {

    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/";
    private final String API_KEY = "TU-APIKEY-OMDB";
    private ConvierteDatos conversor = new ConvierteDatos();
    private LibroRepository repositorio;

    private List<Libro> libros;
    private Optional<Libro> libroBuscado;

    public Principal(LibroRepository repository) {
        this.repositorio = repository;
    }

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Buscar libros por título
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en un determinado año
                    5 - Listar libros por idioma 
                    6 - Buscar autores por nombre
                                  
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibroweb();
                    break;
                case 2:
                    listarLibrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresVivosPorAno();
                    break;
                case 5:
                    listarLibrosPorIdioma();
                    break;
                case 6:
                    buscarAutorPorLibro();
                    break;

                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

    }

    private DatosLibro getDatosLibro() {
        // Busqueda de libros por nombre
        System.out.println("Ingrese el nombre del libro que desea buscar");
        var tituloLibro = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + "?search=" + tituloLibro.replace(" ", "+"));
        var datosBusqueda = conversor.obtenerDatos(json, Datos.class);
        Optional<DatosLibro> libroBuscado = datosBusqueda.resultados().stream()
                .filter(l -> l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
                .findFirst();
        if (libroBuscado.isPresent()) {
            return libroBuscado.get();
        } else {
            throw new NoSuchElementException("El libro '" + tituloLibro + "' no fue encontrado.");
        }
    }
    private void buscarLibroweb() {
        try {
            DatosLibro datos = getDatosLibro();
            System.out.println("Libro Encontrado ");
            System.out.println(datos);
            Libro libro = new Libro(datos);
            repositorio.save(libro);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    private void buscarLibroPorTitulo() {
        System.out.println("Escribe el nombre del libro que deseas buscar");
        var nombreLibro = teclado.nextLine();
        //libroBuscado = repositorio.findByTituloContainsIgnoreCase(nombrelibro);

        if(libroBuscado.isPresent()){
            System.out.println("El libro buscado es: " + libroBuscado.get());
        } else {
            System.out.println("Libro no encontrado");
        }

    }

    private void listarLibrosRegistrados() {
        libros = repositorio.findAll();

        libros.stream()
                .sorted(Comparator.comparing(Libro::getTitulo)) // Puedes ordenar los libros por título u otro criterio si prefieres.
                .forEach(System.out::println); // Esto imprimirá cada libro en la consola, puedes personalizar cómo se imprime.

    }

    private void listarAutoresRegistrados() {
    }

    private void listarAutoresVivosPorAno() {
    }

    private void listarLibrosPorIdioma() {
    }

    private void buscarAutorPorLibro() {
        System.out.println("Escribe el título del libro del cual quieres ver el autor:");
        String tituloLibro = teclado.nextLine();

        Optional<Libro> libro = repositorio.findAll().stream()
                .filter(l -> l.getTitulo().toLowerCase().contains(tituloLibro.toLowerCase()))
                .findFirst();

        if (libro.isPresent()) {
            Libro libroEncontrado = libro.get();
            Autor autorDelLibro = (Autor) libroEncontrado.getAutor();

            System.out.println("El autor del libro \"" + libroEncontrado.getTitulo() + "\" es: " + autorDelLibro.getNombre());
        } else {
            System.out.println("No se encontró ningún libro con ese título.");
        }
    }

}
