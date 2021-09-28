package S191220142.task3;

public class BubbleSorter implements Sorter {

    private int[] ranks;
    private String plan = "";

    @Override
    public void load(int[] ranks) {
        this.ranks = ranks;
    }

    private void swap(int i, int j) {
        int temp;
        temp = ranks[i];
        ranks[i] = ranks[j];
        ranks[j] = temp;
        plan += "" + ranks[i] + "<->" + ranks[j] + "\n";
    }

    @Override
    public void sort() {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < ranks.length - 1; i++) {
                if (ranks[i] > ranks[i + 1]) {
                    swap(i, i + 1);
                    sorted = false;
                }
            }
        }
    }

    @Override
    public String getPlan() {
        return this.plan;
    }

}