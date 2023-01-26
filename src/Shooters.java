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
            System.out.println(this.name + " " + this.getClass().getSimpleName() + " is dead ❌");
        } else {
            if (this.shots > 0) {
                this.shots -= 1;
                System.out.println(this.name + " " + this.getClass().getSimpleName() + " fired one arrow \uD83C\uDFF9 "
                        + "Remaining arrow: " + this.shots + "/" + maxShots);
            }
        }
    }

    public String getInfoShots() {
        return String.valueOf(shots * 100 / maxShots);
    }
}
