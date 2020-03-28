import java.util.HashSet;

/*
 * @lc app=leetcode id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 */

// @lc code=start
class Solution {

    //correct solution 0(mxn) time O(1) space - in line
    public void setZeroes(int[][] matrix) {
        //keep track of row zero and col zero
        Boolean rowZero = false;
        Boolean colZero = false;
        
        if (matrix[0][0] == 0){
            rowZero=true;
            colZero=true;
        }
      
        //traverse the matrix, flag the col and row (first index) if it contains a 0
        for (int i = 0 ;i <matrix.length; i ++){
            //check if the column has a zero
            if (matrix[i][0]==0) colZero = true; 
            
            for (int j = 1; j <matrix[0].length; j ++){              
                //if this element is zero, flag its row and column
                if (matrix[i][j]==0){
                    if (i ==0) 
                    {
                        rowZero = true;
                    }
                    else{
                        matrix[0][j]=0;
                        matrix[i][0]=0;
                    }
                } 
            }
            
        }
      
        //traverse each element and see if the row or column was flagged
        for (int i =1; i <matrix.length; i ++){
            for (int j = 1; j <matrix[0].length ;j++){
                if (matrix[0][j]==0||matrix[i][0]==0) matrix[i][j]=0;
            }
        }
            
        //if the row and column flags are set, set the row/col to zero. 
        if (rowZero){
           for (int j =0; j <matrix[0].length; j ++) matrix[0][j]=0;
        }
            
        if (colZero){
            for (int i =0; i<matrix.length; i++) matrix[i][0]=0;
        }
  
    }

    //solution 2 O(mxn) time O(m+n) space
    public void setZeroes2(int[][] matrix) {
         //base case
        if (matrix.length==0 || matrix ==null) return;

        //find the location of the zeros
        HashSet <Integer> row  = new HashSet<>();
        HashSet <Integer> col  = new HashSet<>();

        for (int i = 0 ; i <matrix.length; i ++){
            for (int j = 0 ; j<matrix[0].length; j++){
                if (matrix[i][j]==0){
                    row.add(i);
                    col.add(j); 
                }
            }
        }

        //iterate through the matrix again and if the current row or current col has a 0, then this index should also be a 0
        for (int i = 0 ; i <matrix.length; i ++){
            for (int j = 0 ; j<matrix[0].length; j++){
                if (row.contains(i) || col.contains(j)) matrix[i][j]=0;
            }
        }
    }

    //solution 1 O(mxn) time O(mxn) space
    public void setZeroes1(int[][] matrix) {
        //base case
        if (matrix.length==0 || matrix ==null) return;

        //find the location of the zeros
        HashSet <String> zeroLocation  = new HashSet<>();

        for (int i = 0 ; i <matrix.length; i ++){
            for (int j = 0 ; j<matrix[0].length; j++){
                if (matrix[i][j]==0){
                    String newZero = String.format("%d,%d,%d",matrix[i][j],i,j);
                    zeroLocation.add(newZero);
                }
            }
        }

        //iterate through the current zeros and make the rows and columns 0
        for (String zero: zeroLocation){
            int row = Integer.parseInt(String.valueOf(zero.split(",")[1]));
            int col = Integer.parseInt(String.valueOf(zero.split(",")[2]));
            //make the col zero (i for nums before , j for nums after)
            for (int i = col,  j = col-1; i <matrix[0].length || j>=0; i ++, j--){
                    if (j>=0) matrix[row][j]=0;
                    if (i<matrix[0].length) matrix[row][i]=0;
            }


            //make the col zero (i for nums before , j for nums after)
            for (int i = row,  j = row-1; i <matrix.length || j>=0; i ++, j--){
                    if (j>=0) matrix[j][col]=0;
                    if (i<matrix.length) matrix[i][col]=0;
            }
        }

    }
}
// @lc code=end

