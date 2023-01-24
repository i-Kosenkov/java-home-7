public class Crossbowman extends Shooters {

    public Crossbowman() {
        super(String.format("%d", ++Crossbowman.number), 6, 3, 10, new int[]{2, 3}, 4, 16);
    }
}