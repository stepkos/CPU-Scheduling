import algorithms.FCFS;
import algorithms.RR;
import algorithms.SJF;
import process.ProcessList;

public class Main {
    public static void main(String[] args) {

        ProcessList processList1 = new ProcessList(2000, 123);
        FCFS fcfs = new FCFS(processList1);
        fcfs.execute();

        ProcessList processList2 = new ProcessList(2000, 123);
        SJF sjf = new SJF(processList2);
        sjf.execute();

        ProcessList processList3 = new ProcessList(2000, 123);
        RR rr = new RR(processList3);
        rr.execute(12);


        // TODO ide czasu do rozpoczecia lub od statniego wykonania

        // TODO stasystyki o liscie procesow
        // - jaka srednia dlugosc
        // - ile srednich, krotkich, dlugich


    }
}
