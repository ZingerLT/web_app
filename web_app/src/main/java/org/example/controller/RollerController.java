package org.example.controller;

import org.apache.log4j.Logger;
import org.example.exception.InputException;
import org.example.exception.ServerException;
import org.example.json.GetStr;
import org.example.json.Json;
import org.example.service.Counter;
import org.example.service.Service;
import org.example.service.StringReverse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Stream;

@RestController
@RequestMapping("task")

public class RollerController {

    @Autowired
    StringReverse stringReverse;
    @Autowired
    Counter count;
    @Autowired
    Json obj;

    @Qualifier("stringReverse")
    @Autowired
    private Service<Json, Stream<String>> service;
    private static final Logger log = Logger.getLogger(StringReverse.class);


    @GetMapping
    public Json Stringing(@RequestParam(value = "string") String str) throws InputException, ServerException, IOException, InterruptedException {
        log.info("Get Request param from URL");
        //String stroka = stringReverse.reverse(str);
        //obj.Out(str, stroka, count.getCounter());
        //Json obj = new Json(stroka, str, count.getCounter());
        FileWriter writer = new FileWriter("file.txt", true);
        Json obj=service.doService(Stream.of(str));
        writer.write(String.valueOf(obj+"\n"));
        writer.close();
        log.info("Return task answer");
        return obj;
    }

    @PostMapping
    public Json Stringing(@RequestBody GetStr get) throws InputException, ServerException, IOException {
        Json obj=service.doService(Stream.of(get.getStr()));
        return obj;
    }
}