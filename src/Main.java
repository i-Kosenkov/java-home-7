import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static ArrayList<BaseHero> team1 = new ArrayList<>();
    public static ArrayList<BaseHero> team2 = new ArrayList<>();
    public static Scanner input = new Scanner(System.in);
    public static int count = 10;

    public static void main(String[] args) {
        Random rand = new Random();
        for (int i = 0; i < count; i++) {
            switch (rand.nextInt(4)) {
                case (0) -> team1.add(new Peasant());
                case (1) -> team1.add(new Outlaw());
                case (2) -> team1.add(new Sniper());
                case (3) -> team1.add(new Magician());
            }
        }

        System.out.println("-----------------");
        for (int i = 0; i < count; i++) {
            switch (rand.nextInt(5)) {
                case (0) -> team2.add(new Peasant());
                case (1) -> team2.add(new Outlaw());
                case (2) -> team2.add(new Spearman());
                case (3) -> team2.add(new Crossbowman());
                case (4) -> team2.add(new Monk());
            }
        }
        getListPlayers(team1);
        getListPlayers(team2);
        getStep();
//        getMenu();
    }

    public static void getMenu() {
        while (true) {
            System.out.println("Choose sorting class:");
            System.out.println("0 -> All");
            System.out.println("1 -> Peasant");
            System.out.println("2 -> Outlaw");
            System.out.println("3 -> Sniper");
            System.out.println("4 -> Magician");
            System.out.println("5 -> Spearman");
            System.out.println("6 -> Crossbowman");
            System.out.println("7 -> Monk");
            System.out.println("A -> Attack");
            System.out.println("H -> Healing");
            System.out.println("X -> Exit");
            System.out.print("Input number: ");
            String choice = input.nextLine().toLowerCase();
            switch (choice) {
                case ("0") -> getSortedClass(team1, "BaseHero");
                case ("1") -> getSortedClass(team1, "Peasant");
                case ("2") -> getSortedClass(team1, "Outlaw");
                case ("3") -> getSortedClass(team1, "Sniper");
                case ("4") -> getSortedClass(team1, "Magician");
                case ("5") -> getSortedClass(team1, "Spearman");
                case ("6") -> getSortedClass(team1, "Crossbowman");
                case ("7") -> getSortedClass(team1, "Monk");
                case ("a") -> getAttack();
//                case ("h") -> getHealing(team1);
                case ("x") -> System.exit(0);
            }
        }
    }

    public static void getSortedClass(ArrayList<BaseHero> list, String nameClass) {
        if (Objects.equals(nameClass, "BaseHero")) {
            for (Object o : list) {
                System.out.println(o);
            }
            getMenu();
        }
        for (Object o : list) {
            if (o.getClass().getName().equals(nameClass)) {
                System.out.println(o);
            }
        }
    }

    public static void getAttack() {
        Random r = new Random();
        Scanner input = new Scanner(System.in);
        int player1 = r.nextInt(0, team1.size());
        int player2 = r.nextInt(0, team2.size());

        while (team1.get(player1).getClass().getName().equals("Monk") || team1.get(player1).getClass().getName().equals("Magician")) {
            player1 = r.nextInt(0, 50);
        }

        System.out.println(team1.get(player1));
        System.out.println("↓ Attack ↓");
        System.out.println(team2.get(player2));
        team1.get(player1).Attack(team2.get(player2));
        System.out.println(team2.get(player2));
        input.nextLine();
    }

    public static void getListPlayers(ArrayList<BaseHero> teamList) {
        for (Object o : teamList) {
            System.out.println(o);
        }
        System.out.println();
    }

    public static void getStep() {
        int numRound = 0;
        while (true) {
            System.out.println("Press ENTER for next step or P to view all the players or X for exit.");
            String choice = input.nextLine().toLowerCase();
            switch (choice) {
                case ("") -> numRound += 1;
                case ("p") -> {
                    getListPlayers(team1);
                    getListPlayers(team2);
                    System.out.println("Press ENTER for next step");
                    input.nextLine();
                    numRound += 1;
                }
                case ("x") -> System.exit(0);
            }

            System.out.println("STEP " + numRound);
            for (int i = 0; i < count; i++) {
                team1.get(i).step(team1);
            }
            System.out.println("-----------------");
            for (int i = 0; i < count; i++) {
                team2.get(i).step(team2);
            }
        }
    }
}