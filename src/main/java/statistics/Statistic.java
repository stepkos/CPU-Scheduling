package statistics;

public record Statistic(int processAmount, int changeContentAmount, int executionTime,
        int breakTime, int avgWaitingTime, int maxWaitingTime, int avgWaitingForFirstActionTime) {

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
