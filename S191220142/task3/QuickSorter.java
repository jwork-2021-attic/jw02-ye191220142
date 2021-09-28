package S191220142.task3;

public class QuickSorter implements Sorter {

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
        int low = 0, high = ranks.length - 1;
        quickSort(low, high);
    }

    private void quickSort(int low, int high){
        if (low >= high) return;
        int curlow = low + 1, curhigh = high;
        while(curlow < curhigh){
            while(curlow < curhigh && ranks[curlow] <= ranks[low]){
                curlow++; // 从左往右找比ranks[low]大的数
            }
            while(curlow < curhigh && ranks[curhigh] >= ranks[low]){
                curhigh--; // 从右往左找比ranks[low]小的数
            }
            if (curlow == curhigh) break; // 当curlow和curhigh相等时结束循环
            swap(curlow, curhigh);
        }
        while(ranks[curhigh] > ranks[low]){
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
