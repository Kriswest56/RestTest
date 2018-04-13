package com.kris.serviceTest;

import com.kris.service.serviceImpl.BaseServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BaseServiceImplTest {

    private static BaseServiceImpl baseServiceImpl;

    @Before
    public void setup(){

        baseServiceImpl = BaseServiceImpl.getInstance();

    }

    @Test
    public void getMessageTest(){

        String resp = baseServiceImpl.getMessage();

        Assert.assertNotNull(resp);
        Assert.assertEquals("Resource Home", resp);

    }

    @Test
    public void getMessageStringTest(){

        String resp = baseServiceImpl.getMessage("Test");

        Assert.assertNotNull(resp);
        Assert.assertEquals("{\"Message\":\"Test\"}", resp);

    }

    @Test
    public void postMessageTest(){

        String resp = baseServiceImpl.postMessage("{\"Message\":\"Test\"}");

        Assert.assertNotNull(resp);
        Assert.assertEquals("{\"Message\":\"Test\"}", resp);

    }

    @Test
    public void postMessageTest_InvalidRequest(){

        String resp = baseServiceImpl.postMessage("");

        Assert.assertNotNull(resp);
        Assert.assertEquals("{\"Error\":\"Invalid Request\"}", resp);

    }

}