package org.example.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class Json {

    @JsonProperty("Count")
    AtomicInteger resCount;
    @JsonProperty("Task")
    String task;
    @JsonProperty("Result")
    String resultStr;
    @JsonProperty("Max")
    int max;
    @JsonProperty("Min")
    int min;
    @JsonProperty("Average")
    float ave;

    /*public Json(String stroka, String stringReverse, AtomicInteger count)
    {
        resultStr=stroka;
        task=stringReverse;
        resCount=count;
    }*/
    public void Out(String task, String resultStr,AtomicInteger resCount)
    {
        this.resCount=resCount;
        this.task=task;
        this.resultStr=resultStr;
    }

    public void SetMax(int max){this.max=max;}

    public void SetMix(int min){this.min=min;}

    public void SetAverage(float ave){this.ave=ave;}

    public char[] GetInfo()
    {
        this.resCount=resCount;
        this.task=task;
        this.resultStr=resultStr;
        return new char[0];
    }
}
