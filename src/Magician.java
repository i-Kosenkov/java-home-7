public class Magician extends Healing {

    public Magician() {
        super(String.format("%d", ++Magician.number), 30, 17, 12, new int[]{-5, 0}, 9,1);
    }
}