package process;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProcessesGenerator {
    private final int maxArrivalTime;
    private final int minProcessLength;
    private final int maxProcessLength;
    private int shortProcessLimit = 30;
    private int mediumProcessLimit = 90;

    public ProcessesGenerator(int maxArrivalTime, int minProcessLength, int maxProcessLength) {
        this.maxArrivalTime = maxArrivalTime;
        this.minProcessLength = minProcessLength;
        this.maxProcessLength = maxProcessLength;
    }

    public void setProcessLengthRatioLimits(int shortProcessLimit, int mediumProcessLimit) {
        if (shortProcessLimit > mediumProcessLimit && shortProcessLimit + mediumProcessLimit > 100)
            throw new UnsupportedOperationException("Invalid argument");

        this.shortProcessLimit = shortProcessLimit;
        this.mediumProcessLimit = mediumProcessLimit;
    }

    public List<Process> generateList(int amount, long seed) {
        List<Process> processList = new ArrayList<>();
        Random rand = new Random(seed);

        for (int i=1; i<=amount; i++) {
            int randLengthRange = rand.nextInt(1, 100);
            int processLength;

            if (randLengthRange <= shortProcessLimit)
                processLength = rand.nextInt(minProcessLength, minProcessLength + maxProcessLength/3);
            else if (randLengthRange <= mediumProcessLimit)
                processLength = rand.nextInt(minProcessLength + maxProcessLength/3 + 1, minProcessLength + (maxProcessLength/3)*2);
            else
                processLength = rand.nextInt(minProcessLength + (maxProcessLength/3)*2 + 1, maxProcessLength);

            processList.add(new Process(i,
                    rand.nextInt(0, maxArrivalTime),
                    processLength
            ));
        }

        return  processList;
    }

    public ProcessList generateProcessList(int amount, long seed) {
        return new ProcessList(generateList(amount, seed));
    }

}
