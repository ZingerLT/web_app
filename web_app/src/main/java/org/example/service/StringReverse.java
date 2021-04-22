package org.example.service;

import org.apache.log4j.Logger;
import org.example.cache.Cache;
import org.example.exception.InputException;
import org.example.exception.ServerException;
import org.example.json.Json;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@org.springframework.stereotype.Service
public class StringReverse implements Service<Json, Stream<String>> {

    public static final Logger log = Logger.getLogger(StringReverse.class);

    @Autowired
    private Counter counter;
    @Autowired
    private Cache cache;
    @Autowired
    private Json obj;
    private List<String> resultStr=new ArrayList<>();

    @Override
    public Json doService(Stream<String> stream) throws InputException, ServerException {
        counter.increment();
        String str=stream.collect(Collectors.toList()).get(0);
        checkValid(str);
        String stroka=getResult(str);
        int num=str.trim().length();
        resultStr.add(stroka);
        CountSize(num);
        obj.Out(str, stroka, counter.getCounter());
        return obj;
    }

    private void checkValid(String str) throws InputException, ServerException {
        if(str.trim().length() == 0) {
            log.error("String is empty!");
            throw new InputException("String is empty!");
        }
        if(str.trim().length()>100) {
            log.error("str > 100");
            throw new ServerException("String is more then 100 symbols");
        }
    }

    private String getResult(String str) {
        return getString(str, cache);
    }

    static String getString(String str, Cache cache) {
        String answer;
        if(cache.getAnswer(str)==null) {
            answer=new StringBuilder(str).reverse().toString();
            cache.putAnswer(str, answer);
        }
        else {
            answer= cache.getAnswer(str);
        }
        return answer;
    }

    private void CountSize(int num){
        cache.putLen(num);
        int num1=cache.getMaxLen();
        int num2=cache.getMinLen();
        obj.SetMax(num2);
        obj.SetMix(num1);
        float num3=cache.getAverage();
        obj.SetAverage(num3);
    }



    /*public String reverse(String str) throws InputException, ServerException, IOException {
        log.debug("Start");
        if(str.trim().length() == 0)
        {
            log.error("String is empty!");
            throw new InputException("String is empty!");
        }
        counter.increment();
        if(str.trim().length()>100)
        {
            log.error("str > 100");
            throw new ServerException("String is more then 100 symbols");
        }
        //else
        //{
            //return new StringBuilder(str).reverse().toString();
        //}
        String answer;
        if(cache.getAnswer(str)==null) {
            answer=new StringBuilder(str).reverse().toString();
            cache.putAnswer(str, answer);
        }
        else {
            answer= cache.getAnswer(str);
        }
        int num=str.trim().length();
        CountSize(num);

        return answer;
    }

    public void CountSize(int num){
        cache.putLen(num);
        int num1=cache.getMaxLen();
        int num2=cache.getMinLen();
        obj.SetMax(num2);
        obj.SetMix(num1);
        float num3=cache.getAverage();
        obj.SetAverage(num3);
    }*/

}