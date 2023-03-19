package algorithms;

import process.Process;

import java.util.List;

public class FCFS {
    private final List<Process> processList;
    private int time = 0;

    public FCFS(List<Process> processList) {
        this.processList = processList;
    }

    public void execute() {
        processList.stream().filter(x -> x.getArrivalTime() >= time && !x.isDone()).forEach(x -> {
            int neededTime = x.getTimeLeft();
            x.execute(neededTime);
            time += neededTime;
        });
    }


}
