package org.example.controller;

import org.apache.log4j.Logger;
import org.example.exception.LenghtException;
import org.example.json.Json;
import org.example.service.StringReverse;
import org.example.exception.InputException;
import org.example.exception.ServerException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("task")

public class RollerController {

    private static final Logger log = Logger.getLogger(StringReverse.class);

    @GetMapping
    public Json Stringing(@RequestParam(value="string") String str) throws InputException, ServerException, LenghtException {
        log.info("Get Request param from URL");
        String stroka=StringReverse.Reversing(str);
        Json obj = new Json(stroka,str);
        log.info("Return task answer");
        return obj;
        /*boolean hasValue;

        if(Constants.Constant_Map.get("String")==null)
        {
            Constants.Constant_Map.put("String", str);
            System.out.println(Constants.Constant_Map.get("String")+" --> set in cache!");
        }
        else
        {
            if(hasValue = Constants.Constant_Map.containsValue(stroka) == false)
            {
                Constants.Constant_Map.put("String", str);
                System.out.println(Constants.Constant_Map.get("String")+" --> set in cache!");
            }
            else
            {
                System.out.println(Constants.Constant_Map.get("String")+" --> get from cache!");
            }
        }

        /*if(Constants.Constant_Map.get(stroka)==null)
        {
            Constants.Constant_Map.put("String", str);
            System.out.println(Constants.Constant_Map.get("String")+" --> set in cache!");
        }
        else
        {
            System.out.println(Constants.Constant_Map.get("String")+" --> get from cache!");
        }
        if(Constants.Constant_Map.get("myData")==null)
        {
                Constants.Constant_Map.put("myData", "Data set in constant!");
                System.out.println(Constants.Constant_Map.get("myData")+" --> set in constant!");
        }
        else
        {
            System.out.println(Constants.Constant_Map.get("myData")+"--> get from constant!");
        }*/
    }
}