package com.reflection.dynamic;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        Seller seller = new HouseSeller();
        seller.sell();


        ClassLoader classLoader = Seller.class.getClassLoader( );
//        ClassLoader classLoader = HouseSeller.class.getClassLoader( );
        Seller agency = (Seller) Proxy.newProxyInstance(classLoader, new Class[]{Seller.class}, new Agency());
        agency.sell();
    }
}
