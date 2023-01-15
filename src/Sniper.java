public class Sniper extends BaseHero {
    private int shots;

    public Sniper() {
        super(String.format("%d", ++Sniper.number), 15, 12, 10, new int[]{8, 10}, 9);
        this.shots = 32;
    }

    @Override
    public String toString() {
        return super.toString() + " Shots: " + shots;
    }
}