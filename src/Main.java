import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static ArrayList<BaseHero> list = new ArrayList<>();

    public static void main(String[] args) {
        int count = 50;
        Random rand = new Random();
        for (int i = 0; i < count; i++) {
            switch (rand.nextInt(7)) {
                case (0) -> list.add(new Peasant());
                case (1) -> list.add(new Outlaw());
                case (2) -> list.add(new Sniper());
                case (3) -> list.add(new Magician());
                case (4) -> list.add(new Spearman());
                case (5) -> list.add(new Crossbowman());
                case (6) -> list.add(new Monk());
            }
        }
        getMenu();
    }

    public static void getMenu() {
        Scanner input = new Scanner(System.in);
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
            System.out.println("X -> Exit");
            System.out.print("Input number: ");
            String choice = input.nextLine().toLowerCase();
            switch (choice) {
                case ("0") -> getSortedClass(list, "BaseHero");
                case ("1") -> getSortedClass(list, "Peasant");
                case ("2") -> getSortedClass(list, "Outlaw");
                case ("3") -> getSortedClass(list, "Sniper");
                case ("4") -> getSortedClass(list, "Magician");
                case ("5") -> getSortedClass(list, "Spearman");
                case ("6") -> getSortedClass(list, "Crossbowman");
                case ("7") -> getSortedClass(list, "Monk");
                case ("x") -> System.exit(0);
            }
        }
    }

    public static void getSortedClass(ArrayList list, String nameClass) {
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