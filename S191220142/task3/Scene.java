package S191220142.task3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Scene {
    public static void main(String[] args) throws IOException {
        getRgb rgb = new getRgb();
        rgb.setRgb();
        int[][] colors = rgb.retRgb();
        int[] ranks = rgb.retRank();

        int[] source = new int[256];
        int[] ranIndex = new int[256];
        for(int i = 0; i < 256; i++){
            source[i] = i;
        }
        getRandom randoms = new getRandom(source, 256);
        ranIndex = randoms.getRandomRes();

        Matrix matrix = new Matrix(16, 16);
        for(int i = 0; i < 16; i++){
            for(int j = 0; j < 16; j++){
                Monster monster = new Monster(colors[ranIndex[i*16+j]][0], colors[ranIndex[i*16+j]][1], colors[ranIndex[i*16+j]][2], ranks[ranIndex[i*16+j]]);
                matrix.put(monster, i, j);
            }
        }

        Boss theBoss = Boss.getTheBoss();

        Sorter sorter = new SelectSorter();

        theBoss.setSorter(sorter);

        String log = theBoss.matrixUp(matrix);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

    }

}
