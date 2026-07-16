class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] res = new int[r][c];
        int k=0;
        if(row*col!=r*c){
            return mat;
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                res[k/c][k%c]=mat[i][j];
                k++;
            }
        }
        return res;
    }
}


// First Attempt

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] res = new int[r][c];
        if(row*col!=r*c){
            return mat;
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(i>=row || j>=col){
                    if(i>=row){
                        res[i][j]=mat[i%row][j+1];
                    }
                    else{
                        res[i][j]=mat[i+1][j%col];
                    }
                }
                else{
                res[i][j]=mat[i][j];
                }
                
            }
            
        }
        return res;
    }
}

