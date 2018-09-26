package com.example.phoenix_01.service;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONType;
import com.example.phoenix_01.util.AcquireJson;
import com.example.phoenix_01.util.CDLImpl;
import com.example.phoenix_01.util.SortJson;
import com.example.phoenix_01.util.SortUtils;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;

import java.io.*;




/**
 * 我们的数据为Json格式，需要转换为Csv给Phoenix
 * @author
 * @date 9/25
 */

public class JsonToCsv {
    /**
     * 工具方法：将json数组的字符串转变为csv字符串
     * @param jsonString json格式的字符串
     * @return csv格式的字符串
     * @throws JSONException
     */
    public static String json2Csv(String jsonString) throws JSONException {
        System.out.println("3::"+jsonString);
        org.json.JSONArray jsonArray = new org.json.JSONArray(jsonString);

        System.out.println("4::"+jsonArray);
        String csvString = CDLImpl.toString(jsonArray);
        return csvString;
    }

    /**
     * 写入csv
     * @param jsonObject
     */
    public static void writeCsv(JSONObject jsonObject){

        JSONArray temp = SortJson.sortFast(jsonObject);

        /**
         * temp这里的排序与给定json文件的保持一致
         * 这里说明temp(JsonArray)以及AcquireJson().jsonRead()输出(jsonObject)均有序
         * 编写的排序方法需要对temp执行，排序依据为order
         */

        File file = new File("./src/test/TestData/test.csv");
        try {
            /*具体将jsonArray写入csv*/
            System.out.println("2::"+temp.toString());
            FileUtils.writeStringToFile(file, SortUtils.sort(jsonObject,"/"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        writeCsv(new AcquireJson().jsonRead());
    }
}
