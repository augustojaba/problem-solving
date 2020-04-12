package com.jaba.code.leetcode.problemsolving.datastructure.hashtable.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {

  public static void main(String[] args) {

    System.out.println(
        new ValidSudoku()
            .isValidSudoku(
                new char[][] {
                  new char[] {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                  new char[] {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                  new char[] {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                  new char[] {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                  new char[] {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                  new char[] {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                  new char[] {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                  new char[] {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                  new char[] {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                }));

    System.out.println(
        new ValidSudoku()
            .isValidSudoku(
                new char[][] {
                  new char[] {'5', '3', '.', '.', '5', '.', '.', '.', '.'},
                  new char[] {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                  new char[] {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                  new char[] {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                  new char[] {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                  new char[] {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                  new char[] {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                  new char[] {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                  new char[] {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                }));

    System.out.println(
        new ValidSudoku()
            .isValidSudoku(
                new char[][] {
                  new char[] {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                  new char[] {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                  new char[] {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                  new char[] {'5', '.', '.', '.', '6', '.', '.', '.', '3'},
                  new char[] {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                  new char[] {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                  new char[] {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                  new char[] {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                  new char[] {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                }));

    System.out.println(
        new ValidSudoku()
            .isValidSudoku(
                new char[][] {
                  new char[] {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                  new char[] {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                  new char[] {'.', '5', '8', '.', '.', '.', '.', '6', '.'},
                  new char[] {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                  new char[] {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                  new char[] {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                  new char[] {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                  new char[] {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                  new char[] {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                }));
  }

  public boolean isValidSudoku(char[][] board) {

    Map<Integer, Set<Character>> map = new HashMap<>();

    for (int i = 0; i < board.length; i++) {

      int indexCol = i;
      int indexRow = i + 10;

      map.put(indexCol, new HashSet<>());
      map.put(indexRow, new HashSet<>());

      for (int j = 0; j < board[i].length; j++) {
        int indexBlock = 20 + ((i / 3) * 3 + (j / 3));

        if (!map.containsKey(indexBlock)) {
          map.put(indexBlock, new HashSet<>());
        }

        if (!map.get(indexCol).contains(board[i][j]) && board[i][j] != '.') {
          map.get(indexCol).add(board[i][j]);
        } else if (map.get(indexCol).contains(board[i][j])) {
          return false;
        }

        if (!map.get(indexRow).contains(board[j][i]) && board[j][i] != '.') {
          map.get(indexRow).add(board[j][i]);
        } else if (map.get(indexRow).contains(board[j][i])) {
          return false;
        }

        if (!map.get(indexBlock).contains(board[i][j]) && board[i][j] != '.') {
          map.get(indexBlock).add(board[i][j]);
        } else if (map.get(indexBlock).contains(board[i][j])) {
          return false;
        }
      }
    }

    return true;
  }
}
