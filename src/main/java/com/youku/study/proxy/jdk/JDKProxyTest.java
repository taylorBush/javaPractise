package com.youku.study.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @author taylor
 * @date 2019/3/19
 */
public class JDKProxyTest {
    public static void main(String[] args) {
        Saying target = new SayingImpl();
        MyInvocationHandler handler = new MyInvocationHandler(target);
        Saying proxy = (Saying)Proxy.newProxyInstance(
            target.getClass().getClassLoader(),
            target.getClass().getInterfaces(),
            handler
        );
        proxy.sayHello("小明");
        proxy.sayHello("小丽");
    }
}
