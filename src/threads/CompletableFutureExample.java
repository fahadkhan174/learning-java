package threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CompletableFutureExample {

    public static void main(String[] args) {

        // running async in another thread than main
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("Running in another thread : " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // returning something from a completable future
        Executor executor = Executors.newFixedThreadPool(1);
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "String from future2, from thread : " + Thread.currentThread().getName();
        }, executor);

        try {
            System.out.println(future2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // using thenApply to future objects to performe action after future object has
        // returned
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "String from future3";
        }).thenApply((str) -> {
            return "Hello " + str;
        }).thenApply((str) -> {
            return str + ", Happy Hacking from thread : " + Thread.currentThread().getName();
        });

        try {
            System.out.println(future3.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
