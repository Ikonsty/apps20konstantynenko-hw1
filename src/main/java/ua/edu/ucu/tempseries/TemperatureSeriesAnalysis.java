package ua.edu.ucu.tempseries;

import dynamList.DynamicList;

import java.util.Arrays;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    private double[] temperature;
    private int len;
    private double sum;
    private int actualLen;

    public TemperatureSeriesAnalysis() {
        this.temperature = new double[1];
        this.len = 0;
        this.actualLen = 1;
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        for (double temperatureSerie : temperatureSeries) {
            if (temperatureSerie < -273) {
                throw new InputMismatchException("Temperature is too low!");
            }
            this.sum += temperatureSerie;
        }
        this.len = temperatureSeries.length;
        this.actualLen = temperatureSeries.length;
        this.temperature = temperatureSeries;
        Arrays.sort(this.temperature);
    }

    public double average() {
        if(this.len == 0) {
            throw new IllegalArgumentException("Temperature series is empty");
        }
        return this.sum/this.len;
    }

    public double deviation() {
        if(this.len == 0) {
            throw new IllegalArgumentException("Temperature series is empty");
        }

        double standardDeviation = 0.0;
        double mean = this.average();
        for(double num: this.temperature) { //for num in temperature
            standardDeviation += Math.pow(num - mean, 2);
        }
        return Math.sqrt(standardDeviation/this.len);
    }

    public double min() {
        if(this.len == 0) {
            throw new IllegalArgumentException("Temperature series is empty");
        }

        return this.temperature[0];
    }

    public double max() {
        if(this.len == 0) {
            throw new IllegalArgumentException("Temperature series is empty");
        }

        return this.temperature[this.len - 1];
    }

    public double findTempClosestToZero() {
        if(this.len == 0) {
            throw new IllegalArgumentException("Temperature series is empty");
        }

        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue) {
        if(this.len == 0) {
            throw new IllegalArgumentException("Temperature series is empty");
        }

        if(tempValue < this.temperature[0]) {
            return this.temperature[0];
        }
        if(tempValue > this.temperature[this.len - 1]) {
            return this.temperature[this.len - 1];
        }

        int l = 0;
        int h = this.len;
        double diff = Integer.MAX_VALUE, val = this.temperature[0];
        while(l <= h)
        {
            int mid = l + (h - l) / 2;
            if(Math.abs(tempValue - this.temperature[mid]) < diff)
            {
                diff = Math.abs(tempValue - this.temperature[mid]);
                val = this.temperature[mid];
            }
            if(this.temperature[mid] < tempValue) {
                l = mid + 1;
            }
            else {
                h = mid - 1;
            }
        }
        return val;
    }

    public double[] convert(DynamicList lst) {
        double[] result = new double[lst.getLen()];
        for(int i = 0; i < lst.getLen(); i++) {
            result[i] = lst.getVal(i);
        }
        return result;
    }

    public double[] findTempsLessThen(double tempValue) {
        if(this.len == 0) {
            throw new IllegalArgumentException("Temperature series is empty");
        }
        DynamicList lessNumbers = new DynamicList();
        for(int i = 0; i < this.len && this.temperature[i] < tempValue; i++) {
            lessNumbers.addNew(this.temperature[i]);
        }

        return convert(lessNumbers);
    }

    public double[] findTempsGreaterThen(double tempValue) {
        if(this.len == 0) {
            throw new IllegalArgumentException("Temperature series is empty");
        }
        DynamicList moreNumbers = new DynamicList();
        for(int i = this.len; i > 0 && this.temperature[i] > tempValue; i--) {
            moreNumbers.addNew(this.temperature[i]);
        }

        return convert(moreNumbers);
    }

    public TempSummaryStatistics summaryStatistics() {
        if(this.len == 0) {
            throw new IllegalArgumentException("Temperature series is empty");
        }

        return new TempSummaryStatistics(average(), deviation(), min(), max());
    }

    public void createLargerArray(){
        double[] tempArr = new double[this.actualLen * 2];
        for(int i = 0; i < this.len; i++) {
            tempArr[i] = this.temperature[i];
        }
        this.actualLen *= 2;
        this.temperature = tempArr;
    }

    public int addTemps(double... temps) {
        while (temps.length > this.actualLen - this.len) {
            createLargerArray();
        }
        this.len += temps.length;
        return 0;
    }
}
