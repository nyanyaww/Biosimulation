package com.nyanyaww;

import com.alibaba.fastjson.JSONObject;



/**
 * @author nyanyaww
 * @program Biosimulation
 * @description 程序的入口
 * @create 2019-07-14 22:09
 **/
public class Application {

    public void testJson() {
        JSONObject object = new JSONObject();
        object.put("hello", 11);
        String a = "casadqwe";
        char[] c = new char[10];
        c[0] = '1';
        object.put("a", a);
        object.put("c", c);
        System.out.print(object);
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.testJson();
    }

}
