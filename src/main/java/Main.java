import algorithms.FCFS;
import process.Process;
import process.ProcessList;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ProcessList processList = new ProcessList(20, 123);
        processList.printAll();
        processList.getExistsAndNotDone(10).printAll();

//        FCFS fcfs = new FCFS(list);
//        fcfs.execute();


    }
}
