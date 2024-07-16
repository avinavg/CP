package com.leetcode.io.leetcode;

import java.util.HashSet;
import java.util.Set;

public class RandomizedSet {
    Set<Object> set = new HashSet<>();

    public RandomizedSet() {
    }

    public boolean insert(int val) {
        return this.set.add(val);


    }

    public boolean remove(int val) {
        return this.set.remove(val);
    }

    public int getRandom() {
//        return this.set.Math.random()
        return 0;
//    }
    }
}
