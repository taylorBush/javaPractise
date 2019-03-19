package com.youku.study.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author taylor
 * @date 2019/3/19
 */
public class CglibProxy implements MethodInterceptor {
    Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        //设置需要创建的子类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        //通过字节码技术动态创建子类实例
        return enhancer.create();
    }

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("——————————————————————————");
        System.out.println("下一位请登台发言！");
        //目标方法调用
        Object result = methodProxy.invokeSuper(object, args);
        //目标方法后执行
        System.out.println("大家掌声鼓励！");
        return result;
    }
}
