package com.innoventes.jukebox.test.binarysearch.maximumsubarray;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    //Given an integer array nums, find the subarray with largest sum and return its sum
    //For eg: Input : nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4}
    // output : 6
    // Explanation : The subarray [4, -1, 2, 1] has the largest sum 6
    public static void main(String[] args) {

        Integer[] nums = new Integer[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int sum = findLargestSum(nums);
        System.out.println(sum);
    }

    private static int findLargestSum(Integer[] nums){

       int i = 0;
       int finalSum = Integer.MIN_VALUE;
       int localSum = 0;

       while (i < nums.length){

           if (localSum < 0 && nums[i] >= localSum){
               localSum = 0;
           }
           localSum += nums[i];

           finalSum = Math.max(finalSum, localSum);
           i++;
       }
       return finalSum;
    }
}
