public class Sniper extends Shooters {

    public Sniper() {
        super(String.format("%d", ++Sniper.number), 15, 12, 10, new int[]{8, 10}, 9, 32);
    }
}