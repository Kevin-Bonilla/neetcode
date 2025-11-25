package neetCode150;

import java.util.List;

public class main {

    public static void main(String[] args){
        // PlusOne Testing
        int[] digits = {1,0,0,1};

        PlusOne plusOneClass = new PlusOne();
        int[] plusOneResult = plusOneClass.plusOne(digits);

        // ThreeSum testing
        int[] nums = {-1,0,1,2,-1,-4};
        ThreeSum threeSumClass = new ThreeSum();
        List<List<Integer>> resultList = threeSumClass.threeSumTwoPointers(nums);
    }
}
