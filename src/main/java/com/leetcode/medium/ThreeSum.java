package com.leetcode.medium;

import com.sun.xml.internal.bind.v2.util.CollisionCheckStack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Yongcong Lei on 9/13/2019
 */
public class ThreeSum {
    public class Triple{
        List<Integer> triple;

        public Triple(int first, int second, int third){
            triple = Arrays.asList(first, second, third);
            triple.sort(Integer::compareTo);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Triple triple1 = (Triple) o;
            return Objects.equals(triple, triple1.triple);
        }

        @Override
        public int hashCode() {
            return Objects.hash(triple);
        }

        public List<Integer> getTriple() {
            return triple;
        }
    }

    public List<List<Integer>> threeSum_extra_class(int[] nums) {
        Set<Triple> triple = new HashSet<>();
        Arrays.sort(nums);

        if(nums.length == 0)
            return new ArrayList<>();
        if(nums[0] > 0 || nums[nums.length-1] < 0)
            return new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1])
                continue;

            int left = i+1;
            int right = nums.length - 1;
            while(left < right){
                if(nums[i] + nums[left] + nums[right] == 0) {
                    triple.add(new Triple(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // avoid duplicated value
                    while (left < right && nums[left] == nums[left-1])
                        left++;
                    while (left < right && nums[right] == nums[right+1])
                        right--;

                }
                else if(nums[i] + nums[left] + nums[right] < 0)
                    left++;
                else
                    right--;
            }
        }

        return triple.stream().map(Triple::getTriple).collect(Collectors.toList());

//        int i = 0;
//        int j = nums.length - 1;
//        while(i < j){
//            int a = nums[i];
//            int b = nums[j];
//            if(a+b < 0) {
//                if(Math.abs(a+b) <= b) {
//                    if(findNumber(nums, i, j, -(a+b)))
//                        triple.add(new Triple(a, b, -(a+b)));
//                    j--;
//                }
//                else
//                    i++;
//            } else {
//                if(a+b <= Math.abs(a)) {
//                    if(findNumber(nums, i, j, -(a+b)))
//                        triple.add(new Triple(a, b, -(a+b)));
//                    i++;
//                }
//                else
//                    j--;
//            }
//        }
//
//        return triple.stream().map(Triple::getTriple).collect(Collectors.toList());
    }

    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        if(nums.length == 0)
            return new ArrayList<>();
        if(nums[0] > 0 || nums[nums.length-1] < 0)
            return new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            // avoid duplicated values
            if(i > 0 && nums[i] == nums[i-1])
                continue;

            int left = i+1;
            int right = nums.length - 1;
            while(left < right){
                if(nums[i] + nums[left] + nums[right] == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // avoid duplicated values
                    while (left < right && nums[left] == nums[left-1])
                        left++;
                    while (left < right && nums[right] == nums[right+1])
                        right--;

                }
                else if(nums[i] + nums[left] + nums[right] < 0)
                    left++;
                else
                    right--;
            }
        }

        return result;
    }

    private boolean findNumber(int[] nums, int i, int j, int i1) {
        for(int k=i+1; k<j; k++){
            if(nums[k] == i1)
                return true;
        }

        return false;
    }

//    public List<List<Integer>> threeSum_Brute_Force(int[] nums) {
//        Set<Triple> result = new HashSet<>();
//        for(int i=0; i<nums.length; i++){
//            for(int j=i+1; j<nums.length; j++){
//                for(int k=j+1; k<nums.length; k++){
//                    if(nums[i] + nums[j] + nums[k] == 0){
//                        result.add(new Triple(nums[i], nums[j], nums[k]));
//                    }
//                }
//            }
//        }
//
//        return result.stream().map(Triple::getTriple).collect(Collectors.toList());
//    }
}
