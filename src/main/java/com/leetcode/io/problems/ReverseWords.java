package com.leetcode.io.problems;

import java.util.Stack;

public class ReverseWords {

    public static void main(String[] args) {
        System.out.println(reverseWords("a good       example"));
    }


    public static String reverseWords(String s) {
        String words[] = s.split(" ");
        String result = "";
        Stack<String> wordStack = new Stack<>();
        for ( int i = words.length -1 ; i>=0; i--){
            if(words[i].length()!=0){
                result = result + words[i] + " ";
            }
        }
        return result.trim();
    }
}
