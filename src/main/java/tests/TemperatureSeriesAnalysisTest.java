package tests;

import ua.edu.ucu.tempseries.TemperatureSeriesAnalysis;

public class TemperatureSeriesAnalysisTest {
    public TemperatureSeriesAnalysisTest() {
        TemperatureSeriesAnalysis temp1 = new TemperatureSeriesAnalysis();
        double[] arr = new double[]{7.93, 3.12, 7.15, 43.235};
        temp1.addTemps(arr);

        System.out.println(temp1.summaryStatistics());

    }
}
