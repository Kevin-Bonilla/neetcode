package neetCode150;

/*
Valid Sudoku

You are given a 9 x 9 Sudoku board board. A Sudoku board is valid if the following rules are followed:

    Each row must contain the digits 1-9 without duplicates.
    Each column must contain the digits 1-9 without duplicates.
    Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without duplicates.

Return true if the Sudoku board is valid, otherwise return false

Note: A board does not need to be full or be solvable to be valid.

Example 1:

Input: board =
[["1","2",".",".","3",".",".",".","."],
 ["4",".",".","5",".",".",".",".","."],
 [".","9","8",".",".",".",".",".","3"],
 ["5",".",".",".","6",".",".",".","4"],
 [".",".",".","8",".","3",".",".","5"],
 ["7",".",".",".","2",".",".",".","6"],
 [".",".",".",".",".",".","2",".","."],
 [".",".",".","4","1","9",".",".","8"],
 [".",".",".",".","8",".",".","7","9"]]

Output: true

Example 2:

Input: board =
[["1","2",".",".","3",".",".",".","."],
 ["4",".",".","5",".",".",".",".","."],
 [".","9","1",".",".",".",".",".","3"],
 ["5",".",".",".","6",".",".",".","4"],
 [".",".",".","8",".","3",".",".","5"],
 ["7",".",".",".","2",".",".",".","6"],
 [".",".",".",".",".",".","2",".","."],
 [".",".",".","4","1","9",".",".","8"],
 [".",".",".",".","8",".",".","7","9"]]

Output: false

Explanation: There are two 1's in the top-left 3x3 sub-box.

Constraints:

    board.length == 9
    board[i].length == 9
    board[i][j] is a digit 1-9 or '.'.

 */

import java.util.HashSet;

public class ValidSudoku {
//     so basically we need to go through an 2d array representing the sudoku board
//     for each number (if the number is given) we need to make sure that there is no duplicate number in 3 places
    // we need to check its 3x3 box, its row, and column.
    // we DO NOT need to check if its solvable.

    // 1 idea make a checker for each place we need to check and pass in our number or index there and check
    // return false if find bad stuff and true if find good

    // solution course of action 2
    // another way which might lead to less duplicate searching is to just have some premade functions that check all rows,
    // check all columns and check all squares
    // we can do this by adding the numbers in a hashmap and if the number is already in the hashmap then we return false

    public boolean rowChecker(char[][] board){
        // hashset thats going to hold our numbers that we have already seen
        HashSet<Character> visitedChars = new HashSet<Character>();

        for(int i = 0; i < board.length; i++){
            // i will indicate row
            for(int j = 0; j < board[i].length; j++){
                // j will indicate what number in the row we are on
                char currentNum = board[i][j];
                if (visitedChars.contains(currentNum)){
                    // if we already have the char we are at in the row, row is bad
                    return false;
                } else if(currentNum != '.'){
                    visitedChars.add(currentNum);
                }
            }
            // we need to reset the hashSet when we switch to a new row
            visitedChars = new HashSet<Character>();
        }

        // if everything checked out we can return true meaning all rows are good and have no dupes
        return true;
    }

    public boolean columnChecker(char[][] board){
        // similar to the row checker except we are going to check the columns vertically
        // hashset thats going to hold our numbers that we have already seen
        HashSet<Character> visitedChars = new HashSet<Character>();

        for(int i = 0; i < board[0].length; i++){
            // i will indicate column
            for(int j = 0; j < board.length; j++){
                // j will indicate what number in the column we are on
                char currentNum = board[j][i];
                if (visitedChars.contains(currentNum)){
                    // if we already have the char we are at in the column, column is bad
                    return false;
                } else if(currentNum != '.'){
                    visitedChars.add(currentNum);
                }
            }
            // we need to reset the hashSet when we switch to a new row
            visitedChars = new HashSet<Character>();
        }

        // if everything checked out we can return true meaning all rows are good and have no dupes
        return true;
    }

    public boolean squareChecker(char[][] board){
        HashSet<Character> visitedChars = new HashSet<Character>();

        // outer two loops are for defining which 3x3 box we are checking
        for(int boxRow = 0; boxRow < 7; boxRow = boxRow + 3){
            for (int boxCol = 0; boxCol < 7; boxCol = boxCol + 3){
                // inner two for loops are for actually checking the box that we have defined

                for (int miniBoxRow = 0; miniBoxRow < 3; miniBoxRow++){
                    for (int miniBoxCol = 0; miniBoxCol < 3; miniBoxCol++){
                        char currentChar = board[miniBoxRow + boxRow][miniBoxCol + boxCol];

                        if (currentChar == '.'){
                            continue;
                        }
                        else if(visitedChars.contains(currentChar)){
                            return false;
                        }
                        else{
                            visitedChars.add(currentChar);
                        }
                    }
                }
                visitedChars = new HashSet<Character>();

            }
        }

        // if we made it through all that then we are good w the 3x3s!
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        boolean isValid = rowChecker(board) && columnChecker(board) && squareChecker(board);

        // will short circuit if one of them is false stopping check

        return isValid;
    }
}
