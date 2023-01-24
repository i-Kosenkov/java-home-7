public class Monk extends Healers {

    public Monk() {
        super(String.format("%d", ++Monk.number), 30, 12, 7, new int[]{-4, 0}, 5, 1);
    }
}