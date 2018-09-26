package com.example.phoenix_01.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class SortUtils {


    /**
     *
     * @param jsonObject 读取的原始JsonObject对象，需要包含"content"和"order"
     * @param partLine 自定义分割线，可以为","或者"/"
     * @return  返回格式化的csv内容，可以直接写入文件
     */
    public static String sort(JSONObject jsonObject,String partLine) {
        JSONArray tempContent = jsonObject.getJSONArray("content");
        JSONObject order = jsonObject.getJSONObject("order");
        JSONArray outPut = new JSONArray();
        StringBuffer sb = new StringBuffer();
        for(int t=0;t<order.size();t++){
            sb.append(order.getString(""+t));
            if (t<order.size()-1){
                sb.append(partLine);
            }
        }
        sb.append('\n');
        for(int i=0;i<tempContent.size();i++){
            JSONObject tempObject_a = (JSONObject) tempContent.get(i);
            /*创建对象时候true使得内部顺序按照放入顺序*/
            JSONObject temp_a =new JSONObject(true);
            for(int j=0;j<order.size();j++){
                temp_a.put(order.getString(j+""),tempObject_a.get(order.getString(j+"")));
                if(tempObject_a.get(order.getString(j+"")) == null){
                    sb.append("");
                }else{
                    sb.append(tempObject_a.get(order.getString(j+"")));
                }
                if (j<order.size()-1){
                    sb.append(partLine);
                }

            }
            sb.append('\n');
            outPut.add(temp_a);
        }
        System.out.println("1::"+outPut);
        System.out.println("sb::\n"+sb);
        return sb.toString();
    }






    public static  void  main(String[] s){
        String temp = SortUtils.sort(new AcquireJson().jsonRead(),"/");

    }
}
