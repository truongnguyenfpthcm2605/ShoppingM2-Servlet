package com.m2m.shopping.Service;

public interface AESService {
    public void setMainKey(String mainKey);
    public String deCrypt(String toEncrypt , String secret);
    public String enCrypt(String toDecrypt , String secret);

}
