package com.innoventes.jukebox.test.leetcode;

import java.util.Set;
import java.util.TreeSet;

public class Solution {

    public static int[] twoSum(int[] nums, int target) {
        int[] output = new int[2];
        for(int i = 0; i< nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    output[0] = i;
                    output[1] = j;
                }
            }
        }
        return output;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] sortedArray = new int[nums1.length + nums2.length];
        int r = 0;
        int i = 0;
        int j = 0;
        while(r <= nums1.length + nums2.length -1){
            if(i >= nums1.length && j < nums2.length){
                sortedArray[r] = nums2[j];
                r++;
                j++;
                continue;
            }else if(j >= nums2.length && i < nums1.length){
                sortedArray[r] = nums1[i];
                r++;
                i++;
                continue;
            }else if(nums1[i] > nums2[j]){
                sortedArray[r] = nums2[j];
                r++;
                j++;
                continue;
            }else if(nums1[i] < nums2[j]){
                sortedArray[r] = nums1[i];
                r++;
                i++;
                continue;
            }else if(nums1[i] == nums2[j]){
                sortedArray[r] = nums1[i];
                r++;
                i++;
                continue;
            }
        }
        System.out.println(sortedArray);
        return 0;
    }
}
