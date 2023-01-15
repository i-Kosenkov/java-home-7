import java.util.Arrays;
import java.util.Random;

public class BaseHero {
    protected static int number;
    protected static Random r;

    static {
        BaseHero.number = 0;
        BaseHero.r = new Random();
    }

    protected String name;
    protected int hp;
    protected int attack;
    protected int defence;
    protected int[] damage;
    protected int speed;

    public BaseHero(String name, int hp, int attack, int defence, int[] damage, int speed) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.defence = defence;
        this.damage = damage;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return String.format("Player %s - Type: %s HP: %d Attack: %d Defence: %d Damage: %s  Speed: %d",
                name, this.getClass().getSimpleName(), hp, attack, defence, Arrays.toString(damage), speed);
    }
}