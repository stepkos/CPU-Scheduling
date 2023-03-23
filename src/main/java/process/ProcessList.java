package process;

import java.util.Comparator;
import java.util.List;

public class ProcessList {
    private final List<Process> processList;

    public ProcessList(List<Process> processList) {
        this.processList = processList;
    }

    public List<Process> getList() {
        return processList;
    }

    public List<Process> getExistsAndNotDoneList(int time) {
        return processList.stream()
                .filter(x -> x.exists(time))
                .filter(x -> !x.isDone())
                .toList();
    }

    public ProcessList getExistsAndNotDone(int time) {
        return new ProcessList(processList.stream()
                .filter(x -> x.exists(time))
                .filter(x -> !x.isDone())
                .toList());
    }

    public boolean isProcessToDo(int time) {
        return processList.stream()
                .filter(x -> x.exists(time) && !x.isDone())
                .findFirst().isEmpty();
    }

    public void sort(Comparator<? super Process> comp) {
        processList.sort(comp);
    }

    public boolean isDone() {
        return processList.stream().allMatch(Process::isDone);
    }

    public void printAll() {
        System.out.println("| ------------------------------------------- |");
        System.out.println("|     id | arrivalTime | timeTotal | timeLeft |");
        processList.forEach(x -> System.out.printf("| %6d | %11d | %9d | %8d |\n",
                x.getId(), x.getArrivalTime(), x.getTotalTime(), x.getTimeLeft()));
        System.out.println("| ------------------------------------------- |\n");
    }

}
