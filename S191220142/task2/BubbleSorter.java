package S191220142.task2;

public class BubbleSorter implements Sorter {

    private int[][] a;
    private String plan = "";

    @Override
    public void load(int[][] a) {
        this.a = a;
    }

    private void swap(int i, int j) {
        int[] temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        plan += "" + a[i][0] + "<->" + a[i][1] + "<->" + a[i][2] + "<->" + 
                   + a[j][0] + "<->" + a[j][1] + "<->" + a[j][2] + "\n";
    }

    @Override
    public void sort() {
        boolean sorted = false;
        double[] grayLevel = new double[2];
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < a.length - 1; i++) {
                grayLevel[0] = a[i][0] * 0.299 + a[i][1] * 0.587 + a[i][2] * 0.114;
                grayLevel[1] = a[i + 1][0] * 0.299 + a[i + 1][1] * 0.587 + a[i + 1][2] * 0.114;
                if (grayLevel[0] < grayLevel[1]) {
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
