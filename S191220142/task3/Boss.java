package S191220142.task3;

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

    public String matrixUp(Matrix matrix) {

        String log = new String();

        if (sorter == null) {
            return null;
        }

        Linable[] linables = matrix.toArray();
        int[] ranks = new int[linables.length];

        for (int i = 0; i < linables.length; i++) {
            ranks[i] = linables[i].getValue();
        }

        sorter.load(ranks);
        sorter.sort();

        String[] sortSteps = this.parsePlan(sorter.getPlan());

        for (String step : sortSteps) {
            this.execute(step);
            System.out.println(matrix.toString());
            log += matrix.toString();
            log += "\n[frame]\n";
        }

        return log;

    }

    private String[] parsePlan(String plan) {
        return plan.split("\n");
    }

    private void execute(String step) {
        String[] couple = step.split("<->");
        if(couple[0] != "" && couple[1] != ""){
            Monster.getMonsterByRank(Integer.parseInt(couple[0]))
                    .swapPosition(Monster.getMonsterByRank(Integer.parseInt(couple[1])));
        }
    }

}
