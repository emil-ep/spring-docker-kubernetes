package com.innoventes.jukebox.test.threadpool;

public class WorkerThread implements Runnable{

    private String name;

    public WorkerThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Thread with name :" + name + "is Running");
        processThreadWorking();
    }

    public void processThreadWorking(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Error sleeping thread");
        }
    }
}
