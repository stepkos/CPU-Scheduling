package algorithms;

import process.Process;
import process.ProcessList;
import statistics.Statistic;

import java.util.Comparator;
import java.util.List;

public class SJF implements ExecutableWithStatistic {
    private final ProcessList processList;
    private final int listSize;
    private final int hungerLevel;
    private Statistic statistic = null;
    private int executionTime = 0;
    private int breakTime = 0;
    private long summaryWaitingTime = 0;
    private int maxWaitingTime = 0;
    private int starvedProcesses = 0;

    public SJF(ProcessList processList, int hungerLevel) {
        this.hungerLevel = hungerLevel;
        this.processList = processList;
        this.processList.sort(Comparator.comparingInt(Process::getTotalTime));
        listSize = processList.getList().size();
    }

    public void execute() {
        while (!processList.isDone()) {
            List<Process> actualList = processList.getExistsAndNotDoneList(executionTime + breakTime);
            if (actualList.isEmpty())
                breakTime++;
            else {
                int waitingTime = executionTime + breakTime - actualList.get(0).getArrivalTime();
                if (waitingTime > maxWaitingTime) maxWaitingTime = waitingTime;
                if (waitingTime > hungerLevel)
                    starvedProcesses++;
                else
                    executionTime += actualList.get(0).execute();
                summaryWaitingTime += waitingTime;
                processList.getList().remove(actualList.get(0));
            }
        }

        // Make stats
        this.statistic = new Statistic("SJF",
                listSize, listSize, executionTime, breakTime,
                listSize > 0 ? (int)(summaryWaitingTime / listSize) : null,
                maxWaitingTime, starvedProcesses,
                listSize > 0 ? (int)(summaryWaitingTime / listSize) : null
        );
    }

    @Override
    public Statistic getStatistic() {
        if (statistic == null)
            throw new UnsupportedOperationException("You have to execute algorithm first");
        return statistic;
    }

}
