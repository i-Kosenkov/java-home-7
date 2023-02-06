import java.util.ArrayList;

public class Warriors extends BaseHero {
    public Warriors(ArrayList<BaseHero> myTeam, String name, int hp, int attack, int defence, int[] damage, int speed, int x, int y) {
        super(myTeam, name, hp, attack, defence, damage, speed, x, y);
    }

    @Override
    public String toString() {
        return String.format("%s %11s", super.toString()," ");
    }

    public void step(ArrayList<BaseHero> teamList) {
        if (this.hp == 0) {
            System.out.println(AnsiColors.ANSI_RED + this.name + " " + this.getClass().getSimpleName() + " is dead ❌☠️" + AnsiColors.ANSI_RESET);
        } else {
            int index = getIndexPlayerMinHp(teamList);
            if (index != -1) {
                int d = r.nextInt(this.damage[0], this.damage[1] + 1);
                teamList.get(index).getDamage(d);
                System.out.println(this.name + " " + this.getClass().getSimpleName() + " attack " + d + " ⚔️️ " + teamList.get(index));
            } else {
                System.out.println(this.name + " " + this.getClass().getSimpleName() + " \uD83D\uDE34");
            }
        }
    }
}
