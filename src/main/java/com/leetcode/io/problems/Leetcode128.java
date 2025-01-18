package com.leetcode.io.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Leetcode128 {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{1, 2, 0, 1}));
    }

    public static int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        if (nums.length == 0) {
            return 0;
        }
        int max = -10000000;
        for (int i : nums) {
//            map.put(i, map.getOrDefault(i - 1, 1));
            if (map.containsKey(i)) {
                continue;
            }
            if (map.containsKey(i - 1)) {
                map.put(i, map.get(i - 1) + 1);
            }
            if (!map.containsKey(i)) {
                map.put(i, 1);
            }
            int k = i;
            while (map.containsKey(k + 1)) {
                map.put(k + 1, map.get(k + 1) + map.get(i));
                max = Math.max(max, map.get(k + 1));
                k++;
            }
        }
        return max;
    }

    static int largest(int [] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int max_length = 0;
        for(int num : set){
            if(!set.contains(num-1)){// the start of a sequence
                int length = 1;
                int SeqNum = num;
                while(set.contains(SeqNum+1)){
                    SeqNum++;
                    length++;
                }
                if(max_length < length) max_length = length;
            }
            // gets here if num wasnt the start of a sequence
        }
        return max_length;
    }
    }
