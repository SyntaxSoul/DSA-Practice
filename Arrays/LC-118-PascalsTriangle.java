
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list=new ArrayList<>();

        for(int i=0;i<numRows;i++){
            List<Integer> row=new ArrayList<>();

            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    row.add(1);
                }
                else{
                    List<Integer> prev=list.get(i-1);
                    row.add(prev.get(j-1)+prev.get(j));
                }
            }
            list.add(row);
        }
        return list;
    }
}

// I wrote java array code in C way, 
/*
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    list[[i,j]]=1;
                }
                else{
                    list[[i,j]]=list[[i-1,j-1]]+list[[i-1,j]];
                }
            }
        }
    }
}
*/