package S191220142.task2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Scene {
    public static void main(String[] args) throws IOException {
        getRgb rgb = new getRgb();
        rgb.setRgb();
        int[][] color = rgb.retRgb();

        int[] source = new int[256];
        int[] ranIndex = new int[256];
        for(int i = 0; i < 256; i++){
            source[i] = i;
        }
        getRandom randoms = new getRandom(source, 256);
        ranIndex = randoms.getRandomRes();

        Line line = new Line(256);
        for(int i = 0; i < 256; i++){
            Monster monster = new Monster(color[ranIndex[i]][0], color[ranIndex[i]][1], color[ranIndex[i]][2]);
            line.put(monster, i);
        }

        Boss theBoss = Boss.getTheBoss();

        Sorter sorter = new SelectSorter();

        theBoss.setSorter(sorter);

        String log = theBoss.lineUp(line);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

    }

}
