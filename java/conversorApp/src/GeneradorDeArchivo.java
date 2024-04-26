import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeneradorDeArchivo {

    private List<TasaDeCambio> tasasConsultadas;

    public GeneradorDeArchivo() {
        this.tasasConsultadas = new ArrayList<>();
    }

    public void agregarTasaConsultada(TasaDeCambio tasaDeCambio) {
        this.tasasConsultadas.add(tasaDeCambio);
    }

    public void guardarJson() throws IOException {
        // Convertir la lista de tasas de cambio a JSON y guardarla en un archivo
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritura = new FileWriter("tasas_de_cambio.json");
        escritura.write(gson.toJson(this.tasasConsultadas));
        escritura.close();
    }
   // public void guardarJson(TasaDeCambio tasaDeCambio) throws IOException {
        // Convertir la información a JSON y guardarla en un archivo
      //  Gson gson = new GsonBuilder().setPrettyPrinting().create();
       // FileWriter escritura = new FileWriter("tasa_de_cambio.json");
       // escritura.write(gson.toJson(tasaDeCambio));
       // escritura.close();
    //}

}
