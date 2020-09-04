package com.zsj.designpattern.composite;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zsj.designpattern.util.DateUtil;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class FileNodeResult {
    private String created_time;
    private List<FilesEntity> files;
    private List<SubDirEntity> sub_directories;
    private String version = "1";
}

@Getter
@Setter
class FilesEntity {
    private String attachment_folder = "";
    private List attachments = new ArrayList();
    private String created_time;
    private String modified_time;
    private String name = "";
    private List tags = new ArrayList();
}

@Getter
@Setter
class SubDirEntity {
    private String name;
}

class FileNodeResultIndex {
    public static String index(){
        SubDirEntity subDirEntity = new SubDirEntity();
        FilesEntity filesEntity = new FilesEntity();
        FileNodeResult fileNodeResult = new FileNodeResult();
        subDirEntity.setName("子文件1");
        filesEntity.setName("java-study.md");
        filesEntity.setCreated_time(DateUtil.getISO8601Timestamp(new Date()));
        filesEntity.setModified_time(DateUtil.getISO8601Timestamp(new Date()));

        List<FilesEntity> filesEntityList = new ArrayList<>();
        filesEntityList.add(filesEntity);

        List<SubDirEntity> subDirEntityList = new ArrayList<>();
        subDirEntityList.add(subDirEntity);
        fileNodeResult.setFiles(filesEntityList);
        fileNodeResult.setSub_directories(subDirEntityList);
        fileNodeResult.setCreated_time(DateUtil.getISO8601Timestamp(new Date()));

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(fileNodeResult);
    }
}

class FileNodeResultTest {
    public static void main(String[] args) {

//        FileNodeResultIndex.index()
//        System.out.println(result);
    }
}