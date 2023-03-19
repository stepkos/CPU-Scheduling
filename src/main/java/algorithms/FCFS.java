package algorithms;

import process.Process;
import process.ProcessList;

import java.util.Comparator;
import java.util.List;

public class FCFS {
    private final ProcessList processList;
    private int executionTime = 0;
    private int breakTime = 0;

    public FCFS(ProcessList processList) {
        this.processList = processList;
        this.processList.sort(Comparator.comparingInt(Process::getArrivalTime));
    }

    public void execute() {
        while (!processList.isDone()) {
            List<Process> actualList = processList.getExistsAndNotDoneList(executionTime + breakTime);
            if (actualList.isEmpty())
                breakTime++;
            else
                executionTime += actualList.get(0).execute();
        }

        // Temporary stats
        System.out.println("Execution time: " + executionTime);
        System.out.println("Break time: " + breakTime);
    }

}
