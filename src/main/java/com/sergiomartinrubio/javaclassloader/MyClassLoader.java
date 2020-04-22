package com.sergiomartinrubio.javaclassloader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) {
        byte[] bytes = loadClassBytes(name);
        return defineClass(name, bytes, 0, bytes.length);
    }

    private byte[] loadClassBytes(String className) {
        InputStream inputStream = getClass().getClassLoader()
                .getResourceAsStream(className.replace(".", "/") + ".class");
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        int len;
        try {
            while ((len = inputStream.read()) != -1) {
                byteStream.write(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteStream.toByteArray();
    }

}
