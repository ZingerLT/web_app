package org.example.service;

import org.apache.log4j.Logger;
import org.example.cache.Cache;
import org.example.exception.InputException;
import org.example.exception.LenghtException;
import org.example.exception.ServerException;
import org.springframework.beans.factory.annotation.Autowired;

public class StringReverse {

    public static final Logger log = Logger.getLogger(StringReverse.class);

    @Autowired

    public static String Reversing(String str) throws InputException, ServerException, LenghtException {
        log.debug("Start");
        if(str.trim().length() == 0)
        {
            log.error("String is empty!");
            throw new InputException("String is empty!");
        }
        if(str.trim().length()>100)
        {
            log.error("str > 100");
            throw new ServerException("String is more then 100 symbols");
        }
        //else
        //{
            //return new StringBuilder(str).reverse().toString();
        //}
        String answer = new String();
        Cache cache= new Cache();
        if(cache.getAnswer(str)==null)
        {
            answer=new StringBuilder(str).reverse().toString();
            cache.putAnswer(str, answer);
            log.info("Put in cache!");
        }
        else
        {
            cache.getAnswer(str);
            log.info("Get from cache!");
        }
        return answer;
    }

}