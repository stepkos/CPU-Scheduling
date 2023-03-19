import algorithms.FCFS;
import process.Process;
import process.ProcessList;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ProcessList processList = new ProcessList(20, 123);
        FCFS fcfs = new FCFS(processList);
        fcfs.execute();


    }
}
