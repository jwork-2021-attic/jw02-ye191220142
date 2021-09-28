package S191220142.task2;

import S191220142.task2.Line.Position;

public class Monster implements Linable {

    private final int r;
    private final int g;
    private final int b;
    private final int[] rgb;
    private static int index = 0;
    private static Monster[] monsters = new Monster[256];

    private Position position;

    Monster(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.rgb = new int[3];
        rgb[0] = r; rgb[1] = g; rgb[2] = b;
        monsters[index] = this;
        index++;
    }

    public static Monster getMonsterByColor(int[] rgb){
        for (Monster monster : monsters) {
            if (monster.rgb[0] == rgb[0] && monster.rgb[1] == rgb[1] && monster.rgb[2] == rgb[2]){
                return monster;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        //just for test
        /*double rank = r * 0.299 + g * 0.587 + b * 0.114;
        int i = (int) rank;*/
        return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m " + " \033[0m";
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    public void swapPosition(Monster another) {
        Position p = another.position;
        this.position.setLinable(another);
        p.setLinable(this);
    }

    @Override
    public int[] getColor() {
        return rgb;
    }

}