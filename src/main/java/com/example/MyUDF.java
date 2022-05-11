package com.example;

import org.apache.flink.table.functions.ScalarFunction;

public class MyUDF extends ScalarFunction {
    public boolean eval(String value){
        if(value == null || value.length() == 0){
            return false;
        }
        if(value.startsWith("udf")){
            return true;
        }
        return false;
    }
}
