package ua.edu.ucu.tempseries;

public final class TempSummaryStatistics {

    private final String avgTemp;
    private final String devTemp;
    private final String minTemp;
    private final String maxTemp;
    public TempSummaryStatistics(double avgTemp, double devTemp,
                                 double minTemp, double maxTemp) {
        this.avgTemp = String.valueOf(avgTemp);
        this.devTemp = String.valueOf(devTemp);
        this.minTemp = String.valueOf(minTemp);
        this.maxTemp = String.valueOf(maxTemp);
    }

    public void print() {
        String stats = "Average: " + this.avgTemp + "\n" + "Deviation: "
                + this.devTemp + "\n" + "Minimum: " + this.minTemp + "\n"
                + "Maximum: " + this.maxTemp + "\n";
        System.out.println(stats);
    }
}
