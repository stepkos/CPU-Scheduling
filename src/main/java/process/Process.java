package process;

import java.security.InvalidParameterException;

public class Process {
    private final int id;
    private final int arrivalTime;
    private final int totalTime;
    private int timeLeft;

    public Process(int id, int arrivalTime, int totalTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.totalTime = totalTime;
        this.timeLeft = totalTime;
    }

    public int execute() {
        int timeLeft = this.timeLeft;
        this.timeLeft = 0;
        return timeLeft;
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

    public int getTotalTime() {
        return totalTime;
    }

    public int getTimeLeft() {
        return timeLeft;
    }

    @Override
    public String toString() {
        return "Process{" +
                "id=" + id +
                ", arrivalTime=" + arrivalTime +
                ", totalTime=" + totalTime +
                ", timeLeft=" + timeLeft +
                '}';
    }

}
