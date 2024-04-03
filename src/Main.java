import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Game> games = new ArrayList<>();

        Genre genre1 = new Genre("Open world");
        Genre genre2 = new Genre("Puzzle");
        Genre genre3 = new Genre("FPS");
        Genre genre4 = new Genre("Family");
        Genre genre5 = new Genre("Platformer");


        games.add(new Game("Pac-Man", 30, genre1, 10));
        games.add(new Game("Tetris", 20, genre2, 30));
        games.add(new Game("Duck Hunt", 40, genre3, 50));
        games.add(new Game("Super Mario 64", 60, genre4));
        games.add(new Game("Super Mario Bros", 80, genre5));

        printMenu();

        boolean exit = false;
        while (!exit) {
            String optie = scanner.nextLine();
            System.out.println();

            switch(optie) {
                case "1":
                    System.out.println("PRIJZENLIJST\n");
                    for (int i = 0; i < games.size(); i++){
                        games.get(i).toonGame();
                        System.out.println();
                    }

                    System.out.println();
                    System.out.println("Druk op enter om terug naar het menu te gaan.");
                    scanner.nextLine();
                    clearConsole();
                    printMenu();

                    break;
                case "2":
                    System.out.println("RANGLIJST\n");

                    ArrayList<Genre> genres = new ArrayList<>();
                    for (int i = 0; i < games.size() ; i++) {

                        Genre genre = games.get(i).getGenre().getGenre();

                        if (!genres.contains(genre)) {
                            genres.add(genre);
                            genre.toonGenre();
                        }

                    }

                    System.out.println();

                    break;
                case "3":
                    // code block
                    break;
                case "4":
                    // code block
                    break;
                case "5":
                    exit = true;
                    break;
                default:
                    System.out.println("Voer een geldig nummer in! (1-5)");
            }
        }

        scanner.close();
    }

    public static void clearConsole() {
        for (int i = 0; i < 50; ++i) {
            System.out.println();
        }
    }

    public static void printMenu() {
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
                           "░░░░░▀▄░░░▄▀░░░░░░░░▄░▀▄░░░▄▀░▄░░░░░░░░▀▄░░░▄▀░░░░░\n" +
                           "░░░░▄█▀███▀█▄░░░░░░░█▄███████▄█░░░░░░░▄█▀███▀█▄░░░░\n" +
                           "░░░█▀███████▀█░░░░░░███▄███▄███░░░░░░█▀███████▀█░░░\n" +
                           "░░░█░█▀▀▀▀▀█░█░░░░░░▀█████████▀░░░░░░█░█▀▀▀▀▀█░█░░░\n" +
                           "░░░░░░▀▀░▀▀░░░░░░░░░░▄▀░░░░░▀▄░░░░░░░░░░▀▀░▀▀░░░░░░\n" +
                           "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("░░░░░░░░░░░░░░░░░░ Good ol' Games ░░░░░░░░░░░░░░░░░");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println();
        System.out.println("{|=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|}");
        System.out.println("{|                                               |}");
        System.out.println("{|                      MENU                     |}");
        System.out.println("{|                                               |}");
        System.out.println("{|  1. PRIJZENLIJST  2. RANGLIJST  3. UITVERKOOP |}");
        System.out.println("{|                                               |}");
        System.out.println("{|           4. ENQUETES      5. EXIT            |}");
        System.out.println("{|                                               |}");
        System.out.println("{|                                               |}");
        System.out.println("{|=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|}");
        System.out.println();
        System.out.println("Kies een optie door middel van een getal te typen (1-5): ");
    }
}
