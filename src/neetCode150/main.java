package neetCode150;

import java.util.Arrays;
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

        // encode and decode strings testing
        List<String> inputStringList = Arrays.asList("neet","code","love","you");
        inputStringList = Arrays.asList("we","say",":","yes","!@#$%^&*()");
        EncodeDecodeStrings edstringsClass = new EncodeDecodeStrings();
        String encodedString = edstringsClass.encode(inputStringList);
        List<String> decodedList = edstringsClass.decode(encodedString);

        // testing valid sudoku
        char[][] board = {
                {'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}
        };
        ValidSudoku validSudokuClass = new ValidSudoku();
        validSudokuClass.isValidSudoku(board);
    }
}
