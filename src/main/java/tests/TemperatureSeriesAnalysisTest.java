package tests;

import ua.edu.ucu.tempseries.TemperatureSeriesAnalysis;

public class TemperatureSeriesAnalysisTest {
    public TemperatureSeriesAnalysisTest() {
        TemperatureSeriesAnalysis temperature = new TemperatureSeriesAnalysis();
        double[] arr = new double[]{7.93, 3.12, 7.15, 43.235};
        temperature.addTemps(arr);

        System.out.println(temperature.summaryStatistics());

    }
}
