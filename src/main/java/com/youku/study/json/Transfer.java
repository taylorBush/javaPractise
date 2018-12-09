package com.youku.study.json;

/**
 * @author taylor
 * @date 2018/12/4
 */

import com.google.common.collect.Lists;
import lombok.Data;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/***
 * JSON 字符串 与 java 对象的转换
 *
 * 1. 把java 对象列表转换为json对象数组，并转为字符串
 *
 *     JSONArray array = JSONArray.fromObject(list);
 *     String jsonstr = array.toString();
 *
 *
 *
 * 2. 把java对象转换成json对象，并转化为字符串
 *
 *   JSONObject object = JSONObject.fromObject(user);
 *   Log4jInit.ysulogger.debug(object.toString());
 *
 *
 *
 * 3.把JSON字符串转换为JAVA 对象数组
 *   JSONArray json = JSONArray.fromObject(userStr);//userStr是json字符串
 *   List<User> users= (List<User>)JSONArray.toCollection(json, User.class);
 *
 *
 * 4.把JSON字符串转换为JAVA 对象
 *
 *
 *
 * 　　JSONObject jsonobject = JSONObject.fromObject(jsonStr);
 * 　　User user= (User)JSONObject.toBean(object,User.class);
 */
public class Transfer {
    public static void main(String[] args) {
        Transfer transfer  = new Transfer();
        List<Material> materialList = transfer.getList(false);
        long total = materialList.stream()
            .map(material -> material.getName())
            .distinct()
            .peek(System.out::println)
            .count();
        System.out.println("total: " + total);

        List<String> nameList = materialList.stream()
            .map(material -> material.getName())
            .collect(Collectors.toList());

        Map<String, Long> map = nameList.stream().collect(Collectors.groupingBy(name -> name, Collectors.counting()));
        map.forEach((k, v) -> {
            if (v > 1) {
                System.out.println(k + " : " + v);
            }
        });
    }

    public List<Material> getList(boolean download) {
        List<Material> materialList = Lists.newArrayList();
        String path = "/Users/taylorliang/study/javaPractise/src/main/resources/queryMaterial.result.json";
        JSONArray jsonArray = null;
        try {
            String input = FileUtils.readFileToString(new File(path), "UTF-8");
            JSONObject jsonObject = JSONObject.fromObject(input);
            if (jsonObject != null) {
                jsonArray = jsonObject.getJSONArray("module");
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsonArray = null;
        }
        if (jsonArray != null) {
            int count = 0;
            for (int i = 0; i < jsonArray.size(); i++) {
                Material material= new Material();
                JSONObject jsonObject = (JSONObject)jsonArray.get(i);
                String name = jsonObject.getString("name");
                System.out.println("name: " + name);
                material.setName(name);
                String logoUrlStr = jsonObject.getString("logoUrl");
                logoUrlStr = "https:" + logoUrlStr;
                System.out.println("logoUrl: " + logoUrlStr);
                try {
                    material.setLogoUrl(logoUrlStr);
                    if (download) {
                        File logoFile = new File("/Users/taylorliang/Downloads/material/" + name + ".png");
                        URL logoUrl = new URL(logoUrlStr);
                        FileUtils.copyURLToFile(logoUrl, logoFile);
                    }


                    JSONObject extraInfo = jsonObject.getJSONObject("extraInfo");
                    String downloadUrlStr = extraInfo.getString("downloadUrl");
                    material.setDownloadUrl(downloadUrlStr);
                    System.out.println("downloadUrl: " + downloadUrlStr);
                    materialList.add(material);

                    if (download) {
                        File downloadFile = new File("/Users/taylorliang/Downloads/material/" + name + ".zip");
                        URL downloadUrl = new URL(downloadUrlStr);
                        FileUtils.copyURLToFile(downloadUrl, downloadFile);
                    }


                    System.out.println("count: " + ++count);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return materialList;
    }

    @Data
    class Material {
        String name;
        String logoUrl;
        String downloadUrl;
    }
}
