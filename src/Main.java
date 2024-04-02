import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Game> games = new ArrayList<>();
        games.add(new Game("Pac-Man", 30, "Open world", 10));
        games.add(new Game("Tetris", 20, "Puzzle", 30));
        games.add(new Game("Duck Hunt", 40, "FPS", 50));
        games.add(new Game("Super Mario 64", 60, "Family"));
        games.add(new Game("Super Mario Bros", 80, "Platformer", 5));

        printMenu();

        boolean exit = false;
        while (!exit) {
            String optie = scanner.nextLine();

            switch(optie) {
                case "1":
                    for (int i = 0; i < games.size(); i++){
                        games.get(i).toonGame();
                    }
                    break;
                case "2":
                    // code block
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
        System.out.println("{|     1. GAMES     2. GENRES    3. UITVERKOOP   |}");
        System.out.println("{|                                               |}");
        System.out.println("{|           4. ENQUETES      5. EXIT            |}");
        System.out.println("{|                                               |}");
        System.out.println("{|                                               |}");
        System.out.println("{|=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|}");
        System.out.println();
        System.out.println("Kies een optie door middel van een getal te typen (1-5): ");
    }
}
