import java.util.*;

public class Main {
    public static ArrayList<BaseHero> leftSide;
    public static ArrayList<BaseHero> rightSide;
    public static Scanner input = new Scanner(System.in);
    public static final int TEAM_SIZE = 10;

    public static void main(String[] args) {
        init();
        getStep();
//        getMenu();
    }

    public static void init() {
        leftSide = new ArrayList<>();
        rightSide = new ArrayList<>();
        int x = 1;
        int y = 1;
        for (int i = 0; i < TEAM_SIZE; i++) {
            switch (new Random().nextInt(4)) {
                case (0) -> leftSide.add(new Peasant(leftSide, x, y++));
                case (1) -> leftSide.add(new Outlaw(leftSide, x, y++));
                case (2) -> leftSide.add(new Sniper(leftSide, x, y++));
                case (3) -> leftSide.add(new Magician(leftSide, x, y++));
            }
        }

        x = TEAM_SIZE;
        y = 1;
        for (int i = 0; i < TEAM_SIZE; i++) {
            switch (new Random().nextInt(4)) {
                case (0) -> rightSide.add(new Peasant(rightSide, x, y++));
                case (1) -> rightSide.add(new Spearman(rightSide, x, y++));
                case (2) -> rightSide.add(new Crossbowman(rightSide, x, y++));
                case (3) -> rightSide.add(new Monk(rightSide, x, y++));
            }
        }
    }

    public static void getStep() {
        int numRound = 1;
        while (true) {
            ConsoleView.view();
            input.nextLine();
            System.out.println(AnsiColors.ANSI_GREEN + "STEP " + numRound + AnsiColors.ANSI_RESET);
            leftSide.forEach(item -> item.step(rightSide));
            System.out.println("------------------------");
            rightSide.forEach(item -> item.step(leftSide));
            System.out.println();
            if (checkWin(rightSide)) {
                System.out.println("\uD83D\uDC9A\uD83E\uDD18\uD83D\uDC9ALEFT TEAM WIN!\uD83D\uDC9A\uD83E\uDD18\uD83D\uDC9A");
                break;
            }
            if (checkWin(leftSide)) {
                System.out.println("\uD83D\uDC99\uD83E\uDD18\uD83D\uDC99RIGHT TEAM WIN!\uD83D\uDC99\uD83D\uDC99\uD83E\uDD18");
                break;
            }
            numRound += 1;
        }
    }

    public static boolean checkWin(ArrayList<BaseHero> teamList) {
        boolean win = true;
        for (BaseHero baseHero : teamList) {
            if (baseHero.hp != 0) {
                win = false;
                break;
            }
        }
        return win;
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
                case ("0") -> getSortedClass(leftSide, "BaseHero");
                case ("1") -> getSortedClass(leftSide, "Peasant");
                case ("2") -> getSortedClass(leftSide, "Outlaw");
                case ("3") -> getSortedClass(leftSide, "Sniper");
                case ("4") -> getSortedClass(leftSide, "Magician");
                case ("5") -> getSortedClass(leftSide, "Spearman");
                case ("6") -> getSortedClass(leftSide, "Crossbowman");
                case ("7") -> getSortedClass(leftSide, "Monk");
//                case ("a") -> getAttack();
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
}