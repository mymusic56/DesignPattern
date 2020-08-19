package com.zsj.designpattern.demo.apianalysis.data;

public class RequestInfo {
    private String apiName;
    private long requestTime;
    private double responseTime;

    public RequestInfo(String apiName, long requestTime, double responseTime) {
        this.apiName = apiName;
        this.requestTime = requestTime;
        this.responseTime = responseTime;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public long getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(long requestTime) {
        this.requestTime = requestTime;
    }

    public double getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(double responseTime) {
        this.responseTime = responseTime;
    }
}
