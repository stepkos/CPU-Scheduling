import java.security.InvalidParameterException;

public class Process {
    private final int arrivalTime;
    private final int timeTotal;
    private int timeLeft;

    public Process(int arrivalTime, int timeTotal) {
        this.arrivalTime = arrivalTime;
        this.timeTotal = timeTotal;
        this.timeLeft = timeTotal;
    }

    public void execute(int time) {
        if (time > timeLeft || time < 1)
            throw new InvalidParameterException("Incorrect time value");
        timeLeft -= time;
    }

    public boolean isDone() {
        return timeLeft == 0;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getTimeTotal() {
        return timeTotal;
    }

    public int getTimeLeft() {
        return timeLeft;
    }

    @Override
    public String toString() {
        return "Process{" +
                "arrivalTime=" + arrivalTime +
                ", timeTotal=" + timeTotal +
                ", timeLeft=" + timeLeft +
                '}';
    }

}
