package neetCode150;

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
    // need to search the arrays for the word
    // if its in the arrays return true, if not its false
    // single cell cannot be used more than once
    public boolean exist(char[][] board, String word) {
        // idea maybe is to search for the first letter
        // when you find that first letter then we need to search for the next letter in char[1-i+1][1-j+1] from where first char[1-i+1][1-j+1] is
        // do that until the word is finished?
        // we need to handle what a failed case looks like?



    }
}
