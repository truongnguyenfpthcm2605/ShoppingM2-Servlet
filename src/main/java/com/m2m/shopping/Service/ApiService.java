package com.m2m.shopping.Service;

import com.fasterxml.jackson.databind.JsonNode;

public interface ApiService {

    public JsonNode get(String url,Object response, Object...args);
    public JsonNode post(String url,Object response, Object...args);

    public JsonNode put(String url,Object response, Object...args);
    public void delete(String url, Object id);

}
