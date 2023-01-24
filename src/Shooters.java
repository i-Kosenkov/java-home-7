import java.util.ArrayList;

public class Shooters extends BaseHero {
    int shots;
    int maxShots;

    public Shooters(String name, int hp, int attack, int defence, int[] damage, int speed, int shots) {
        super(name, hp, attack, defence, damage, speed);
        this.maxShots = shots;
        this.shots = shots;
    }

    @Override
    public String toString() {
        return super.toString() + " Shots: " + shots;
    }

    public void step(ArrayList<BaseHero> teamList) {
        if (this.shots > 0) {
            this.shots -= 1;
            System.out.println("Player " + this.name + " (" + this.getClass().getSimpleName() + ")" + " fired one arrow ↣ " + "Remaining arrow: " + this.shots);
        }
    }

    public String getInfoShots() {
        return String.valueOf(shots * 100 / maxShots);
    }
}
