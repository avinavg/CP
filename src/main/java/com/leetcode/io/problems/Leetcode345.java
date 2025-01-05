package com.leetcode.io.problems;

import java.util.*;

public class Leetcode345 {

    public static void main(String[] args) {
        System.out.println(reverseVowels2("Hello"));
    }

    public static String reverseVowels(String s) {
        String res = "";
//        List<Character> vowel = new ArrayList<Character>();
        Stack<Character> vowel  = new Stack<Character>();
        for (int i =0; i< s.length(); i++){
            char curr = s.charAt(i);
            if(curr == 'a'|| curr == 'e' || curr == 'i' || curr == 'o'|| curr == 'u'|| curr == 'A'|| curr == 'E' || curr == 'I' || curr == 'O'|| curr == 'U') {
                vowel.push(curr);
            }
        }
        for (int i =0; i< s.length(); i++){
            char curr = s.charAt(i);
            if(curr == 'a'|| curr == 'e' || curr == 'i' || curr == 'o'|| curr == 'u'|| curr == 'A'|| curr == 'E' || curr == 'I' || curr == 'O'|| curr == 'U') {
                char c = vowel.pop();
                res= res+ c;
            } else {
                res= res+ curr;
            }
        }
        return res;
    }

    public static String reverseVowels2(String s) {
        String res = "";
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        int start = 0;
        int end = s.length();
        while (start < end) {
            char curr1 = s.charAt(start);
            char curr2 = s.charAt(end-1);
            if ( vowels.contains(curr1) && vowels.contains(curr2)){
                System.out.println(curr2 + " " + curr1 );
                res = s.replace(s.charAt(start),s.charAt(end-1));
                System.out.println(res);
                start++;
                end--;
            }
           else if (vowels.contains(curr1)){
               end--;
            } else {
               start++;
            }
        }
        return s;
    }

    public  static  void swap(char a , char b){
        char temp =  a;
        a= b;
        b = temp;
    }
}
