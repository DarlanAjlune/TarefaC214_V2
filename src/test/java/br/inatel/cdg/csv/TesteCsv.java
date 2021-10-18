package br.inatel.cdg.csv;

import br.inatel.cdg.game.Game;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static br.inatel.cdg.csv.Csv.readCsv;
import static br.inatel.cdg.csv.Csv.writeCsv;

public class TesteCsv {

    @Test
    public void testaLeituraCsv100Games() {
        String path = "src/main/resources/vendas-games.csv";
        List<Game> listGame = null;
        try {
            listGame = readCsv(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(100, listGame.size());
    }

    @Test(expected = FileNotFoundException.class)
    public void testeLeituraCSVNaoExiste() throws FileNotFoundException {
        String path = "vendas-games.csv";
        List<Game> listGame = readCsv(path);
    }

    @Test
    public void testaWriterCSVCriaArquivo(){
        List<Game> listGame = null;
        try {
            listGame = readCsv("src/main/resources/vendas-games.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(100, listGame.size());
        writeCsv(listGame);
        Path path = Paths.get("src/main/resources/games-filtro.csv");
        Assert.assertTrue(path.toFile().isFile());
    }
}
