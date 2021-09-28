package S191220142.task2;

public class QuickSorter implements Sorter {

    private int[][] a;
    private double[] grayLevel;
    private String plan = "";

    @Override
    public void load(int[][] a) {
        this.a = a;
        grayLevel = new double[a.length];
        for (int i = 0; i < a.length; i++){
            grayLevel[i] = a[i][0] * 0.299 + a[i][1] * 0.587 + a[i][2] * 0.114;
        }
    }

    private void swap(int i, int j) {
        double temp;
        temp = grayLevel[i];
        grayLevel[i] = grayLevel[j];
        grayLevel[j] = temp;
        int[] temp1;
        temp1 = a[i];
        a[i] = a[j];
        a[j] = temp1;
        plan += "" + a[i][0] + "<->" + a[i][1] + "<->" + a[i][2] + "<->" + 
                   + a[j][0] + "<->" + a[j][1] + "<->" + a[j][2] + "\n";
    }

    @Override
    public void sort() {
        int low = 0, high = a.length - 1;
        quickSort(low, high);
    }

    private void quickSort(int low, int high){
        if (low >= high) return;
        int curlow = low + 1, curhigh = high;
        while(curlow < curhigh){
            while(curlow < curhigh && grayLevel[curlow] <= grayLevel[low]){
                curlow++; // 从左往右找比ranks[low]大的数
            }
            while(curlow < curhigh && grayLevel[curhigh] >= grayLevel[low]){
                curhigh--; // 从右往左找比ranks[low]小的数
            }
            if (curlow == curhigh) break; // 当curlow和curhigh相等时结束循环
            swap(curlow, curhigh);
        }
        while(grayLevel[curhigh] > grayLevel[low]){
            curhigh--;
        }
        swap(low, curhigh);
        quickSort(low, curhigh - 1);
        quickSort(curhigh + 1, high);
    }

    @Override
    public String getPlan() {
        return this.plan;
    }

}
