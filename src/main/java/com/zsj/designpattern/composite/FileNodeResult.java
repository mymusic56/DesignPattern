package com.zsj.designpattern.composite;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zsj.designpattern.util.ArrayQueue;
import com.zsj.designpattern.util.DateUtil;
import com.zsj.designpattern.util.FileUtil;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Queue;

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

@Setter
@Getter
class FileNodeResultIndex {
    private ArrayQueue queue = new ArrayQueue();

    public String indexV2() throws Exception {
        FileNode nodes = (FileNode) queue.out();
        if (nodes == null) {
            return "";
        }

        FileNodeResult fileNodeResult = new FileNodeResult();

        List<FilesEntity> filesEntityList = new ArrayList<>();
        List<SubDirEntity> subDirEntityList = new ArrayList<>();

        for (FileNode node: nodes.getFileNodeList()) {
            FilesEntity filesEntity = new FilesEntity();
            SubDirEntity subDirEntity = new SubDirEntity();

            if (node.getNodeType().equals(NodeType.DIR)) {
                subDirEntity.setName(node.getName());
                subDirEntityList.add(subDirEntity);
                queue.in(node);
                continue;
            }
            if ("_vnote.json".equals(node.getName())) {
                continue;
            }
            filesEntity.setCreated_time(DateUtil.getISO8601Timestamp(node.getCreatedTime()));
            filesEntity.setModified_time(DateUtil.getISO8601Timestamp(node.getModifiedTime()));
            filesEntity.setName(node.getName());

            filesEntityList.add(filesEntity);
        }


        fileNodeResult.setFiles(filesEntityList);
        fileNodeResult.setSub_directories(subDirEntityList);
        fileNodeResult.setCreated_time(DateUtil.getISO8601Timestamp(nodes.getCreatedTime()));

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();

        //写入文件
        String content = gson.toJson(fileNodeResult);
        FileUtil.writeFile(nodes.getPath() + "\\_vnote.json", content);
        return indexV2();
    }

    public static String index(FileNode nodes){
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

        String result = FileNodeResultIndex.index(null);
        System.out.println(result);
    }
}