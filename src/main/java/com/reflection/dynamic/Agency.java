package com.reflection.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理：
 * 实现代理类接口  Invocationhandler  ,重写invoke方法
 */
public class Agency implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理人员在卖房子" );
        return null;
    }
}
