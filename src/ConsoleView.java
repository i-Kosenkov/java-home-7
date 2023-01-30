import java.util.Collections;

public class ConsoleView {

    private static int step = 1;
    //----------------отрисовка строчек псевдографики таблицы ---------начало ----------------
    private static final String top10 = formateDiv("a ") + String.join("",
            Collections.nCopies(Main.TEAM_SIZE - 1, formateDiv("-b "))) + formateDiv("-c");
    private static final String mid10 = formateDiv("d ") + String.join("",
            Collections.nCopies(Main.TEAM_SIZE - 1, formateDiv("-e "))) + formateDiv("-f");
    private static final String bott10 = formateDiv("g ") + String.join("",
            Collections.nCopies(Main.TEAM_SIZE - 1, formateDiv("-h "))) + formateDiv("-i");

    //----------------отрисовка строчек псевдографики таблицы --------конец-----------------
    public static void view() {
//        System.out.println(ConsoleView.top10);
        for (int i = 1; i <= Main.TEAM_SIZE - 1; i++) {
            for (int j = 1; j <= Main.TEAM_SIZE; j++) {
                System.out.print(getHeroChar(new Vector2(j, i)));
            }
            System.out.println();
//            System.out.println(ConsoleView.mid10);
        }
        for (int j = 1; j <= Main.TEAM_SIZE; j++) {
            System.out.print(getHeroChar(new Vector2(j, Main.TEAM_SIZE)));
        }
        System.out.println();
//        System.out.println(ConsoleView.bott10);
        System.out.println("Press ENTER for next step");
    }

    private static String formateDiv(String str) {
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500');
    }

    private static String getHeroChar(Vector2 position) {
        String str = "|__";
        for (int i = 0; i < Main.TEAM_SIZE; i++) {

            if (Main.leftSide.get(i).hp != 0) {
                if (Main.leftSide.get(i).getPosition().isEquals(position)) {
                    str = "|" + AnsiColors.ANSI_GREEN + Main.leftSide.get(i).name.substring(0, 2) + AnsiColors.ANSI_RESET;
                }

                if (Main.rightSide.get(i).hp != 0) {
                    if (Main.rightSide.get(i).getPosition().isEquals(position)) {
                        str = "|" + AnsiColors.ANSI_BLUE + Main.rightSide.get(i).name.substring(0, 2) + AnsiColors.ANSI_RESET + "|"
                                + " ".repeat(3) + AnsiColors.ANSI_GREEN + Main.leftSide.get(i).toString() + AnsiColors.ANSI_RESET
                                + " ".repeat(5) + AnsiColors.ANSI_BLUE + Main.rightSide.get(i).toString() + AnsiColors.ANSI_RESET;
                    }
                } else {
                    if (Main.rightSide.get(i).getPosition().isEquals(position)) {
                        str = "|" + AnsiColors.ANSI_RED + Main.rightSide.get(i).name.substring(0, 2) + AnsiColors.ANSI_RESET + "|"
                                + " ".repeat(3) + AnsiColors.ANSI_GREEN + Main.leftSide.get(i).toString() + AnsiColors.ANSI_RESET
                                + " ".repeat(5) + AnsiColors.ANSI_RED + Main.rightSide.get(i).toString() + AnsiColors.ANSI_RESET;
                    }
                }
            } else {
                if (Main.leftSide.get(i).getPosition().isEquals(position)) {
                    str = "|" + AnsiColors.ANSI_RED + Main.leftSide.get(i).name.substring(0, 2) + AnsiColors.ANSI_RESET;
                    if (Main.rightSide.get(i).hp != 0) {
                        if (Main.rightSide.get(i).getPosition().isEquals(position)) {
                            str = "|" + AnsiColors.ANSI_BLUE + Main.rightSide.get(i).name.substring(0, 2) + AnsiColors.ANSI_RESET + "|"
                                    + " ".repeat(3) + AnsiColors.ANSI_RED + Main.leftSide.get(i).toString() + AnsiColors.ANSI_RESET
                                    + " ".repeat(5) + AnsiColors.ANSI_BLUE + Main.rightSide.get(i).toString() + AnsiColors.ANSI_RESET;
                        }

                    } else {
                        if (Main.rightSide.get(i).getPosition().isEquals(position)) {
                            str = "|" + AnsiColors.ANSI_RED + Main.rightSide.get(i).name.substring(0, 2) + "|"
                                    + " ".repeat(3) + AnsiColors.ANSI_RED + Main.leftSide.get(i).toString()
                                    + " ".repeat(5) + AnsiColors.ANSI_RED + Main.rightSide.get(i).toString() + AnsiColors.ANSI_RESET;
                        }
                    }
                }
            }
        }
        return str;
    }
}