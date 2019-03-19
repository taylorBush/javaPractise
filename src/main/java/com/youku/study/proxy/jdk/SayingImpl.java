package com.youku.study.proxy.jdk;

/**
 * @author taylor
 * @date 2019/3/19
 */
public class SayingImpl implements Saying{
    @Override
    public void sayHello(String name) {
        System.out.println(name + "：大家好啊！");
    }

    @Override
    public void talking(String name) {
        System.out.println(name + "：我的意思是，我们要努力建设和谐社会！");
    }
}
