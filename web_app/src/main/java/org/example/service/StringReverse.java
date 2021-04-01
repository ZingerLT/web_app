package org.example.service;

import org.apache.log4j.Logger;
import org.example.cache.Cache;
import org.example.config.SetGets;
import org.example.exception.InputException;
import org.example.exception.LenghtException;
import org.example.exception.ServerException;
import org.springframework.beans.factory.annotation.Autowired;

public class StringReverse {

    public static final Logger log = Logger.getLogger(StringReverse.class);
    @Autowired
    private static Cache cache;

    public StringReverse(){

    }

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
        SetGets obj=new SetGets(str);
        if(cache.getAnswer(obj)==null)
        {
            log.error("Put in cache!");
            cache.putAnswer(obj, answer);
        }
        else
        {
            log.error("Get from cache!");
            answer=new StringBuilder(str).reverse().toString();
            cache.getAnswer(obj);
        }
        return answer;

    }


}