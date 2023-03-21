package statistics;

public class Statistic {

    private final int processAmount;
    private final int changeContentAmount;
    private final int executionTime;
    private final int breakTime;
    private final int avgWaitingTime;
    private final int maxWaitingTime;

    public Statistic(int processAmount, int changeContentAmount, int executionTime, int breakTime, int avgWaitingTime, int maxWaitingTime) {
        this.processAmount = processAmount;
        this.changeContentAmount = changeContentAmount;
        this.executionTime = executionTime;
        this.breakTime = breakTime;
        this.avgWaitingTime = avgWaitingTime;
        this.maxWaitingTime = maxWaitingTime;
    }

    public int getProcessAmount() {
        return processAmount;
    }

    public int getChangeContentAmount() {
        return changeContentAmount;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    public int getBreakTime() {
        return breakTime;
    }

    public int getAvgWaitingTime() {
        return avgWaitingTime;
    }

    public int getMaxWaitingTime() {
        return maxWaitingTime;
    }

    @Override
    public String toString() {
        return "AlgorithmStatistic{" +
                "processAmount=" + processAmount +
                ", changeContentAmount=" + changeContentAmount +
                ", executionTime=" + executionTime +
                ", breakTime=" + breakTime +
                ", avgWaitingTime=" + avgWaitingTime +
                ", maxWaitingTime=" + maxWaitingTime +
                '}';
    }

}
