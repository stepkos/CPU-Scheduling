import algorithms.ExecutableWithStatistic;
import algorithms.FCFS;
import algorithms.RR;
import algorithms.SJF;
import process.ProcessList;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<ExecutableWithStatistic> algorithms = Arrays.asList(
                new FCFS(new ProcessList(20000, 321)),
                new SJF(new ProcessList(20000, 321)),
                new RR(new ProcessList(20000, 321), 12)
        );

        algorithms.forEach(algorithm ->  {
            algorithm.execute();
            System.out.println(algorithm.getStatistic());
        });


        // TODO ide czasu do rozpoczecia lub od statniego wykonania

        // TODO stasystyki o liscie procesow
        // - jaka srednia dlugosc
        // - ile srednich, krotkich, dlugich


    }
}
