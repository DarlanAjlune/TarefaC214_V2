package br.inatel.cdg.filter;

import br.inatel.cdg.game.Game;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static br.inatel.cdg.csv.Csv.readCsv;
import static br.inatel.cdg.filter.Filter.*;

public class TesteFilter {

    private static List<Game> listGame = new ArrayList<>();

    @Before
    public void initClass(){
        String path = "src/main/resources/vendas-games.csv";
        try {
            listGame = readCsv(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void maiorVendaGlobalEh82_74(){
        Game gameMaiorVendaGlobal = filterMaiorVendaGlobal(listGame);
        Assert.assertEquals(82.74,gameMaiorVendaGlobal.global_sales, 0.01);
    }

    @Test
    public void maiorVendaGlobalSonyEhNull(){
        List<Game> listGameSony = filterPlataforma(listGame, "Sony");
        Game maiorVendaGlobal = filterMaiorVendaGlobal(listGameSony);

        Assert.assertEquals(0, listGameSony.size());
        Assert.assertNull(maiorVendaGlobal);
    }

    @Test
    public void qtdGamesX360Eh16(){
        List<Game> listGameX360 = filterPlataforma(listGame, "X360");
        Assert.assertEquals(16, listGameX360.size());
    }

    @Test
    public void qtdGamesSonyEh0(){
        List<Game> listGameSony = filterPlataforma(listGame, "Sony");
        Assert.assertEquals(0, listGameSony.size());
    }

    @Test
    public void qtdGamesAtariEh1(){
        List<Game> listGameAtari = filterEditor(listGame, "Atari");
        Assert.assertEquals(1, listGameAtari.size());
    }
}
