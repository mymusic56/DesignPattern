package com.zsj.designpattern.apianalysis.storage.impl;

import com.zsj.designpattern.demo.apianalysis.data.RequestInfo;
import com.zsj.designpattern.demo.apianalysis.storage.MetricsStorage;

import java.util.List;
import java.util.Map;

public class RedisMetricsStorage implements MetricsStorage {
    @Override
    public void saveRequest(RequestInfo requestInfo) {

    }

    @Override
    public Map<String, List<RequestInfo>> listRequestInfo(long startTime, long endTime) {
        return null;
    }

    @Override
    public List<RequestInfo> listRequestInfoByApiKey(String api, long startTime, long endTime) {
        return null;
    }
}
