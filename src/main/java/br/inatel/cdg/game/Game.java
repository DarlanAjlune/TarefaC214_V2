package br.inatel.cdg.game;

import lombok.Data;

@Data
public class Game {
    public int rank;
    public String name;
    public String platform;
    public int year;
    public String genre;
    public String publisher;
    public float na_sales;
    public float eu_sales;
    public float jp_sales;
    public float other_sales;
    public float global_sales;

    @Override
    public String toString() {
        return "Game{" +
                "rank=" + rank +
                ", name='" + name + '\'' +
                ", platform='" + platform + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", publisher='" + publisher + '\'' +
                ", na_sales=" + na_sales +
                ", eu_sales=" + eu_sales +
                ", jp_sales=" + jp_sales +
                ", other_sales=" + other_sales +
                ", global_sales=" + global_sales +
                '}';
    }
}
