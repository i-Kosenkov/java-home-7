import java.util.ArrayList;

public class Warriors extends BaseHero {
    public Warriors(ArrayList<BaseHero> myTeam, String name, int hp, int attack, int defence, int[] damage, int speed, int x, int y) {
        super(myTeam, name, hp, attack, defence, damage, speed, x, y);
    }

    @Override
    public String toString() {
        return String.format("%s %11s", super.toString(), " ");
    }

    public void step(ArrayList<BaseHero> teamList) {
        int index = 0;
        if (this.hp == 0) {
            System.out.println(AnsiColors.ANSI_RED + this.name + " " + this.getClass().getSimpleName() + " is dead ❌☠️" + AnsiColors.ANSI_RESET);
        } else {
            float min = Float.MAX_VALUE;
            for (int i = 0; i < teamList.size(); i++) {
                if (teamList.get(i).hp != 0) {
                    if (min > getDistance(teamList.get(i).position.x, teamList.get(i).position.y)) {
                        min = getDistance(teamList.get(i).position.x, teamList.get(i).position.y);
                        index = i;
                    }
                }
            }
            int posX = this.position.x - teamList.get(index).position.x;
            int posY = this.position.y - teamList.get(index).position.y;

            if (posY == 0) {
                if (posX < 0) {
                    if (getFreeCell(this.myTeam, teamList, this.position.x + 1, this.position.y)){
                        this.position.x += 1;
                    }
                } else {
                    if (getFreeCell(this.myTeam, teamList, this.position.x + 1, this.position.y)){
                        this.position.x -= 1;
                    }
                }
            } else if (posY < 0) {
                this.position.y += 1;
            } else {
                this.position.y -= 1;
            }
            System.out.println(this.name + " " + this.getClass().getSimpleName() + " run Forest run");


//        System.out.println(this.position.x);
//        System.out.println(this.position.y);


//        if (this.position.x == teamList.get(index).position.x) {
//            this.position.y
//        }
//        this.position.x += 1;


//        } else {
//            int index = getIndexPlayerMinHp(teamList);
//            if (index != -1) {
//                int d = r.nextInt(this.damage[0], this.damage[1] + 1);
//                teamList.get(index).getDamage(d);
//                System.out.println(this.name + " " + this.getClass().getSimpleName() + " attack " + d + " ⚔️️ " + teamList.get(index));
//            } else {
//                System.out.println(this.name + " " + this.getClass().getSimpleName() + " \uD83D\uDE34");
//            }
//        }
        }
    }
}
