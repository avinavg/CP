package com.leetcode.io.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Amp {

    public static void main(String[] args) {
        List<Integer> ab = new ArrayList<>();
        ab.add(1);
        ab.add(2);
        ab.add(3);
        ab.add(4);
        ab.add(5);
        ab.add(6);
        spiralize(ab,2);

    }

    public static List<Integer> spiralize(List<Integer> numbers, int reference)
    {
        Integer arr[] = numbers.stream().toArray(Integer[]::new);
        int length = arr.length;
        int index=0;
        //finding reference number, not using binary Search since sorted array not given
        for(int i = 0 ; i< length ; i++) {
            if(arr[i]==reference){
                index = i;
                break;
            }
        }

        Integer a[] = Arrays.copyOf(arr, length);
        int step = 1;
        int left = index - 1;
        int right = index + 1;

        //appenidng orignal reference element first
        a[index] += step++;

        while(left >= 0 || right < length) {
            if(right<length) {
                a[right++] += step++;
            }
            if(left >= 0) {
                a[left--] += step++;
            }
        }
        return Arrays.asList(a);
    }
}
