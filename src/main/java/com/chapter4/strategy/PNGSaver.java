package com.chapter4.strategy;

public class PNGSaver implements ImageSaver {
    @Override
    public void save() {
        System.out.println("PNG类型的图片" );
    }
}
