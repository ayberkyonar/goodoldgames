import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Game> games = new ArrayList<>();

        games.add(new Game("Pac-Man", 30, 10));
        games.add(new Game("Tetris", 20, 30));
        games.add(new Game("Duck Hunt", 40, 50));
        games.add(new Game("Super Mario 64", 60));
        games.add(new Game("Super Mario Bros", 80, 5));



        for (int i = 0; i < games.size(); i++){
            games.get(i).toonGame();
        }

        //for (int i = 0; i < games.size(); i++){
        //    games.get(i).toonKorting();
        //}


    }
}