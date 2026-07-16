class Solution {
    public int islandPerimeter(int[][] grid) {
        int res=0;
        int rlen=grid.length;
        int clen=grid[0].length;
        for(int i=0;i<rlen;i++){
            for(int j=0;j<clen;j++){
                if(grid[i][j]==1){
                    res+=4;
                    if(i>0 && grid[i-1][j]==1){
                        res--;
                    }
                    if(i<rlen-1 && grid[i+1][j]==1){
                        res--;
                    }
                    if(j>0 && grid[i][j-1]==1){
                        res--;
                    }
                    if(j<clen-1 && grid[i][j+1]==1){
                        res--;
                    }
                }
            }
        }
        return res;
    }
}

//First Attempt

class Solution {
    public int islandPerimeter(int[][] grid) {
        int res=0;
        int len=grid.length;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(grid[i][j]==1){
                    if((i==0 || j==0) || (i==len-1 || j==len-1)){
                    if(i==j){
                        res++;
                    }
                    res++;
                }
                    if(j>0 && grid[i][j-1] == 0){
                        res++;
                    }
                    if(j<len-1 && grid[i][j+1] == 0){
                        res++;
                    }
                    if(i>0 && grid[i-1][j] == 0){
                        res++;
                    }
                    if(i<len-1 && grid[i+1][j] == 0){
                        res++;
                    }
                }
            }
        }
        return res;
    }
}