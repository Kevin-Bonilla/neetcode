package neetCode250;

/*
Word Search

Given a 2-D grid of characters board and a string word, return true if the word is present in the grid, otherwise return false.

For the word to be present it must be possible to form it with a path in the board with horizontally or vertically neighboring cells. The same cell may not be used more than once in a word.

Example 1:

Input:
board = [
  ["A","B","C","D"],
  ["S","A","A","T"],
  ["A","C","A","E"]
],
word = "CAT"

Output: true

Example 2:

Input:
board = [
  ["A","B","C","D"],
  ["S","A","A","T"],
  ["A","C","A","E"]
],
word = "BAT"

Output: false

Constraints:

    1 <= board.length, board[i].length <= 5
    1 <= word.length <= 10
    board and word consists of only lowercase and uppercase English letters.

 */

public class WordSearch {

    public boolean dfs(char[][] board, int i, int j, String word, int index){
        // when starting we start at index 0 then will recursively call this

        // base case
        // if we found the word
        if(index == word.length()){
            return true;
        }

        int firstDimSize = board.length;
        int secondDimSize = board[0].length;

        // fail conditions
        // going out of bounds,
        if (i < 0 || j < 0 || i >= firstDimSize || j >= secondDimSize){
            return false;
        }
        // mismatch of letters
        char currentLetter = word.charAt(index);
        if (board[i][j] != currentLetter){
            return false;
        }

        // we need to mark the current index as visited
        // we can do this by modifying the value and retaining the value separately
        char visitedChar = board[i][j];
        board[i][j] = '#';

        int[][] neighborMath = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // call dfs on its neighbors
        for (int[] arr : neighborMath){
            int newI = i + arr[0];
            int newJ = j + arr[1];
            boolean results = dfs(board, newI, newJ, word, index + 1);
            if(results){
                //restoring visitedChar
                board[i][j] = visitedChar;
                return true; // if all dfs passes
            }
        }

        // if we want to backtrack bc no neighbors worked
        board[i][j] = visitedChar;
        return false;
    }

    // need to search the arrays for the word
    // if its in the arrays return true, if not its false
    // single cell cannot be used more than once
    public boolean exist(char[][] board, String word) {
        // idea maybe is to search for the first letter
        // when you find that first letter then we need to search for the next letter in char[1-i+1][1-j+1] from where first char[1-i+1][1-j+1] is
        // do that until the word is finished?
        // we need to handle what a failed case looks like?
        // we are going to use DFS + backtracking
        // when we visit a cell we need to mark it as visited so that we dont waste time going to it again


        // base cases: if the board is null, word is null, or board length is null
        if (board == null || board.length == 0 || word == null){
            return false;
        }

        int firstDimSize = board.length;
        int secondDimSize = board[0].length;

        // then we need to start a search from every first character in the board
        char firstCharacter = word.charAt(0);
        for (int i = 0; i < firstDimSize; i++){
            for (int j = 0; j < secondDimSize; j++){
                if(board[i][j] == firstCharacter){
                    // need to start a dfs search
                    boolean didWeFindTheWord = dfs(board, i, j, word, 0);
                    if (didWeFindTheWord){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
