package com.example.phoenix_01.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class SortJson {

    public static JSONArray sortFast(JSONObject jsonObject) {

        JSONArray tempContent = jsonObject.getJSONArray("content");
        JSONObject order = jsonObject.getJSONObject("order");
        JSONArray outPut = new JSONArray();
        for(int i=0;i<tempContent.size();i++){
            JSONObject tempObject_a = (JSONObject) tempContent.get(i);
            /*创建对象时候true使得内部顺序按照放入顺序*/
            JSONObject temp_a =new JSONObject(true);
            for(int j=0;j<order.size();j++){
                temp_a.put(order.getString(j+""),tempObject_a.get(order.getString(j+"")));
            }
            outPut.add(temp_a);
        }
        System.out.println("1::"+outPut);
        return outPut;
    }




    public static void main(String[] s){
        JSONObject testObject1 = new AcquireJson().jsonRead();
        System.out.println(sortFast(testObject1));
    }


}
