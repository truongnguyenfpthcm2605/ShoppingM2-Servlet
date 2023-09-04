package com.m2m.shopping.Service;

public interface AESService {
    void setMainKey(String mainKey);
    String deCrypt(String toEncrypt, String secret);
    String enCrypt(String toDecrypt, String secret);

}
