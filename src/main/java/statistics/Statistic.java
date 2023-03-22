package statistics;

public record Statistic(String name, int processAmount, int changeContentAmount, int executionTime,
        int breakTime, int avgWaitingTime, int maxWaitingTime, int avgWaitingForFirstActionTime) {

    @Override
    public String toString() {
        return "Statistic{" +
                "name='" + name + '\'' +
                ", processAmount=" + processAmount +
                ", changeContentAmount=" + changeContentAmount +
                ", executionTime=" + executionTime +
                ", breakTime=" + breakTime +
                ", avgWaitingTime=" + avgWaitingTime +
                ", maxWaitingTime=" + maxWaitingTime +
                ", avgWaitingForFirstActionTime=" + avgWaitingForFirstActionTime +
                '}';
    }

}
