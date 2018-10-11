package com.lk.java.guava.ratelimit;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

@RestController
@RequestMapping("/test")
public class ListenableFutureTest {
	
	public void test() {
		
		ExecutorService pool = Executors.newFixedThreadPool(10);
		
		ListeningExecutorService executorService = MoreExecutors.listeningDecorator(pool);
        final ListenableFuture<Integer> listenableFuture = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("call execute..");
                TimeUnit.SECONDS.sleep(1);
                return 7;
            }
        });
        
//        listenableFuture.addListener(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    System.out.println("get listenable future's result " + listenableFuture.get());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (ExecutionException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, executorService);
        //对ListenableFuture中的线程进行监听
        listenableFuture.addListener(() -> {
                try {
                    System.out.println("get listenable future's result " + listenableFuture.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
        }, executorService);
        
        
        Futures.addCallback(listenableFuture, new FutureCallback<Integer>() {
            @Override
            public void onSuccess(Integer result) {
                System.out.println("get listenable future's result with callback " + result);
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        });
        
        if(listenableFuture.isDone()) {
        	executorService.shutdown();
        }
	}
	
	public static void main(String[] args) {
		ListenableFutureTest test = new ListenableFutureTest();
		test.test();
		System.out.println("----------------主线程执行完毕----------");
	}
}
