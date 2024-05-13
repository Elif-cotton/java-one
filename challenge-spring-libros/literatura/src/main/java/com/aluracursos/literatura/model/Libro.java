package com.aluracursos.literatura.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)  //único
    private String titulo;
    @ManyToOne
    @JoinColumn(name = "autor_id") // Nombre de la columna en la tabla Libro que referencia al autor
    private List<DatosAutor> autor;
    private List<String> idiomas;
    private Double numeroDeDescargas;

    public Libro(){}

    public Libro(String titulo, List<DatosAutor> autor, List<String> idiomas, Double numeroDeDescargas) {
        this.titulo = titulo;
        this.autor = autor;
        this.idiomas = idiomas;
        this.numeroDeDescargas = numeroDeDescargas;
    }

    public Libro(DatosLibro datosLibro){
        this.titulo = datosLibro.titulo();
        this.autor = datosLibro.autor();
        this.idiomas = datosLibro.idiomas();
        this.numeroDeDescargas = datosLibro.numeroDeDescargas();
    }

    @Override
    public String toString() {
        return "titulo='" + titulo + '\'' +
                ", autor =" + autor +
                ", idiomas=" + idiomas +
                ", número de descargas='" + numeroDeDescargas + '\'';
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<DatosAutor> getAutor() {
        return autor;
    }

    public void setAutor(List<DatosAutor> autor) {
        //autor.forEach(a -> a.setLibro(this));
        this.autor = autor;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public Double getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Double numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }
}
