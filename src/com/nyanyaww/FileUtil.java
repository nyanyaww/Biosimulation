package com.nyanyaww;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;

/**
 * @author nyanyaww
 * @program Biosimulation
 * @description 文件操作
 * @create 2019-07-14 22:56
 **/
public class FileUtil {
    /**
     * 写文件到.Json
     *
     * @param filePath
     * @param sets
     * @throws IOException
     */
    public static void writeFile(String filePath, String sets)
            throws IOException {
        FileWriter fw = new FileWriter(filePath);
        PrintWriter out = new PrintWriter(fw);
        out.write(sets);
        out.println();
        fw.close();
        out.close();
    }

    /**
     * 读Json文件
     *
     * @param path
     * @return
     */
    public static Object ReadFile(String path) {
        File file = new File(path);
        BufferedReader reader = null;
        String laststr = "";
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                laststr = laststr + tempString;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return JSON.parse(laststr);
    }

    public static void main(String[] args) {
//        // 返回的结果
//        JSONObject result = new JSONObject();
//
//        result.put("studentMap", "testStuednt");
//
//
//        result.put("pointTable", "pointTableJsonObject");


        JSONObject jsonObject = (JSONObject) ReadFile("./resource/test.json");
//        System.out.print(jsonObject);
        if (jsonObject.get("ww") != null) {
            System.out.print("存在");

        } else {
            System.out.print("不存在");
            jsonObject.put("ww", "124311231244");
        }


        try {
            writeFile("./resource/test.json", jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
