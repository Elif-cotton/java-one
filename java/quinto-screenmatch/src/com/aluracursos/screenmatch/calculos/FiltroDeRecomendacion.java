package com.aluracursos.screenmatch.calculos;

public class FiltroDeRecomendacion {

    private String recomendacion;

    public void filtra(Clasificacion clasificacion) {
        if (clasificacion.getClasificacion() >= 4) {
            System.out.println("Está entre los favoritos del momento");
        } else if (clasificacion.getClasificacion() >= 2) {
            System.out.println("Bien evaluado actualmente");
        } else {
            System.out.println("Colocalo en tu lista para verlo después");
        }
    }
}
