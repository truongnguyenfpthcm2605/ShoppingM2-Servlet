package com.m2m.shopping.utils;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GoogleDriveApi {

    private static final String APPLICATION_NAME = "MyGoogleDriveApp";
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static final List<String> SCOPES = Arrays.asList(DriveScopes.DRIVE_FILE);

    private Drive driveService;
    private String refreshToken;

    public GoogleDriveApi() {
        try {
            HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
            GoogleClientSecrets clientSecrets = loadClientSecrets();

            this.refreshToken = getRefreshTokenFromStorage();

            Credential credential;
            if (refreshToken != null) {
                credential = createCredentialWithRefreshToken(httpTransport, clientSecrets, refreshToken);
            } else {
                credential = authorize(clientSecrets);
            }
            this.driveService = createDriveService(httpTransport, credential);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
            Credential credential = new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
            return credential;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Credential createCredentialWithRefreshToken(HttpTransport httpTransport, GoogleClientSecrets clientSecrets, String refreshToken) {
        return new GoogleCredential.Builder()
                .setTransport(httpTransport)
                .setJsonFactory(JSON_FACTORY)
                .setClientSecrets(clientSecrets)
                .build()
                .setRefreshToken(refreshToken);
    }

    private Drive createDriveService(HttpTransport httpTransport, Credential credential) {
        return new Drive.Builder(httpTransport, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    private String getRefreshTokenFromStorage() {
        return "1//046Xw_Fslf0CTCgYIARAAGAQSNwF-L9IrA5dfEAbIdYEoo2LecbuqAhIBf9jb-Rk5GruFokKyxvtf-JJYAgX8r6pilEQobg6KyRQ";
    }

    public boolean uploadImageToFolder(java.io.File imageFile, String imageName, String folderName) {
        try {
            String folderId = findFolderIdByName(folderName);

            if (folderId == null) {
                System.err.println("Folder not found: " + folderName);
                return false;
            }
            File fileMetadata = new File();
            fileMetadata.setName(imageName);
            fileMetadata.setParents(Collections.singletonList(folderId)); // Đặt parentId cho thư mục
            FileContent mediaContent = new FileContent("image/jpeg", imageFile);
            File file = driveService.files().create(fileMetadata, mediaContent).setFields("id").execute();
            return !file.isEmpty();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<java.io.File> listImagesInFolder(String folderName) {
        try {
            // Tìm ID của thư mục cần lấy ảnh
            String folderId = findFolderIdByName(folderName);

            if (folderId == null) {
                System.err.println("Folder not found: " + folderName);
                return new ArrayList<>();
            }

            List<java.io.File> imageFiles = new ArrayList<>();

            FileList result = driveService.files().list()
                    .setQ("mimeType='image/jpeg' and '" + folderId + "' in parents")
                    .execute();

            for (com.google.api.services.drive.model.File file : result.getFiles()) {
                String fileId = file.getId();
                String fileName = file.getName();
                java.io.File localFile = downloadImage(fileName, fileId);
                imageFiles.add(localFile);
            }

            return imageFiles;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public java.io.File downloadImage(String imageName, String fileId) throws IOException {
        java.io.File downloadedFile = new java.io.File(imageName);
        OutputStream outputStream = new FileOutputStream(downloadedFile);
        driveService.files().get(fileId)
                .executeMediaAndDownloadTo(outputStream);
        outputStream.close();
        return downloadedFile;
    }

    private String findFolderIdByName(String folderName) throws IOException {
        FileList result = driveService.files().list()
                .setQ("mimeType='application/vnd.google-apps.folder' and name='" + folderName + "'")
                .execute();
        if (!result.getFiles().isEmpty()) {
            return result.getFiles().get(0).getId();
        }

        return null;
    }


    public java.io.File downloadImageFromFolder(String imageName, String folderName) {
        try {
            // Tìm ID của thư mục cần lấy ảnh
            String folderId = findFolderIdByName(folderName);

            if (folderId == null) {
                System.err.println("Folder not found: " + folderName);
                return null;
            }
            FileList result = driveService.files().list()
                    .setQ("name='" + imageName + "' and '" + folderId + "' in parents")
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean deleteImage(String imageName) {
        try {
            FileList result = driveService.files().list()
                    .setQ("name='" + imageName + "'")
                    .execute();

            if (!result.getFiles().isEmpty()) {
                String fileId = result.getFiles().get(0).getId();
                driveService.files().delete(fileId).execute();
                return true;
            }
        }catch (IOException e){
            return  false;
        }
        return false;
    }

}
