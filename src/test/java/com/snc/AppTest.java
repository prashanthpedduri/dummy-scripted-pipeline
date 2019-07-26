package com.snc;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testHello() {
        App app = new App();
        Assert.assertEquals("Hello World!", app.hello("World"));
    }

    @Test
    public void testSleepyHello() throws InterruptedException {
        App app = new App();
        Assert.assertEquals("Sleepy Hello World!", app.sleepyHello("World"));
    }

    @Test
    public void testSleepySleepyHello() throws InterruptedException {
        App app = new App();
        Assert.assertEquals("Sleepy Hello World!", app.sleepySleepyHello("World"));
    }
}
