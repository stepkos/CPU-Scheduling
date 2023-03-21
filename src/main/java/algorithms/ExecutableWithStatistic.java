package algorithms;

import statistics.Statistic;

public interface ExecutableWithStatistic {
    void execute();
    Statistic getStatistic();

}
