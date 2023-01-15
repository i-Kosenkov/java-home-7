public class Crossbowman extends BaseHero {
    private int shots;

    public Crossbowman() {
        super(String.format("%d", ++Crossbowman.number), 6, 3, 10, new int[]{2, 3}, 4);
        this.shots = 16;
    }

    @Override
    public String toString() {
        return super.toString() + " Shots: " + shots;
    }
}
