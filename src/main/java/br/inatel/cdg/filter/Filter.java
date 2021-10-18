package br.inatel.cdg.filter;

import br.inatel.cdg.game.Game;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    public static List<Game> filterPlataforma(List<Game> listGame, String plataforma){
        List<Game> listaPlataforma = listGame.stream().filter(oneGame -> oneGame.platform.equals(plataforma)).collect(Collectors.toList());
        return listaPlataforma;
    }

    public static List<Game> filterEditor(List<Game> listGame, String publisher){
        List<Game> listaPlataforma = listGame.stream().filter(oneGame -> oneGame.publisher.equals(publisher)).collect(Collectors.toList());
        return listaPlataforma;
    }

    public static Game filterMaiorVendaGlobal(List<Game> listGame){
        Game gameMaiorVendaGlobal = listGame.stream().max(Comparator.comparing(Game::getGlobal_sales)).orElse(null);
        return gameMaiorVendaGlobal;
    }

}
