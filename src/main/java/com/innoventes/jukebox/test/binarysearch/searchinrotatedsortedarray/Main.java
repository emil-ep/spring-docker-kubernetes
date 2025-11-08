package com.innoventes.jukebox.test.binarysearch.searchinrotatedsortedarray;


//There is an integer array nums sorted in ascending order (with distinct values).
//
//        Prior to being passed to your function, nums is possibly rotated at an
//        unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
//        For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
//
//        Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
//
//        You must write an algorithm with O(log n) runtime complexity.
public class Main {

    public static void main(String[] args) {

//        Integer[] nums = new Integer[]{4, 5, 6, 7, 0, 1, 2};
        Integer[] nums = new Integer[]{1, 3};
        int target = 3;
        int min = findMinimum(nums);
        int searchLeft = binarySearch(nums, 0, min, target);
        int searchRight = binarySearch(nums, min, nums.length - 1,  target);
        System.out.println(Integer.max(searchLeft, searchRight));
    }

    private static int binarySearch(Integer[] nums, int left, int right, int target) {


        if (nums[left] == target){
            return left;
        }
        if (nums.length == 1){
            return -1;
        }

        if (nums[right] == target){
            return right;
        }

        while(left < right){

            int mid = (left + right)/2;
            if (nums[mid] == target){
                return mid;
            }
            if (target > nums[mid]){
                left = mid + 1;
            }else if(target < nums[mid]){
                right = mid;
            }
        }
        return -1;
    }

    private static int findMinimum(Integer[] nums){

        if (nums.length == 1){
            return 0;
        }
        if (nums[0] < nums[nums.length - 1])
            return 0;

        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int mid = (left + right)/2;
            int midValue = nums[mid];
            int rightValue = nums[right];
            int leftValue = nums[left];


            if (midValue > rightValue){
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        return left;

    }
}
