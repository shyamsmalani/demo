package com.shyammalani;

import java.util.Scanner;

public class InterThreadCommunication {
    public static void main(String[] args) throws InterruptedException {
        final DemoWaitNotify pro = new DemoWaitNotify();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    pro.callingWaitMethod();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    pro.callingNotifyMethod();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }
}

class DemoWaitNotify {

    public void callingWaitMethod() throws InterruptedException {
        synchronized (this) {
            System.out.println("Wait Method is called by current running Thread...");
            wait();
            System.out.println("Waiting thread Resumed..");
        }
    }
    public void callingNotifyMethod() throws InterruptedException {
        Scanner scaner = new Scanner(System.in);
        synchronized (this) {
            System.out.println("waiting for return Key.");
            scaner.nextLine();
            System.out.println("return Key Pressed.");
            notify();

        }
    }
}