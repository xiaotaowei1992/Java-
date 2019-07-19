package com.wangwenjun.concurrency.chapter1;

/***************************************
 * @author:Alex Wang
 * @Date:2017/2/14 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class TryConcurrency {

    public static void main(String[] args) {

        /*readFromDataBase();
        writeDataToFile();*/

        Thread t=new Thread("READ-Thread"){
            @Override
            public void run() {
                println(Thread.currentThread().getName());//READ-Thread
                readFromDataBase();
            }
        };

        t.start();

        new Thread("WRITE-Thread"){
            @Override
            public void run() {
                println(Thread.currentThread().getName());
                writeDataToFile();
            }
        }.start();

        Thread t2= new Thread("WRITE-Thread2"){
            @Override
            public void run() {
                println("---"+Thread.currentThread().getName());//main
                writeDataToFile();
            }
        };
        t2.run();
        //start() run(),使用的模板方法，在子类中实现具体的run(),实现具体的功能

    }

    private static void readFromDataBase() {
        //read data from database and handle it.
        try {
            println("Begin read data from db.");
            Thread.sleep(1000 * 30L);
            println("Read data done and start handle it.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        println("The data handle finish and successfully.");
    }

    private static void writeDataToFile() {
        try {
            println("Begin write data to file.");
            Thread.sleep(2000 * 20L);
            println("Write data done and start handle it.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        println("The data handle finish and successfully.");
    }

    private static void println(String message) {
        System.out.println(message);
    }
}
