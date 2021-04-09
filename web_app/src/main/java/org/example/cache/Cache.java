package org.example.cache;

import org.apache.log4j.Logger;
import org.example.service.StringReverse;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

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
}
