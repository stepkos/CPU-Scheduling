package process;

import java.security.InvalidParameterException;

public class Process {
    private final int id;
    private final int arrivalTime;
    private final int timeTotal;
    private int timeLeft;

    public Process(int id, int arrivalTime, int timeTotal) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.timeTotal = timeTotal;
        this.timeLeft = timeTotal;
    }

    public void execute(int time) {
        if (time > timeLeft || time < 1)
            throw new InvalidParameterException("Incorrect time value");
        timeLeft -= time;
    }

    public boolean exists(int time) {
        return time >= arrivalTime;
    }

    public boolean isDone() {
        return timeLeft == 0;
    }

    public int getId() {
        return id;
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
                "id=" + id +
                ", arrivalTime=" + arrivalTime +
                ", timeTotal=" + timeTotal +
                ", timeLeft=" + timeLeft +
                '}';
    }

}
