package com.reflection.dynamic;

public class HouseSeller implements Seller{
    @Override
    public void sell() {
        System.out.println("销售人员在卖房子" );
    }
}
