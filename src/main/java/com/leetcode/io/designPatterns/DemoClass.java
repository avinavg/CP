package com.leetcode.io.designPatterns;

public class DemoClass {

    public static void main(String[] args) {


        //Verify Singleton
        SingletonDP singletonDP1 = SingletonDP.getInstance();
        SingletonDP singletonDP2 = SingletonDP.getInstance();
        System.out.println(singletonDP1);
        if (singletonDP1 == singletonDP2) {
            System.out.println("ola");
        }


    }
}
