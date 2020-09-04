package com.zsj.designpattern.composite;

import lombok.Getter;

import javax.xml.soap.Node;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

enum NodeType {
    FILE,
    DIR;
}

class Test {
    public static void main(String[] args) {
        String path = "D:\\Workspace-Java\\my_project\\DesignPattern\\src\\main\\java\\com\\zsj\\designpattern\\demo";
        File file = new File(path);
        System.out.println(file.getAbsolutePath());
        FileNode node = new FileNode(file.getAbsolutePath(), file.getName(), NodeType.DIR);

        Test test = new Test();
        test.scanFileOne(node, file);

        test.printV2(node);
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
                        node.addNode(tmpNode);
                        scanFileOne(tmpNode, f);
                    }
                    node.addNode(new FileNode(f.getAbsolutePath(),f.getName(), NodeType.FILE));
                }
            }
        }
    }

}

@Getter
public class FileNode {
    private FileNode parentNode = null;

    private String path;

    private String name;

    private NodeType nodeType;

    private long fileSize = 0L;

    private long fileCount = 0L;

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
