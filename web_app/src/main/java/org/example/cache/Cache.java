package org.example.cache;

import org.apache.log4j.Logger;
import org.example.service.StringReverse;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Cache {
    public static final Logger log = Logger.getLogger(StringReverse.class);
    private final Map<String, String> CacheMap= new HashMap<>();

    public String getAnswer(String str) {
        String answer = CacheMap.get(str);
        log.info("Received answer" + " " + answer);
        return answer;
    }
    public void putAnswer(String str, String answer) {
        CacheMap.put(str,answer);
        log.info("Put in cache"+" "+answer);
    }

    ArrayList<Integer> length=new ArrayList<>();

    public void putLen(Integer num) {
        length.add(num);
    }
    public Integer getMaxLen() {
        Collections.sort(length);
        return length.get(0);
    }
    public Integer getMinLen() {
        Collections.sort(length);
        return length.get(length.size()-1);
    }
    public float getAverage(){
        float ave = 0;
        for(int i=0;i<length.size();i++)
        {
            ave+=length.get(i);
        }
        return ave/length.size();
    }
}
