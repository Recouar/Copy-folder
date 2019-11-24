package com.hxy.dir;

import java.io.*;

public class TestCopyDir{
    public static void main(String[] args) throws IOException {
    //copyFile("E:/test/hxy.txt","E:/test/hxy2.txt");
        copyDir("E:/音乐","E:/音乐1");
    }
    public static void copyDir(String sourceDirName,String destDirName){
        File sourceDir = new File (sourceDirName);
        if(!sourceDir.exists()){
            System.err.println("源文件必须存在");
        }
        File destDir = new File(destDirName);
        if(!destDir.exists()){
            destDir.mkdir();
        }
        File[] files = sourceDir.listFiles();
     for(File file :files){
         if(file.isFile()){
             copyFile(sourceDirName+"/"+file.getName(),destDirName+"/"+file.getName());
         }
         if(file.isDirectory()){
             copyDir(sourceDirName+"/"+file.getName(),destDirName+"/"+file.getName());
         }
     }
    }
    public static void copyFile(String sourceName,String destName) {
        BufferedInputStream bds= null;
        BufferedOutputStream bos = null;
        try{
            bds = new BufferedInputStream(new FileInputStream(new File(sourceName)));
            bos = new BufferedOutputStream(new FileOutputStream(destName));

            byte []  b =new  byte[1024];
            int length = bds.read(b);
            while(length !=-1){
                bos.write(b,0,length);
                length = bds.read(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bds.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
