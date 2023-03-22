package statistics;

import algorithms.ExecutableWithStatistic;
import algorithms.FCFS;
import algorithms.RR;
import algorithms.SJF;
import process.ProcessesGenerator;

import java.util.Arrays;
import java.util.List;

public class StatisticPresenter {
    private int amountOfProcesses = 20000;
    private int quantumOfTimeForRR = 12;
    private int maxArrivalTime = 150000;
    private int minProcessLength = 1;
    private int maxProcessLength = 20;

    public StatisticPresenter() { }

    public StatisticPresenter(int amountOfProcesses, int quantumOfTimeForRR, int maxArrivalTime, int minProcessLength, int maxProcessLength) {
        this.amountOfProcesses = amountOfProcesses;
        this.quantumOfTimeForRR = quantumOfTimeForRR;
        this.maxArrivalTime = maxArrivalTime;
        this.minProcessLength = minProcessLength;
        this.maxProcessLength = maxProcessLength;
    }

    public void demo() {
//        long seed = System.currentTimeMillis();
        long seed = 1111;

        ProcessesGenerator processesGenerator = new ProcessesGenerator(maxArrivalTime, minProcessLength, maxProcessLength);
        List<ExecutableWithStatistic> algorithms = Arrays.asList(
                new FCFS(processesGenerator.generateProcessList(amountOfProcesses, seed)),
                new SJF(processesGenerator.generateProcessList(amountOfProcesses, seed)),
                new RR(processesGenerator.generateProcessList(amountOfProcesses, seed), quantumOfTimeForRR)
        );

        System.out.println("| -------------------------------------------------------------------------------------------------------------------------------- |");
        System.out.println("| processAmount | changeContentAmount | executionTime | breakTime | avgWaitingTime | maxWaitingTime | avgWaitingForFirstActionTime |");

        algorithms.forEach(algorithm ->  {
            algorithm.execute();
            Statistic stats = algorithm.getStatistic();
            System.out.printf("| %13d | %19d | %13d | %9d | %14d | %14d | %28d |\n",
                    stats.processAmount(), stats.changeContentAmount(), stats.executionTime(), stats.breakTime(), stats.avgWaitingTime(), stats.maxWaitingTime(), stats.avgWaitingForFirstActionTime());
        });

        System.out.println("| -------------------------------------------------------------------------------------------------------------------------------- |\n");
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

}
