package algorithms;

import process.Process;
import process.ProcessList;

import java.util.Comparator;
import java.util.List;

public class RR {
    private final ProcessList processList;
    private int executionTime = 0;
    private int breakTime = 0;
    private int summaryWaitingTime = 0;
    private int maxWaitingTime = 0;
    private int changeContent = 0;

    public RR(ProcessList processList) {
        this.processList = processList;
        this.processList.sort(Comparator.comparingInt(Process::getArrivalTime));
    }

    public void execute(int k) {
        List<Process> allList = processList.getList();
        int i = 0;
        Process lastProcess = null;
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

                    int timeToExecute = Math.min(currentProcess.getTimeLeft(), k);
                    currentProcess.execute(timeToExecute);
                    executionTime += timeToExecute;

                    // TODO Debug summaryWaitingTime for spec list
                    if (currentProcess.isDone()) {
                        int waitingTime = executionTime + breakTime - timeToExecute - currentProcess.getArrivalTime();
                        if (waitingTime > maxWaitingTime) maxWaitingTime = waitingTime;
                        summaryWaitingTime += waitingTime;
                    }
                }
                i++;
            }
        }

        // Temporary stats
        int listSize = processList.getList().size();
        System.out.println("STATS FOR FCFS");
        System.out.println("Process amount: " + listSize);
        System.out.println("Change content amount: " + changeContent);
        System.out.println("Execution time: " + executionTime);
        System.out.println("Break time: " + breakTime);
        System.out.println("Avg waiting time: " + (listSize > 0 ? summaryWaitingTime / listSize : "No processes"));
        System.out.println("Max waiting time: " + maxWaitingTime);
        System.out.println();
    }

}
