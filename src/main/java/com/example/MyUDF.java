package com.example;

import org.apache.commons.lang3.RandomUtils;
import org.apache.flink.metrics.MetricGroup;
import org.apache.flink.table.functions.FunctionContext;
import org.apache.flink.table.functions.ScalarFunction;

public class MyUDF extends ScalarFunction {
    private static final String ALL_PATTERN = "*";

    private MetricGroup metricGroup;

    private String jobParameter;

    public void open(FunctionContext context) {
        this.jobParameter = context.getJobParameter("hello", "world");
        this.metricGroup = context.getMetricGroup();
    }

    public boolean eval(String value, String pattern) {
        try {
            if (value == null || pattern == null)
                return false;
//            return (pattern.equals("*") || value.equals(pattern) || Pattern.matches(pattern, value));
            Thread.sleep(RandomUtils.nextInt(1,100));
            return value.startsWith("udf");
        }catch (Exception e){
        } finally {

        }
        return false;
    }
}
