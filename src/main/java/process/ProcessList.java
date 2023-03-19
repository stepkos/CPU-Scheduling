package process;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProcessList {
    private List<Process> processList = new ArrayList<>();

    public ProcessList(int amount) {
        generateProcesses(amount, System.currentTimeMillis());
    }

    public ProcessList(int amount, long seed) {
        generateProcesses(amount, seed);
    }

    public ProcessList(List<Process> processList) {
        this.processList = processList;
    }

    private void generateProcesses(int amount, long seed) {
        Random rand = new Random(seed);

        for (int i=1; i<=amount; i++)
            processList.add(new Process(i,
                    rand.nextInt(1, 50),
                    rand.nextInt(1, 20)
            ));
    }

    public List<Process> getInnerList() {
        return processList;
    }

    public ProcessList getExistsAndNotDone(int time) {
        return new ProcessList(processList.stream()
                .filter(x -> x.exists(time))
                .filter(x -> !x.isDone())
                .toList());
    }

    public void printAll() {
        System.out.println("| ------------------------------------------- |");
        System.out.println("|     id | arrivalTime | timeTotal | timeLeft |");
        processList.forEach(x -> System.out.printf("| %6d | %11d | %9d | %8d |\n",
                x.getId(), x.getArrivalTime(), x.getTimeTotal(), x.getTimeLeft()));
        System.out.println("| ------------------------------------------- |\n");
    }

}
