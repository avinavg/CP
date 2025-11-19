package com.leetcode.io.designPatterns;

public class SingletonDP {

    //private constructor so this can only be called within this class
    private SingletonDP() {

    }

    //private instance, so no one can access it except for the getters
//    private static SingletonDP instance = new SingletonDP();

    public static SingletonDP getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        final static SingletonDP INSTANCE = new SingletonDP();
    }


}
