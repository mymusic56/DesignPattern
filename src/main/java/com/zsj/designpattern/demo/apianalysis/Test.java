package com.zsj.designpattern.demo.apianalysis;

import com.zsj.designpattern.demo.apianalysis.data.RequestInfo;
import com.zsj.designpattern.demo.apianalysis.reporter.Reporter;
import com.zsj.designpattern.demo.apianalysis.reporter.impl.ConsoleReporter;
import com.zsj.designpattern.demo.apianalysis.reporter.impl.EmailReporter;
import com.zsj.designpattern.demo.apianalysis.storage.MetricsStorage;
import com.zsj.designpattern.demo.apianalysis.storage.impl.RedisMetricsStorage;

public class Test {
    public static void main(String[] args) {
        MetricsStorage storage = new RedisMetricsStorage();

        ConsoleReporter consoleReporter = new ConsoleReporter(storage);
        consoleReporter.startRepeatedReport(60, 60);

        EmailReporter emailReporter = new EmailReporter(storage);
        emailReporter.addToAddress("zhangsan@qq.com");
        emailReporter.startDailyReport();

        MetricsApi api = new MetricsApi(storage);
        api.recordRequest(new RequestInfo("login", 11234, 11));
        api.recordRequest(new RequestInfo("login", 11337, 11));
        api.recordRequest(new RequestInfo("register", 11337, 2));

    }
}
