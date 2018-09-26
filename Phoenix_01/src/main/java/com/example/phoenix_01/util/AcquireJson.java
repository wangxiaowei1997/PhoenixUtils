package com.example.phoenix_01.util;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.Feature;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class AcquireJson {

    public JSONObject jsonRead(){
        File file=new File("src/test/TestData/test_01.json");
        String content ="";
        try {
            content= FileUtils.readFileToString(file,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(content);
        JSONObject jsonObject= JSONObject.parseObject(content,Feature.OrderedField);
        return  jsonObject;

    }

    public static void main(String[] args) {
        AcquireJson test = new AcquireJson();
        test.jsonRead();
    }
}
