package com.innoventes.jukebox.test1.completablefutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        Runnable runnable = () -> {
            try{

                Thread.sleep(2000);
                System.out.println("completed");
            }catch (InterruptedException ex){
                System.out.println("exception caught");
            }
        };
        CompletableFuture<Void> future = CompletableFuture.runAsync(runnable);
        future.get();


        CompletableFuture<String> supplyFuture = CompletableFuture.supplyAsync(() -> {
            try{
                Thread.sleep(2000);
            }catch (InterruptedException ex){
                System.out.println("exception caught");
            }
            return "supplyasync completded";
        });
        System.out.println(supplyFuture.get());



    }
}
