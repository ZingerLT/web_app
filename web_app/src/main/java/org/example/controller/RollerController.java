package org.example.controller;

import org.apache.log4j.Logger;
import org.example.exception.InputException;
import org.example.exception.LenghtException;
import org.example.exception.ServerException;
import org.example.json.Json;
import org.example.service.Counter;
import org.example.service.StringReverse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("task")

public class RollerController {

    @Autowired
    StringReverse stringReverse;
    @Autowired
    Counter count;

    private static final Logger log = Logger.getLogger(StringReverse.class);

    @GetMapping
    public Json Stringing(@RequestParam(value="string") String str) throws InputException, ServerException, LenghtException {
        log.info("Get Request param from URL");
        String stroka=stringReverse.reverse(str);
        Json obj = new Json(stroka,str,count.getCounter());
        log.info("Return task answer");
        return obj;
    }
}