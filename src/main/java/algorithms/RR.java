package algorithms;

import process.Process;
import process.ProcessList;
import statistics.Statistic;

import java.util.Comparator;
import java.util.List;

public class RR implements ExecutableWithStatistic {
    private final ProcessList processList;
    private Statistic statistic = null;
    private final int quantum;
    private int executionTime = 0;
    private int breakTime = 0;
    private long summaryWaitingTime = 0;
    private int maxWaitingTime = 0;
    private int changeContent = 0;

    public RR(ProcessList processList, int quantum) {
        this.processList = processList;
        this.processList.sort(Comparator.comparingInt(Process::getArrivalTime));
        this.quantum = quantum;
    }

    @Override
    public void execute() {
        List<Process> allList = processList.getList();
        Process lastProcess = null;
        int i = 0;

        while (!processList.isDone()) {
            if (processList.getExistsAndNotDoneList(executionTime + breakTime).isEmpty())
                breakTime++;
            else {
                Process currentProcess = allList.get(i % allList.size());

                if (currentProcess.exists(executionTime + breakTime) && !currentProcess.isDone()) {

                    if (lastProcess == null) {
                        lastProcess = currentProcess;
                        changeContent++;
                    }
                    else if (currentProcess != lastProcess) {
                        lastProcess = currentProcess;
                        changeContent++;
                    }

                    int timeToExecute = Math.min(currentProcess.getTimeLeft(), quantum);
                    currentProcess.execute(timeToExecute);
                    executionTime += timeToExecute;

                    if (currentProcess.isDone()) {
                        int waitingTime = executionTime + breakTime - timeToExecute - currentProcess.getArrivalTime();
                        if (waitingTime > maxWaitingTime) maxWaitingTime = waitingTime;
                        summaryWaitingTime += waitingTime;
                    }
                }
                i++;
            }
        }

        // Make stats
        int listSize = allList.size();
        this.statistic = new Statistic(
                listSize,
                changeContent,
                executionTime,
                breakTime,
                listSize > 0 ? (int)(summaryWaitingTime / listSize) : null,
                maxWaitingTime
        );
    }

    @Override
    public Statistic getStatistic() {
        if (statistic == null)
            throw new UnsupportedOperationException("You have to execute algorithm first");
        return statistic;
    }

}
