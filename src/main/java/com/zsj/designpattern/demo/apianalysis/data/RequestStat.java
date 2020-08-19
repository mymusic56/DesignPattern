package com.zsj.designpattern.demo.apianalysis.data;

public class RequestStat {
    private double maxRequestTime;
    private double minRequestTime;
    private double avgRequestTime;
    private double p999ResponseTime;
    private double p99ResponseTime;
    private long count;
    private long tps;

    public double getMaxRequestTime() {
        return maxRequestTime;
    }

    public void setMaxRequestTime(double maxRequestTime) {
        this.maxRequestTime = maxRequestTime;
    }

    public double getMinRequestTime() {
        return minRequestTime;
    }

    public void setMinRequestTime(double minRequestTime) {
        this.minRequestTime = minRequestTime;
    }

    public double getAvgRequestTime() {
        return avgRequestTime;
    }

    public void setAvgRequestTime(double avgRequestTime) {
        this.avgRequestTime = avgRequestTime;
    }

    public double getP999ResponseTime() {
        return p999ResponseTime;
    }

    public void setP999ResponseTime(double p999ResponseTime) {
        this.p999ResponseTime = p999ResponseTime;
    }

    public double getP99ResponseTime() {
        return p99ResponseTime;
    }

    public void setP99ResponseTime(double p99ResponseTime) {
        this.p99ResponseTime = p99ResponseTime;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getTps() {
        return tps;
    }

    public void setTps(long tps) {
        this.tps = tps;
    }
}
