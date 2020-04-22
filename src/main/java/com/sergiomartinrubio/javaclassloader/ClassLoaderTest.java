package com.sergiomartinrubio.javaclassloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassLoaderTest {

    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        loadClass();
        loadClassFromFile();


    }

    private static void loadClass() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException,
            InstantiationException {
        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> myClass = myClassLoader.findClass("com.sergiomartinrubio.javaclassloader.TestClass");
        Object classObject = myClass.getDeclaredConstructor().newInstance();

        Method myMethod = myClass.getMethod("hello");
        myMethod.invoke(classObject);
    }

    private static void loadClassFromFile() throws InvocationTargetException, IllegalAccessException,
            NoSuchMethodException, InstantiationException {
        PathFileClassLoader pathFileClassLoader = new PathFileClassLoader();
        // Load class from the root of the project
        Class<?> classFromPath = pathFileClassLoader.findClass("TestClassFromPath.class");

        Object classObject = classFromPath.getDeclaredConstructor().newInstance();

        Method myMethod = classFromPath.getMethod("hello");
        myMethod.invoke(classObject);
    }
}
