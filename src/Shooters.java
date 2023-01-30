import java.util.ArrayList;

public class Shooters extends BaseHero {
    int shots;
    int maxShots;

    public Shooters(ArrayList<BaseHero> myTeam, String name, int hp, int attack, int defence, int[] damage, int speed, int shots, int x, int y) {
        super(myTeam, name, hp, attack, defence, damage, speed, x, y);
        this.maxShots = shots;
        this.shots = shots;
    }

    @Override
    public String toString() {
        return String.format("%s %s %02d/%02d", super.toString(), "\uD83C\uDFF9", shots, maxShots);
    }

    public void step(ArrayList<BaseHero> teamList) {
        if (this.hp == 0) {
            System.out.println(AnsiColors.ANSI_RED + this.name + " " + this.getClass().getSimpleName() + " is dead ❌☠️" + AnsiColors.ANSI_RESET);
        } else {
            float min = Float.MAX_VALUE;
            int index = 0;
            for (int i = 0; i < teamList.size(); i++) {
                if (teamList.get(i).hp != 0) {
                    if (min > getDistance(teamList.get(i).position.x, teamList.get(i).position.y)) {
                        min = getDistance(teamList.get(i).position.x, teamList.get(i).position.y);
                        index = i;
                    }
                }
            }
            int damage = attack(teamList, min, index);
            if (this.shots > 0) {
                this.shots -= 1;
                System.out.println(this.name + " " + this.getClass().getSimpleName() + " fired arrow " + damage + " \uD83C\uDFF9 "
                        + teamList.get(index));
            }
        }
    }

    public String getInfoShots() {
        return String.valueOf(shots * 100 / maxShots);
    }
}
