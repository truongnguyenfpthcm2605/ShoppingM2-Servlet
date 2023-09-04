package com.m2m.shopping.Service;

import com.fasterxml.jackson.databind.JsonNode;

public interface ApiService {

    JsonNode get(String url, Object response, Object... args);
    JsonNode post(String url, Object response, Object... args);

    JsonNode put(String url, Object response, Object... args);
    void delete(String url, Object id);

}
