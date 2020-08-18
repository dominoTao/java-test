package com.chapter4.strategy;

public class JPEGSaver implements ImageSaver {
    @Override
    public void save() {
        System.out.println("jpeg类型的图片" );
    }
}
