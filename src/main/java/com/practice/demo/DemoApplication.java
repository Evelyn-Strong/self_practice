package com.practice.demo;

import com.practice.demo.annoExample.AnnotationExample;
import com.practice.demo.threadExample.DemoThreadRunnable;
import com.practice.demo.threadExample.RunnableExample;
import com.practice.demo.util.YamlParserUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

	    Map<String,Boolean> testCase =  (Map<String,Boolean>) YamlParserUtil.paserYaml("","case_config.yml");

	    if(testCase.get("annoTest")){

            AnnotationExample example = new AnnotationExample();
            example.test();
        }

        if(testCase.get("threadTest")){
            System.out.println("Executing program ... ");
            RunnableExample r =  new RunnableExample();
            Thread thread1 = new Thread(r, "Thread 1");
            thread1.start();
            Thread thread2 = new Thread(r, "Thread 2");
            thread2.start();
            Thread thread3 = new Thread(new Runnable(){
              @Override
              public void run(){
                   for(int i=0;i<10;i++){
                       System.out.println(Thread.currentThread().getName()+"\twith Runnable: Inner class Runnable runs..."+i);
                   }
              }
            },"Thread 3");
            thread3.start();

        }

        if(testCase.get("threadLocalTest")){
            DemoThreadRunnable r = new DemoThreadRunnable();
            Thread thread1 =  new Thread(r,"Thread 1");
            Thread thread2 =  new Thread(r,"Thread 2");

            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();

        }

	}


}
