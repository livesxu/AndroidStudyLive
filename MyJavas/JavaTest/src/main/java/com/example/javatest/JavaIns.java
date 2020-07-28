package com.example.javatest;

public class JavaIns {

    //单例1 - 推荐 Holder模式
    private JavaIns(){}

    private static class JavaInsHolder {

        private static JavaIns single = new JavaIns();
    }

    static public JavaIns getInstance() {

        return JavaInsHolder.single;
    }


    //单例2
//    private JavaIns(){}
//    private volatile static JavaIns single = null;
//
//    static public JavaIns getInstance() {
//
//        if (single == null) {
//
//            synchronized(JavaIns.class) {
//
//                if (single == null) {
//
//                    single = new JavaIns();
//                }
//            }
//        }
//        return single;
//    }


    //单例3
//    private JavaIns(){}
//
//    private static JavaIns single = new JavaIns();
//
//    static public JavaIns getInstance() {
//
//        return single;
//    }
}
