package com.chapter4.innerclass;

import com.chapter4.strategy.GIFSaver;
import com.chapter4.strategy.ImageSaver;
import com.chapter4.strategy.JPEGSaver;
import com.chapter4.strategy.PNGSaver;

public class TypeChooser {
    public static ImageSaver getSaver(String type) {
        if(type.equalsIgnoreCase("GIF")) {
            return new GIFSaver();
        }else if(type.equalsIgnoreCase("JPEG")) {
            return new JPEGSaver();
        }else if(type.equalsIgnoreCase("PNG")) {
            return new PNGSaver();
        } else {
            return null;
        }
    }
}
