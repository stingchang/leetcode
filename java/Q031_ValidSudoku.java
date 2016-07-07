package com.leet.q031;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q031_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i =0; i<9; i++){
            if(checkRow(board, i) == false){
                System.out.println("check row "+i+" failed");
                return false;
            }
                
        }
        for(int i =0; i<9; i++){
            if(checkCol(board, i) == false){
                System.out.println("check col "+i+" failed");
                return false;
            }
        }
        for(int i =0; i<8; i+=3){
            for(int j=0; j<8; j+=3){
                if(checkBoard(board, i, j) ==false){
                    System.out.println("check board failed: "+i+", "+j);  
                    return false;
                }
            }            
        }

        return true;
    }
    private boolean checkRow(char[][] board, int row){
        System.out.println("row "+row+" = "+Arrays.toString(board[row]));
        Set<Character> set = new HashSet<>();
        for(int c =0; c< 9; c++){
            char ch = board[row][c];
            if(set.contains(ch) && ch!='.'){
               // System.out.println("return here");
                return false;
            }
                
            if(('9'-ch < 0 && ch-'1' >8) && (ch != '.')){
            //    System.out.println("return here 2");
                return false;
            }
                
            set.add(ch);
        }
        
        return true;
    }
    private boolean checkCol(char[][] board, int col){
        Set<Character> set = new HashSet<>();
        for(int r =0; r< 9; r++){
            char ch = board[r][col];
            if(set.contains(ch) && ch!='.')
                return false;
            if(('9'-ch < 0 && ch-'1' >8) && (ch != '.'))
                return false;
            set.add(ch);
        } 
        
        return true;
    }
    private boolean checkBoard(char[][] board, int row, int col){
        Set<Character> set = new HashSet<>();
        for(int r = 0; r<3; r++){
            for(int c = 0; c<3; c++){
                char ch = board[r+row][c+col];
                if(set.contains(ch) && ch!='.')
                    return false;
                if(('9'-ch < 0 && ch-'1' >8) && (ch != '.'))
                    return false;
                set.add(ch);
            }    
        }
        
        return true;
    }
}
