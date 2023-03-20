import algorithms.FCFS;
import process.Process;
import process.ProcessList;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ProcessList processList = new ProcessList(20, 123);
        FCFS fcfs = new FCFS(processList);
        fcfs.execute();


        // TODO ide czasu do rozpoczecia lub od statniego wykonania

        // TODO stasystyki o liscie procesow
        // - jaka srednia dlugosc
        // - ile srednich, krotkich, dlugich


    }
}
