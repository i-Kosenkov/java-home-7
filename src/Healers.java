import java.util.ArrayList;
import java.util.Random;

public class Healers extends BaseHero {
    private int magic;

    public Healers(ArrayList<BaseHero> myTeam, String name, int hp, int attack, int defence, int[] damage, int speed, int magic, int x, int y) {
        super(myTeam, name, hp, attack, defence, damage, speed, x, y);
        this.magic = magic;
    }

    @Override
    public String toString() {
        return String.format("%s %s %-3s", super.toString(), "\uD83E\uDD84", magic);
    }

    public void step(ArrayList<BaseHero> teamList) {
        if (this.hp <= 0) {
            System.out.println(AnsiColors.ANSI_RED + this.name + " " + this.getClass().getSimpleName() + " is dead ❌☠️" + AnsiColors.ANSI_RESET);
        } else {
            int index = getIndexPlayerMinHp(myTeam);
            int d = r.nextInt(this.damage[0], this.damage[1]);

            if (myTeam.get(index).hp == 0){
                switch (new Random().nextInt(4)) {
                    case (0) -> myTeam.set(index, new Magician(myTeam, myTeam.get(index).position.x, myTeam.get(index).position.y));
                    case (1) -> myTeam.set(index, new Outlaw(myTeam, myTeam.get(index).position.x, myTeam.get(index).position.y));
                    case (2) -> myTeam.set(index, new Peasant(myTeam, myTeam.get(index).position.x, myTeam.get(index).position.y));
                    case (3) -> myTeam.set(index, new Sniper(myTeam, myTeam.get(index).position.x, myTeam.get(index).position.y));
                }

                System.out.println(this.name + " " + this.getClass().getSimpleName() + " resurrection " + (-d) + " \uD83D\uDC9A " + myTeam.get(index));

//                myTeam.set(index, new Magician(myTeam, myTeam.get(index).position.x, myTeam.get(index).position.y));
            }


            if (index != -1 && myTeam.get(index).hp != myTeam.get(index).maxHp) {
                if (myTeam.get(index).hp - d > myTeam.get(index).maxHp) {
                    myTeam.get(index).hp = myTeam.get(index).maxHp;
                } else {
                    myTeam.get(index).hp -= d;
                }
                System.out.println(this.name + " " + this.getClass().getSimpleName() + " healed " + (-d) + " \uD83D\uDC9A " + myTeam.get(index));
            } else {
                System.out.println(this.name + " " + this.getClass().getSimpleName() + " \uD83D\uDE34");
            }
        }
    }
}
