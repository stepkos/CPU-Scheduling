import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProcessList {
    private final List<Process> processList = new ArrayList<>();

    public ProcessList() {
        generateProcesses(20);
    }

    private void generateProcesses(int amount) {
        Random rand = new Random();

        for (int i=0; i<amount; i++)
            processList.add(new Process(
                    rand.nextInt(1, 50),
                    rand.nextInt(1, 20)
            ));
    }

    public void printAll() {
        System.out.println("| ---------------------------------- |");
        System.out.println("| arrivalTime | timeTotal | timeLeft |");
        processList.forEach(x -> System.out.printf("| %11d | %9d | %8d |\n", x.getArrivalTime(), x.getTimeTotal(), x.getTimeLeft()));
        System.out.println("| ---------------------------------- |");
    }

}
