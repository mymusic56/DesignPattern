package com.zsj.designpattern.demo.apianalysis;

import com.zsj.designpattern.demo.apianalysis.data.RequestInfo;
import com.zsj.designpattern.demo.apianalysis.storage.MetricsStorage;

public class MetricsApi {
    private MetricsStorage metricsStorage;

    public MetricsApi(MetricsStorage storage) {
        this.metricsStorage = storage;
    }

    public void recordRequest(RequestInfo requestInfo) {
        if (requestInfo == null || requestInfo.getApiName().isEmpty()) {
            return;
        }
        metricsStorage.saveRequest(requestInfo);
    }
}
