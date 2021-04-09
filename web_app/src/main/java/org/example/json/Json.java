package org.example.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.concurrent.atomic.AtomicInteger;

public class Json {

    @JsonProperty("Count")
    AtomicInteger resCount;

    @JsonProperty("Task")
    String task;

    @JsonProperty("Result")
    String resultStr;


    public Json(String stroka, String stringReverse, AtomicInteger count)
    {
        resultStr=stroka;
        task=stringReverse;
        resCount=count;
    }

}
