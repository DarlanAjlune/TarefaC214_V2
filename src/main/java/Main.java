import br.inatel.cdg.game.Game;
import jdk.swing.interop.SwingInterOpUtils;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import static br.inatel.cdg.csv.Csv.readCsv;
import static br.inatel.cdg.csv.Csv.writeCsv;
import static br.inatel.cdg.filter.Filter.*;

public class Main {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        String plataforma;
        String editora;
        String path = "src/main/resources/vendas-games.csv";
        List<Game> listaTodosGames = null;
        try {
            listaTodosGames = readCsv(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Lista de todos os jogos presentes no CSV fornecido");
        listaTodosGames.forEach(umGame -> System.out.println(umGame.toString()));
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("Selecione uma das plataformas disponíveis:");
        System.out.println("2600");
        System.out.println("3DS");
        System.out.println("DS");
        System.out.println("GB");
        System.out.println("GBA");
        System.out.println("N64");
        System.out.println("NES");
        System.out.println("PC");
        System.out.println("PS");
        System.out.println("PS2");
        System.out.println("PS3");
        System.out.println("PS4");
        System.out.println("PSP");
        System.out.println("SNES");
        System.out.println("Wii");
        System.out.println("X360");
        System.out.println("XB");
        plataforma = ler.next();
        System.out.println("Lista de jogos da plataforma " + plataforma);
        filterPlataforma(listaTodosGames, plataforma).forEach(umGameWii -> System.out.println(umGameWii.toString()));
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("Selecione uma das editoras disponíveis:");
        System.out.println("Ubisoft");
        System.out.println("Take-Two Interactive");
        System.out.println("SquareSoft");
        System.out.println("Sony Computer Entertainment");
        System.out.println("Sega");
        System.out.println("Nintendo");
        System.out.println("Microsoft Game Studios");
        System.out.println("Electronic Arts");
        System.out.println("Bethesda Softworks");
        System.out.println("Atari");
        System.out.println("Activision");
        ler.nextLine();
        editora = ler.nextLine();
        System.out.println("Lista de jodos da editora " + editora);
        filterEditor(listaTodosGames, editora).forEach(umGameUbisoft -> System.out.println(umGameUbisoft.toString()));
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("Games feito pela editora " + editora + " para a plataforma " + plataforma);
        List<Game> gameFiltrado = filterEditor(filterPlataforma(listaTodosGames, plataforma), editora);
        System.out.println(gameFiltrado);
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("Maior venda global da editora " + editora + " feita para a plataforma " + plataforma);
        System.out.println(filterMaiorVendaGlobal(filterEditor(filterPlataforma(listaTodosGames, plataforma), editora)));

        writeCsv(gameFiltrado);
    }
}
