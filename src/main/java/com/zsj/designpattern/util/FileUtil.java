package com.zsj.designpattern.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;

public class FileUtil {
    public static Date getCreatedTime(File file) {
        try {
            Path path = Paths.get(file.getAbsolutePath());
            BasicFileAttributeView basicview = Files.getFileAttributeView(path, BasicFileAttributeView.class, LinkOption.NOFOLLOW_LINKS);
            BasicFileAttributes attr = basicview.readAttributes();
            return new Date(attr.creationTime().toMillis());
        } catch (Exception e) {
            e.printStackTrace();
            return new Date(file.lastModified());
        }
    }

    public static void writeFile(String path, String content) throws Exception {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        if (!file.isFile()) {
            throw new IOException("【" + path + "】不是文件");
        }
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }
}
