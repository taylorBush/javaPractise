package com.youku.study.proxy.cglib;

import com.youku.study.proxy.jdk.Saying;
import com.youku.study.proxy.jdk.SayingImpl;

/**
 * @author taylor
 * @date 2019/3/19
 */
public class CglibProxyTest {
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        Saying target = (Saying)proxy.getProxy(SayingImpl.class);
        target.sayHello("小明");
        target.sayHello("小丽");
    }
}
