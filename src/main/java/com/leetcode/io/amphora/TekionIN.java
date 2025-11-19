package com.leetcode.io.amphora;


//Given two integers n and k, return an array of all the integers of length n where the difference between every
// two consecutive digits is k. You may return the answer in any order.

//Note that the integers should not have leading zeros. Integers as 02 and 043 are not allowed.
//
//Example 1:
//Input: n = 3, k = 7
//Output: [181,292,707,818,929]
//Explanation: Note that 070 is not a valid number, because it has leading zeroes.


/**
 * n=3, k=2
 * <p>
 * [1,3,1], [2,4,2],[3,5,3],[4,6,4],[5,7,5,],686,[797],[8,0,8]
 * 202,313
 * 131,242,353,464,575,686,797,202,313,
 * 135,246,
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 1 -> +2, -2 = 3,
 */

public class TekionIN {
}


//
//    private static void findArray(int n, int k) {
//        List<Integer> result = new ArrayList<>();
//        int iter = 1;
//        while (iter < 10) {
//            getNumber(iter, k, n );
//            iter++;
//        }
//
//
//    }
//
//
//    static Integer getNumber(int root, int k, int n) {
//
//        if(root > Math.pow(10,n)){
//            return -1;
//        }
//
//        getNumber(root+);
//
//
//
//
////        if (root < 0 || root > 9) {
////            return -1;
////        }
////        getNumber(root + 2, k, n);
////        getNumber(root - 2, k, n);
//
//    }
//}
