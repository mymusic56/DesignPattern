package com.zsj.designpattern.demo.apianalysis.storage;

import com.zsj.designpattern.demo.apianalysis.data.RequestInfo;

import java.util.List;
import java.util.Map;

public interface MetricsStorage {
    void saveRequest(RequestInfo requestInfo);

    Map<String, List<RequestInfo>> listRequestInfo(long startTime, long endTime);

    List<RequestInfo> listRequestInfoByApiKey(String api, long startTime, long endTime);
}
