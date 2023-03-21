package process;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProcessesGenerator {

    private final int minArrivalTime;
    private final int maxArrivalTime;
    private final int minTotalTime;
    private final int maxTotalTime;

    public ProcessesGenerator() {
        minArrivalTime = 1;
        maxArrivalTime = 15000;
        minTotalTime = 1;
        maxTotalTime = 20;
    }

    public ProcessesGenerator(int minArrivalTime, int maxArrivalTime, int minTotalTime, int maxTotalTime) {
        this.minArrivalTime = minArrivalTime;
        this.maxArrivalTime = maxArrivalTime;
        this.minTotalTime = minTotalTime;
        this.maxTotalTime = maxTotalTime;
    }

    public List<Process> generateList(int amount, long seed) {
        List<Process> processList = new ArrayList<>();
        Random rand = new Random(seed);

        for (int i=1; i<=amount; i++)
            processList.add(new Process(i,
                    rand.nextInt(minArrivalTime, maxArrivalTime),
                    rand.nextInt(minTotalTime, maxTotalTime)
            ));

        return  processList;
    }

    public ProcessList generateProcessList(int amount, long seed) {
        return new ProcessList(generateList(amount, seed));
    }

}
