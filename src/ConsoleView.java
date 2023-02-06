public class ConsoleView {

    public static void view() {
        int npcIndex = 0;
        for (int i = 1; i <= Main.TEAM_SIZE - 1; i++) {
            for (int j = 1; j <= Main.TEAM_SIZE; j++) {
                System.out.print(getChar(new Vector2(i, j)));
            }
            System.out.print("|");
            System.out.println(PrintInfo(npcIndex));
            npcIndex++;
        }
        for (int j = 1; j <= Main.TEAM_SIZE; j++) {
            System.out.print(getChar(new Vector2(10, j)));
        }
        System.out.print("|");
        System.out.println(PrintInfo(npcIndex));
        System.out.println("Press ENTER for next step");
    }

    private static String getChar(Vector2 position) {
        String str = "|__";
        boolean alive = false;
        for (int i = 0; i < Main.TEAM_SIZE; i++) {
            if (Main.leftSide.get(i).getPosition().isEquals(position)) {
                if (Main.leftSide.get(i).hp == 0) {
                    str = "|" + AnsiColors.ANSI_RED + Main.leftSide.get(i).name.substring(0, 2) + AnsiColors.ANSI_RESET;

                } else {
                    str = "|" + AnsiColors.ANSI_GREEN + Main.leftSide.get(i).name.substring(0, 2) + AnsiColors.ANSI_RESET;

                }
            }
            if (Main.rightSide.get(i).getPosition().isEquals(position) && !alive) {
                if (Main.rightSide.get(i).hp == 0) {
                    str = "|" + AnsiColors.ANSI_RED + Main.rightSide.get(i).name.substring(0, 2) + AnsiColors.ANSI_RESET;
                } else {
                    str = "|" + AnsiColors.ANSI_BLUE + Main.rightSide.get(i).name.substring(0, 2) + AnsiColors.ANSI_RESET;

                }
            }
        }
        return str;
    }

    private static String PrintInfo(int npcIndex) {
        String str = "";
        if (Main.leftSide.get(npcIndex).hp == 0) {
            str += "     " + AnsiColors.ANSI_RED + Main.leftSide.get(npcIndex).toString() + AnsiColors.ANSI_RESET;
        } else {
            str += "     " + AnsiColors.ANSI_GREEN + Main.leftSide.get(npcIndex).toString() + AnsiColors.ANSI_RESET;
        }
        if (Main.rightSide.get(npcIndex).hp == 0) {
            str += "     " + AnsiColors.ANSI_RED + Main.rightSide.get(npcIndex).toString() + AnsiColors.ANSI_RESET;
        } else {
            str += "     " + AnsiColors.ANSI_BLUE + Main.rightSide.get(npcIndex).toString() + AnsiColors.ANSI_RESET;
        }
        return str;
    }
}
