package com.youku.study;

/**
 * @author taylor
 * @date 2018/12/9
 */
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestA
{
    //这个构造函数必须有
    public TestA()
    {

    }
    @Before
    public void before()
    {
        System.out.println("TestA begin!");
    }

    @Test
    public void test()
    {
        System.out.println("TestA doing!");
    }

    @After
    public void after()
    {
        System.out.println("TestA end!");
    }
} ;

