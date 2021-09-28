package S191220142.task2;

public class SelectSorter implements Sorter {
    
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
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < a.length - 1; i++) {
                double minGrayLevel = a[0][0] * 0.299 + a[0][1] * 0.587 + a[0][2] * 0.114;
                int minIndex = 0;
                for (int j = 1; j <= a.length - 1 - i; j++) {
                    if(minGrayLevel > a[j][0] * 0.299 + a[j][1] * 0.587 + a[j][2] * 0.114){
                        minGrayLevel = a[j][0] * 0.299 + a[j][1] * 0.587 + a[j][2] * 0.114;
                        minIndex = j;
                    }
                }
                if (minIndex != a.length - 1 - i) {
                    swap(minIndex, a.length - 1 - i);
                }
            }
        }
    }

    @Override
    public String getPlan() {
        return this.plan;
    }

}