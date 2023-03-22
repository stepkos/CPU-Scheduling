import algorithms.ExecutableWithStatistic;
import algorithms.FCFS;
import algorithms.RR;
import algorithms.SJF;
import process.ProcessList;
import process.ProcessesGenerator;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        ProcessesGenerator processesGenerator = new ProcessesGenerator(150000, 1, 20);
//        List<ExecutableWithStatistic> algorithms = Arrays.asList(
//                new FCFS(processesGenerator.generateProcessList(20000, 321)),
//                new SJF(processesGenerator.generateProcessList(20000, 321)),
//                new RR(processesGenerator.generateProcessList(20000, 321), 12)
//        );
//
//        algorithms.forEach(algorithm ->  {
//            algorithm.execute();
//            System.out.println(algorithm.getStatistic());
//        });


        ProcessesGenerator pg = new ProcessesGenerator(150, 1, 20);
        pg.generateProcessList(10, 555).printAll();


        // TODO stasystyki o liscie procesow
        // - jaka srednia dlugosc
        // - ile srednich, krotkich, dlugich


    }
}
