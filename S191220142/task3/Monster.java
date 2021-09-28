package S191220142.task3;

import S191220142.task3.Matrix.Position;

public class Monster implements Linable {

    private final int r;
    private final int g;
    private final int b;
    private final int[] rgb;
    private final int rank;
    private static int index = 0;
    private static Monster[] monsters = new Monster[256];

    private Position position;

    Monster(int r, int g, int b, int rank) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.rgb = new int[3];
        rgb[0] = r; rgb[1] = g; rgb[2] = b;
        this.rank = rank;
        monsters[index] = this;
        index++;
    }

    public static Monster getMonsterByRank(int rank){
        for (Monster monster : monsters) {
            if (monster.rank == rank){
                return monster;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m " + "  \033[0m";
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
    public int getValue() {
        return rank;
    }

}