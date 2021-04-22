package org.example.json;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class GetStr {

    private String str;

    public GetStr(String str){
        this.str=str;
    }
    public String getStr(){
        return str;
    }

}
