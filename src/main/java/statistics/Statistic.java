package statistics;

public class Statistic {

    private final int processAmount;
    private final int changeContentAmount;
    private final int executionTime;
    private final int breakTime;
    private final int avgWaitingTime;
    private final int maxWaitingTime;
    private final int avgWaitingForFirstActionTime;

    public Statistic(int processAmount, int changeContentAmount, int executionTime, int breakTime, int avgWaitingTime, int maxWaitingTime, int avgWaitingForFirstActionTime) {
        this.processAmount = processAmount;
        this.changeContentAmount = changeContentAmount;
        this.executionTime = executionTime;
        this.breakTime = breakTime;
        this.avgWaitingTime = avgWaitingTime;
        this.maxWaitingTime = maxWaitingTime;
        this.avgWaitingForFirstActionTime = avgWaitingForFirstActionTime;
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

    public int getAvgWaitingForFirstActionTime() {
        return avgWaitingForFirstActionTime;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "processAmount=" + processAmount +
                ", changeContentAmount=" + changeContentAmount +
                ", executionTime=" + executionTime +
                ", breakTime=" + breakTime +
                ", avgWaitingTime=" + avgWaitingTime +
                ", maxWaitingTime=" + maxWaitingTime +
                ", avgWaitingForFirstActionTime=" + avgWaitingForFirstActionTime +
                '}';
    }

}
