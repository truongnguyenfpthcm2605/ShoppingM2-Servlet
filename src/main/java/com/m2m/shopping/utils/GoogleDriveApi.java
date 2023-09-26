package com.m2m.shopping.utils;


import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.google.api.client.http.FileContent;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class GoogleDriveApi {

    private static final String APPLICATION_NAME = "MyGoogleDriveApp";
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static final List<String> SCOPES = Arrays.asList(DriveScopes.DRIVE_FILE);

    private Drive driveService;

    public GoogleDriveApi() throws Exception {
        HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        GoogleClientSecrets clientSecrets = loadClientSecrets();
        Credential credential = authorize(clientSecrets);
        this.driveService = createDriveService(httpTransport, credential);
    }

    private GoogleClientSecrets loadClientSecrets() {
        try {
            InputStream in = getClass().getResourceAsStream("/json/apidrive.json");
            GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
            return clientSecrets;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Credential authorize(GoogleClientSecrets clientSecrets) throws Exception {
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                GoogleNetHttpTransport.newTrustedTransport(), JSON_FACTORY, clientSecrets, SCOPES)
                .setAccessType("offline")
                .build();

        try {
            Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
            return credential;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private Drive createDriveService(HttpTransport httpTransport, Credential credential) {
        return new Drive.Builder(httpTransport, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public void uploadImage(java.io.File imageFile, String imageName) throws IOException {
        File fileMetadata = new File();
        fileMetadata.setName(imageName);
        FileContent mediaContent = new FileContent("image/jpeg", imageFile);
        File file = driveService.files().create(fileMetadata, mediaContent).setFields("id").execute();
        System.out.println("Uploaded File ID: " + file.getId());
    }

    public void listImages() throws IOException {
        FileList result = driveService.files().list()
                .setQ("mimeType='image/jpeg'")
                .execute();

        for (com.google.api.services.drive.model.File file : result.getFiles()) {
            System.out.println("File Name: " + file.getName());
            System.out.println("File ID: " + file.getId());
        }
    }
    public java.io.File downloadImage(String imageName) throws IOException {
        FileList result = driveService.files().list()
                .setQ("name='" + imageName + "'")
                .execute();

        if (result.getFiles().isEmpty()) {
            System.err.println("File not found: " + imageName);
            return null;
        }
        String fileId = result.getFiles().get(0).getId();
        java.io.File downloadedFile = new java.io.File(imageName);

        OutputStream outputStream = new FileOutputStream(downloadedFile);
        driveService.files().get(fileId)
                .executeMediaAndDownloadTo(outputStream);
        outputStream.close();

        return downloadedFile;
    }


    public static void main(String[] args) {
        try {
            GoogleDriveApi driveService = new GoogleDriveApi();

            // Đường dẫn đến tệp ảnh bạn muốn tải lên
            String imagePath = "D:\\ServletM2M\\hinh-nen-4k-cho-may-tinh.jpg";

            // Tên tệp ảnh trên Google Drive
            String imageName = System.currentTimeMillis()+ "natural";

            java.io.File imageFile = new java.io.File(imageName);

            if (imageFile.exists()) {
                driveService.uploadImage(imageFile, imageName);
            } else {
                // Tạo một tệp ảnh trống và tải lên nếu không tìm thấy tệp ảnh
                imageFile.createNewFile();
                driveService.uploadImage(imageFile, imageName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}

