package com.m2m.shopping.Service.Impl;

import com.m2m.shopping.utils.GoogleDriveApi;

import java.io.File;
import java.util.List;

public class GoogleDriveAPIImpl {

    GoogleDriveApi googleDriveApi = new GoogleDriveApi();

    public boolean uploadDrive(File file, String fileName,String folderName){
       return googleDriveApi.uploadImageToFolder(file,fileName,folderName);
    }

    public boolean deleteFileDrive(String fileName){
       return googleDriveApi.deleteImage(fileName);
    }

    public File getFileDrive(String fileName,String folderName){
        return googleDriveApi.downloadImageFromFolder(fileName,folderName);
    }

    public List<File> getListFile(String folderName){
        return googleDriveApi.listImagesInFolder( folderName);
    }
}
