package S191220142.task2;

public class Boss {

    private static Boss theBoss;
    private Sorter sorter;

    public static Boss getTheBoss() {
        if (theBoss == null) {
            theBoss = new Boss();
        }
        return theBoss;
    }

    private Boss() {

    }

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    public String lineUp(Line line) {

        String log = new String();

        if (sorter == null) {
            return null;
        }

        Linable[] linables = line.toArray();
        int[][] colors = new int[linables.length][3];

        for (int i = 0; i < linables.length; i++) {
            colors[i] = linables[i].getColor();
        }

        sorter.load(colors);
        sorter.sort();

        String[] sortSteps = this.parsePlan(sorter.getPlan());

        for (String step : sortSteps) {
            this.execute(step);
            System.out.println(line.toString());
            log += line.toString();
            log += "\n[frame]\n";
        }

        return log;

    }

    private String[] parsePlan(String plan) {
        return plan.split("\n");
    }

    private void execute(String step) {
        String[] couple = step.split("<->");
        int[][] rgbs = new int[2][3];
        rgbs[0][0] = Integer.parseInt(couple[0]);
        rgbs[0][1] = Integer.parseInt(couple[1]);
        rgbs[0][2] = Integer.parseInt(couple[2]);
        rgbs[1][0] = Integer.parseInt(couple[3]);
        rgbs[1][1] = Integer.parseInt(couple[4]);
        rgbs[1][2] = Integer.parseInt(couple[5]);
        Monster.getMonsterByColor(rgbs[0])
                .swapPosition(Monster.getMonsterByColor(rgbs[1]));
    }

}
