package com.m2m.shopping.Service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.m2m.shopping.Service.ApiService;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiServiceImpl implements ApiService {
    private static final  String GET = "GET";
    private static final  String POST = "POST";
    private static final  String PUT = "PUT";
    private static final  String DELETE = "DELETE";
    private static ObjectMapper objectMapper = new ObjectMapper();

    private static JsonNode request(String method, String url, Object data,Object...args) {
        try {
            URL urls = new URL( replaceUrl(url,args)); // lấy url + / tham số nếu có
            HttpURLConnection conn = (HttpURLConnection) urls.openConnection();
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestMethod(method);
            if(method.equalsIgnoreCase(POST) || method.equalsIgnoreCase(PUT)){
                conn.setDoOutput(true);
                objectMapper.writeValue(conn.getOutputStream(), data);
            }
            if(conn.getResponseCode()==HttpURLConnection.HTTP_OK){
                return objectMapper.readTree(conn.getInputStream());
            }
            conn.disconnect();
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public JsonNode get(String url, Object data, Object... args) {
        return request(GET,url,data,args);
    }

    @Override
    public JsonNode post(String url, Object data, Object... args) {
        return request(POST,url,data,args);
    }

    @Override
    public JsonNode put(String url, Object data, Object... args) {
        return request(POST,url,data,args);
    }

    @Override
    public void delete(String url, Object id) {
        request(DELETE,url,null,id);
    }

    public static String  replaceUrl(String url , Object...args){
        StringBuilder str = new StringBuilder(url);
        for (Object ob : args) {
            str.append("/").append(ob);
        }
        return str.toString();
    }


}
