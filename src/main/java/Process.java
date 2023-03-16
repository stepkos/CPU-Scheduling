import java.security.InvalidParameterException;

public class Process {

//    private String name;
    private final int arrivalTime;
    private final int timeNeeded;
    private int timeLeft;

    public Process(int arrivalTime, int timeNeeded) {
        this.arrivalTime = arrivalTime;
        this.timeNeeded = timeNeeded;
        this.timeLeft = timeNeeded;
    }

//    public boolean exists(int currentTime) {
//        return currentTime >= arrivalTime;
//    }

    public void execute(int time) {
        timeLeft -= time;
        if (timeLeft < 0 || time < 1)
            throw new InvalidParameterException("Incorrect time value");
    }

    public boolean isDone() {
        return timeLeft == 0;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getTimeNeeded() {
        return timeNeeded;
    }

    public int getTimeLeft() {
        return timeLeft;
    }

}
