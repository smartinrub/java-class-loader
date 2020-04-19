package com.sergiomartinrubio.javaclassloader;

import static java.util.Objects.isNull;

public class ClassLoaderDemo {

    public static void main(String[] args) {
        ModuleLayer layer = ModuleLayer.boot();
        layer.modules().forEach(module -> {
            ClassLoader classLoader = module.getClassLoader();
            String classLoaderName = isNull(classLoader) ? "bootstrap" : classLoader.getName();
            System.out.println(classLoaderName + ": " + module.getName());
        });
    }
}
