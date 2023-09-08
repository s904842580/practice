package com.it;

import org.junit.Assert;
import org.junit.Test;

public class DemoTest {
    @Test
    public void testSay(){
        Demo d = new Demo();
        String ret = d.say("it");
        Assert.assertEquals("hello it",ret);
    }
}
