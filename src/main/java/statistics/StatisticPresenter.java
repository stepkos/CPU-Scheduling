package statistics;

import algorithms.ExecutableWithStatistic;
import algorithms.FCFS;
import algorithms.RR;
import algorithms.SJF;
import process.ProcessesGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class StatisticPresenter {
    private final Locale locale = new Locale("pl", "PL", "S");
    private int amountOfProcesses = 20_000;
    private int quantumOfTimeForRR = 12;
    private int maxArrivalTime = 150_000;
    private int minProcessLength = 1;
    private int maxProcessLength = 20;
    private int hungerLevel = 100_000;

    public StatisticPresenter() { }

    public StatisticPresenter(int amountOfProcesses, int quantumOfTimeForRR, int maxArrivalTime, int minProcessLength, int maxProcessLength, int hungerLevel) {
        this.amountOfProcesses = amountOfProcesses;
        this.quantumOfTimeForRR = quantumOfTimeForRR;
        this.maxArrivalTime = maxArrivalTime;
        this.minProcessLength = minProcessLength;
        this.maxProcessLength = maxProcessLength;
        this.hungerLevel = hungerLevel;
    }

    public void demo() {
        long seed = System.currentTimeMillis();

        ProcessesGenerator processesGenerator = new ProcessesGenerator(maxArrivalTime, minProcessLength, maxProcessLength);
        List<ExecutableWithStatistic> algorithms = Arrays.asList(
                new FCFS(processesGenerator.generateProcessList(amountOfProcesses, seed), hungerLevel),
                new SJF(processesGenerator.generateProcessList(amountOfProcesses, seed), hungerLevel),
                new RR(processesGenerator.generateProcessList(amountOfProcesses, seed), hungerLevel, quantumOfTimeForRR)
        );

        printClassSettings();
        printTableLine();
        printTableHead();

        algorithms.forEach(algorithm ->  {
            algorithm.execute();
            printTableRow(algorithm.getStatistic());
        });

        printTableLine();
    }

    private void printClassSettings() {
        System.out.printf(locale, "Amount of processes: %,d\n", amountOfProcesses);
        System.out.printf(locale, "Arrival time range <1, %,d>\n", maxArrivalTime);
        System.out.printf("Processes length range <%d, %d>\n", minProcessLength, maxProcessLength);
        System.out.printf("Probability distribution: Short<%d, %d> 30%% | Medium<%d, %d> 60%% | Long<%d, %d> 10%%\n",
                minProcessLength, minProcessLength + maxProcessLength/3,
                minProcessLength + maxProcessLength/3 + 1, minProcessLength + (maxProcessLength/3)*2,
                minProcessLength + (maxProcessLength/3)*2 + 1, maxProcessLength);
        System.out.println("Quantum of time for RR (Round Rabin): " + quantumOfTimeForRR);
        System.out.printf(locale, "Hunger level: %,d\n", hungerLevel);
    }

    private void printTableLine() {
        System.out.println("| ------------------------------------------------------------------------------------------------------------------------------------------------------------ |");
    }

    private void printTableHead() {
        System.out.println("| algorithm | processAmount | changeContentAmount | executionTime | breakTime | avgWaitingTime | maxWaitingTime | starvedAmount | avgWaitingForFirstActionTime |");
    }

    private void printTableRow(Statistic stats) {
        System.out.printf(locale, "| %9s | %,13d | %,19d | %,13d | %,9d | %,14d | %,14d | %,13d | %,28d |\n",
                stats.name(), stats.processAmount(), stats.changeContentAmount(), stats.executionTime(), stats.breakTime(), stats.avgWaitingTime(), stats.maxWaitingTime(), stats.starvedProcesses(), stats.avgWaitingForFirstActionTime());
    }

    public int getAmountOfProcesses() {
        return amountOfProcesses;
    }

    public void setAmountOfProcesses(int amountOfProcesses) {
        this.amountOfProcesses = amountOfProcesses;
    }

    public int getQuantumOfTimeForRR() {
        return quantumOfTimeForRR;
    }

    public void setQuantumOfTimeForRR(int quantumOfTimeForRR) {
        this.quantumOfTimeForRR = quantumOfTimeForRR;
    }

    public int getMaxArrivalTime() {
        return maxArrivalTime;
    }

    public void setMaxArrivalTime(int maxArrivalTime) {
        this.maxArrivalTime = maxArrivalTime;
    }

    public int getMinProcessLength() {
        return minProcessLength;
    }

    public void setMinProcessLength(int minProcessLength) {
        this.minProcessLength = minProcessLength;
    }

    public int getMaxProcessLength() {
        return maxProcessLength;
    }

    public void setMaxProcessLength(int maxProcessLength) {
        this.maxProcessLength = maxProcessLength;
    }

    public int getHungerLevel() {
        return hungerLevel;
    }

    public void setHungerLevel(int hungerLevel) {
        this.hungerLevel = hungerLevel;
    }

}
