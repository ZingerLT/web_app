package org.example.cache;

import org.apache.log4j.Logger;
import org.example.config.SetGets;
import org.example.service.StringReverse;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    public static final Logger log = Logger.getLogger(StringReverse.class);
    private final Map<SetGets, String> CacheMap= new HashMap<SetGets, String>();

    public String getAnswer(SetGets setGets) {
        String answer = CacheMap.get(setGets);
        if (answer == null) {
            return answer;
        }
        log.info("Received answer" + " " + answer);
        return answer;
    }
    public void putAnswer(SetGets setGets, String answer)
    {
        CacheMap.put(setGets,answer);
        log.info("Put in cache"+" "+answer);
    }
}
