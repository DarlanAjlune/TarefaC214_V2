package br.inatel.cdg.csv;

import br.inatel.cdg.game.Game;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Csv {

    public static List<Game> readCsv(String path) throws FileNotFoundException {
        List<Game> listaTodosGames = new CsvToBeanBuilder(new FileReader(path))
                .withType(Game.class)
                .build()
                .parse();

        return listaTodosGames;
    }

    public static void writeCsv(List<Game> listaFiltrada){
        File file = new File("src/main/resources/games-filtro.csv");
        try{
            FileWriter fileOutput = new FileWriter(file);
            CSVWriter writer = new CSVWriter(fileOutput);
            String data;
            data = "rank,name,platform,year,genre,publisher,na_sales,eu_sales,jp_sales,other_sales,global_sales";
            writer.writeNext(data.split(","));
            for (Game x:listaFiltrada) {
                String aux1 = x.toString().substring(x.toString().indexOf('{')+1, x.toString().indexOf('}'));
                String aux2[] = aux1.split("[" + Pattern.quote("=,") + "]");
                aux1 = "";
                for (int i = 1; i < aux2.length; i += 2) {
                    aux1 += aux2[i] + ',';
                }
                writer.writeNext(aux1.substring(0, aux1.lastIndexOf(',')).split(","));
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
