package com.aluracursos.screenmatch;

import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.model.DatosTemporada;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Primer proyecto Spring sin Web");
		var consumoApi = new ConsumoAPI();
		//var json = consumoApi.obtenerDatos("https://coffee.alexflipnote.dev/random.json");
		//var json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&Season=1&apikey=727776e2");
		var json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&apikey=727776e2");

		System.out.println(json);

		ConvierteDatos conversor = new ConvierteDatos();
		DatosSerie datos = conversor.obtenerDatos(json, DatosSerie.class);
		System.out.println(datos);

		json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&Season=1&episode=1&apikey=727776e2");
		DatosEpisodio episodio = conversor.obtenerDatos(json, DatosEpisodio.class);
		System.out.println(episodio);

		List <DatosTemporada> temporadas= new ArrayList<>();
		for (int i = 1; i <= datos.totalDeTemporadas() ; i++) {
			json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&Season="+i+"&apikey=727776e2");
			var datosTemporadas = conversor.obtenerDatos(json, DatosTemporada.class);
			temporadas.add(datosTemporadas);
		}
		temporadas.forEach(System.out::println);
	}
}
