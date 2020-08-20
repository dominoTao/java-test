package com.file;

import java.io.*;

public class SocketFileCopy {
    private static void copySingleFile(File source, File target) throws IOException {
        FileInputStream inputStream =  new FileInputStream(source);
        FileOutputStream outputStream = new FileOutputStream(target);

        byte[] bytes = new byte[5 * (2 << 10)];
        int length;
        while((length = inputStream.read(bytes))!=-1){
            outputStream.write(bytes, 0, length);
        }
        outputStream.flush();
        outputStream.close();
        inputStream.close();
    }
}
