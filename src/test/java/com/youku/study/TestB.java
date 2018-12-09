package com.youku.study;

/**
 * @author taylor
 * @date 2018/12/9
 */
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestB
{
    public TestB()
    {

    }
    @Before
    public void before()
    {
        System.out.println("TestB begin!");
    }

    @Test
    public void test()
    {
        System.out.println("TestB doing!");
    }

    @After
    public void after()
    {
        System.out.println("TestB end!");
    }
} ;
