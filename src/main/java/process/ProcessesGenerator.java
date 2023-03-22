package process;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProcessesGenerator {
    private final int maxArrivalTime;
    private final int minProcessLength;
    private final int maxProcessLength;

    public ProcessesGenerator() {
        maxArrivalTime = 15000;
        minProcessLength = 1;
        maxProcessLength = 20;
    }

    public ProcessesGenerator(int maxArrivalTime, int minProcessLength, int maxProcessLength) {
        this.maxArrivalTime = maxArrivalTime;
        this.minProcessLength = minProcessLength;
        this.maxProcessLength = maxProcessLength;
    }

    public List<Process> generateList(int amount, long seed) {
        List<Process> processList = new ArrayList<>();
        Random rand = new Random(seed);

        for (int i=1; i<=amount; i++)
            processList.add(new Process(i,
                    rand.nextInt(0, maxArrivalTime),
                    rand.nextInt(minProcessLength, maxProcessLength)
            ));

        return  processList;
    }

    public ProcessList generateProcessList(int amount, long seed) {
        return new ProcessList(generateList(amount, seed));
    }

}
