import java.security.InvalidParameterException;

public class Process {

//    private String name;
    private final int arrivalTime;
    private final int timeNeeded;
    private int timeLeft;
    private boolean isDone = false;

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
        else if (timeLeft == 0)
            isDone = true;
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

    public boolean getIsDone() {
        return isDone;
    }
}
