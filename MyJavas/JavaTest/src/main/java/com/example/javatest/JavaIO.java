package com.example.javatest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class JavaIO {

    //io操作拷贝文本
    static void copyTxt () {

        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {

            inputStream = new FileInputStream("/Users/xuxiaobo/Desktop/AndroidStudyLive/MyJavas/JavaTest/src/main/java/com/example/javatest/content1.txt");
            outputStream = new FileOutputStream("/Users/xuxiaobo/Desktop/AndroidStudyLive/MyJavas/JavaTest/src/main/java/com/example/javatest/content2.txt");

            byte[] tt = new byte[4];
            int hasRead = 0;
            while ((hasRead = inputStream.read(tt)) >0) {

                outputStream.write(tt);
            }

        } catch (Exception e) {

        }
    }


}
