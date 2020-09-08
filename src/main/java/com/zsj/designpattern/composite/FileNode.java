package com.zsj.designpattern.composite;

import com.zsj.designpattern.util.ArrayQueue;
import com.zsj.designpattern.util.FileUtil;
import lombok.Getter;
import lombok.Setter;

import javax.xml.soap.Node;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

enum NodeType {
    FILE,
    DIR;
}

/**
 * 导出有道云笔记生成索引，导入VNote里面
 */
class Test {
    public static void main(String[] args) throws Exception {
        String path = "";

        File file = new File(path);
        System.out.println(file.getAbsolutePath());
        FileNode node = new FileNode(file.getAbsolutePath(), file.getName(), NodeType.DIR);
        node.setCreatedTime(FileUtil.getCreatedTime(file));
        node.setModifiedTime(new Date(file.lastModified()));
        node.setAttachment_folder("_v_attachments");
        node.setImage_folder("");
        node.setRecycle_bin_folder("recycle_bin_folder");

        Test test = new Test();
        test.scanFileOne(node, file);

        test.printV2(node);

        FileNodeResultIndex result = new FileNodeResultIndex();
        ArrayQueue queue = result.getQueue();
        queue.in(node);
        result.setQueue(queue);
        result.indexV2();
    }


    /**
     *
     * @param node
     */
    private void print(FileNode node) {
        for (FileNode n : node.getFileNodeList()) {
            System.out.println(n.getPath());
            if (n.getNodeType().equals(NodeType.DIR)) {
                print(n);
            }
        }
    }

    private void printV2(FileNode node) {
        for (FileNode n : node.getFileNodeList()) {
            System.out.println(n.getPath());
            if (n.getNodeType().equals(NodeType.DIR)) {
                print(n);
            }
        }
    }

    private void scanFileOne(FileNode node, File file) {

        if (file.exists()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.isDirectory()) {
                        FileNode tmpNode = new FileNode(f.getAbsolutePath(), f.getName(), NodeType.DIR);
                        tmpNode.setCreatedTime(FileUtil.getCreatedTime(f));
                        tmpNode.setModifiedTime(new Date(f.lastModified()));
                        node.addNode(tmpNode);
                        scanFileOne(tmpNode, f);
                    } else {
                        FileNode tmpNode = new FileNode(f.getAbsolutePath(),f.getName(), NodeType.FILE);
                        tmpNode.setCreatedTime(FileUtil.getCreatedTime(f));
                        tmpNode.setModifiedTime(new Date(f.lastModified()));
                        node.addNode(tmpNode);
                    }
                }
            }
        }
    }
}

@Getter
@Setter
public class FileNode {
    private FileNode parentNode = null;

    private String path;

    private String name;

    private NodeType nodeType;

    private long fileSize = 0L;

    private long fileCount = 0L;

    private Date createdTime;

    private Date modifiedTime;

    //根目录才有该字段
    private String image_folder = null;
    //根目录才有该字段
    private String attachment_folder = null;
    //根目录才有该字段
    private String recycle_bin_folder = null;

    //子节点
    private List<FileNode> fileNodeList = new ArrayList<>();

    public FileNode(String path, String filename, NodeType nodeType) {
        this.path = path;
        this.nodeType = nodeType;
        this.name = filename;
    }

    public void addNode(FileNode node) {
        node.parentNode = this;
        fileNodeList.add(node);
        countOfFiles();
        sizeOfFiles();
    }

    public void removeNode(FileNode node) {
        FileNode parentNode = node.getParentNode();
        parentNode.getFileNodeList().remove(node);
    }

    /**
     * 计算该节点文件数量
     */
    private void countOfFiles() {

    }

    /**
     * 计算该节点文件大小
     */
    private void sizeOfFiles() {

    }
}
