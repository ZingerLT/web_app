package org.example.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Json {

    @JsonProperty("Task")
    String task;

    @JsonProperty("Result")
    String resultStr;


    public Json(String stroka,String stringReverse)
    {
        resultStr=stroka;
        task=stringReverse;
    }
    public Json(String stroka)
    {
        task=stroka;
    }


}
