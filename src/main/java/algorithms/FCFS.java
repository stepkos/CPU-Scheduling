package algorithms;

import process.Process;
import process.ProcessList;

import java.util.Comparator;
import java.util.List;

public class FCFS {
    private final ProcessList processList;
    private int executionTime = 0;
    private int breakTime = 0;
    private int summaryWaitingTime = 0;
    private int maxWaitingTime = 0;

    public FCFS(ProcessList processList) {
        this.processList = processList;
        this.processList.sort(Comparator.comparingInt(Process::getArrivalTime));
    }

    public void execute() {
        while (!processList.isDone()) {
            List<Process> actualList = processList.getExistsAndNotDoneList(executionTime + breakTime);
            if (actualList.isEmpty())
                breakTime++;
            else {
                // TODO Debug summaryWaitingTime for spec list
                int waitingTime = executionTime + breakTime - actualList.get(0).getArrivalTime();
                if (waitingTime > maxWaitingTime) maxWaitingTime = waitingTime;
                summaryWaitingTime += waitingTime;
                executionTime += actualList.get(0).execute();
            }
        }

        // Temporary stats
        int listSize = processList.getList().size();
        System.out.println("STATS FOR FCFS");
        System.out.println("Process amount: " + listSize);
        System.out.println("Change content amount: " + listSize);
        System.out.println("Execution time: " + executionTime);
        System.out.println("Break time: " + breakTime);
        System.out.println("Avg waiting time: " + (listSize > 0 ? summaryWaitingTime / listSize : "No processes"));
        System.out.println("Max waiting time: " + maxWaitingTime);
        System.out.println();
    }

}
