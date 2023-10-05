package com.m2m.shopping.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {

    public static String writeFileImg(HttpServletRequest request, String path) {
        try {
            int randomNumber = (int) (Math.random() * 500);
            String realpath = request.getServletContext().getRealPath("/images");
            Path path1 = Paths.get(realpath);
            if (!Files.exists(path1)) {
                Files.createDirectory(path1);
            }
            Part photo = request.getPart(path);
            if (photo != null) {
                    photo.write(realpath + File.separator+photo.getSubmittedFileName());
                    return photo.getSubmittedFileName();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
