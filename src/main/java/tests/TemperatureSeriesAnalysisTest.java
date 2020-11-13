package tests;

import ua.edu.ucu.tempseries.TemperatureSeriesAnalysis;

public class TemperatureSeriesAnalysisTest {
    public TemperatureSeriesAnalysisTest() {
//        Check empty temperature
        TemperatureSeriesAnalysis temperature = new TemperatureSeriesAnalysis();
        double[] arr = new double[]{7.93, 3.12, 7.15, 43.235};
        temperature.addTemps(arr);

        System.out.println("Average: " + temperature.average());
        System.out.println("Max: " + temperature.min());
        System.out.println("Deviation: " + temperature.deviation());
        System.out.println("Min: " + temperature.max());
        System.out.println(temperature.findTempClosestToZero());

        System.out.println(temperature.findTempsLessThen(8));
        System.out.println(temperature.findTempsGreaterThen(4));

        System.out.println(temperature.summaryStatistics());

    }
}
