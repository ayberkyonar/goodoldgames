import java.util.*;

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
        games.add(new Game("Pac-Man2", 40, genre1, 5));
        games.add(new Game("Pac-Man3", 50, genre1, 25));

        games.add(new Game("Tetris", 20, genre2, 30));
        games.add(new Game("Tetris2", 20, genre2, 30));

        games.add(new Game("Duck Hunt", 40, genre3, 50));
        games.add(new Game("Duck Hunt2", 40, genre3, 50));

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

                    System.out.println("Druk op enter om terug naar het menu te gaan.");
                    scanner.nextLine();
                    clearConsole();
                    printMenu();

                    break;
                case "2":
                    System.out.println("RANGLIJST\n");

                    // Get all genres into array
                    ArrayList<Genre> genres = new ArrayList<>();
                    int genreCounter = 1;
                    for (Game game : games) {
                        Genre genre = game.getGenre();
                        if (!genres.contains(genre)) {
                            genres.add(genre);
                            System.out.print(genreCounter + " ");
                            genre.toonGenre();
                            genreCounter++;
                        }
                    }

                    ArrayList<Game> genreGames = new ArrayList<>();
                    int gameCounter = 1;
                    boolean genreInput = false;
                    while (!genreInput){

                        System.out.println();
                        System.out.println("Kies een genre:");
                        try {
                            int keuze = scanner.nextInt() - 1;
                            scanner.nextLine();
                            System.out.println();
                            if (genres.get(keuze) != null) {

                                for (Game game : games) {
                                    if (game.getGenre().equals(genres.get(keuze))) {
                                        System.out.print(gameCounter + " ");
                                        game.toonGame();
                                        genreGames.add(game);
                                        System.out.printf("%.1f\n", game.getScore());
                                        System.out.println();
                                        genreInput = true;

                                        gameCounter++;
                                    }
                                }
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Ongeldige invoer. Voer een geldig getal in.");
                            scanner.nextLine();
                        } catch (Exception e) {
                            System.out.println("Dit is niet een juiste optie.");
                        }
                    }

                    boolean retroGameInput = false;
                    while (!retroGameInput) {
                        try {
                            System.out.println("Kies een retro game:");
                            int retroGame = scanner.nextInt() - 1;
                            scanner.nextLine();

                            for (Game game : games) {
                                if (game.equals(genreGames.get(retroGame))) {
                                    game.toonGame();
                                    System.out.println(game.getScore());
                                    printGameOpties();

                                    boolean exitGame = false;
                                    while (!exitGame) {
                                        String optieGame = scanner.nextLine();
                                        System.out.println();

                                        switch (optieGame) {
                                            case "1":
                                                if (genreGames.get(retroGame).getReview().isEmpty()) {
                                                    System.out.println("Er zijn geen reviews voor deze game.");
                                                    printGameOpties();
                                                } else {
                                                    for (Review review : genreGames.get(retroGame).getReview()) {
                                                        review.toonReview();
                                                    }
                                                    printGameOpties();
                                                }
                                                break;
                                            case "2":
                                                boolean scoreCriteria = false;

                                                while (!scoreCriteria){
                                                    try{
                                                        System.out.print("Score gameplay: ");
                                                        int gameplay = scanner.nextInt();
                                                        if (gameplay > 10){
                                                            gameplay = 10;
                                                        } else if (gameplay < 1) {
                                                            gameplay = 1;
                                                        }

                                                        System.out.print("Score graphics: ");
                                                        int graphics = scanner.nextInt();
                                                        if (graphics > 10){
                                                            graphics = 10;
                                                        } else if (graphics < 1) {
                                                            graphics = 1;
                                                        }

                                                        System.out.print("Score storyline: ");
                                                        int storyline = scanner.nextInt();
                                                        if (storyline > 10){
                                                            storyline = 10;
                                                        } else if (storyline < 1) {
                                                            storyline = 1;
                                                        }

                                                        scanner.nextLine();
                                                        System.out.print("Toelichting: ");
                                                        String toelichting = scanner.nextLine();

                                                        Review newReview = new Review(genreGames.get(retroGame), toelichting, gameplay, graphics, storyline);
                                                        genreGames.get(retroGame).addReview(newReview);

                                                        System.out.println("Review succesvol toegevoegd.");
                                                        printGameOpties();
                                                        retroGameInput = true;
                                                        scoreCriteria = true;
                                                    } catch (InputMismatchException e) {
                                                        System.out.println("Ongeldige invoer. Voer een geldig getal in.");
                                                        scanner.nextLine();
                                                    } catch (Exception e) {
                                                        System.out.println("Dit is niet een juiste optie.");
                                                    }

                                                }

                                                break;
                                            case "3":
                                                boolean prijsInvoer = false;
                                                while (!prijsInvoer) {
                                                    try {
                                                        System.out.printf("Huidige prijs: €%.2f\n", game.getPrijs());

                                                        System.out.print("Voer de nieuwe prijs in €: ");
                                                        double nieuwePrijs = scanner.nextDouble();
                                                        game.setPrijs(nieuwePrijs);

                                                        System.out.printf("Nieuwe prijs: €%.2f\n", game.getPrijs());

                                                        prijsInvoer = true;
                                                        printGameOpties();

                                                    } catch(InputMismatchException e){
                                                        System.out.println("Ongeldige invoer. Voer een geldig getal in.");
                                                        scanner.nextLine();
                                                    }
                                                }
                                                break;
                                            case "4":
                                                exitGame = true;
                                                retroGameInput = true;
                                                break;
                                            default:
                                                System.out.println("Voer een geldige getal in (1-4):");
                                                break;
                                        }
                                    }
                                }
                            }
                        }
                        catch(InputMismatchException e){
                            System.out.println("Ongeldige invoer. Voer een geldig getal in.");
                            scanner.nextLine();
                        } catch(Exception e){
                            System.out.println("Dit is niet een juiste optie.");
                        }
                    }
                    System.out.println("Druk op enter om terug naar het menu te gaan.");
                    scanner.nextLine();
                    clearConsole();
                    printMenu();

                    break;
                case "3":
                    System.out.println("UITVERKOOP\n");
                    for (int i = 0; i < games.size(); i++){
                        games.get(i).toonKorting();
                    }

                    System.out.println("Druk op enter om terug naar het menu te gaan.");
                    scanner.nextLine();
                    clearConsole();
                    printMenu();

                    break;

                case "4":
                    // code block
                    break;
                case "5":
                    exit = true;
                    break;
                default:
                    System.out.println("Voer een geldig nummer in! (1-5):");
            }
        }

        scanner.close();
    }

    public static void clearConsole() {
        for (int i = 0; i < 100; ++i) {
            System.out.println();
        }
    }

    public static void printGameOpties(){
        System.out.println();
        System.out.println("1 Bekijk de reviews van deze retro game.");
        System.out.println("2 Geef een review achter.");
        System.out.println("3 Verander de prijs.");
        System.out.println("4 Ga terug naar het menu.");
        System.out.println("Kies uit de bovenstaande opties (1-4):");
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
