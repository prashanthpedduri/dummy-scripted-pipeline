package com.snc;

/**
 * Hello world!
 *
 */
public class App 
{
    public String hello(String name) {
        return "Hello " + name + "!";
    }

    public String sleepyHello(String name) throws InterruptedException {
        Thread.sleep(5000);
        return "Sleepy Hello " + name + "!";
    }

    public String sleepySleepyHello(String name) throws InterruptedException {
        Thread.sleep(10000);
        return "Sleepy Hello " + name + "!";
    }
}
