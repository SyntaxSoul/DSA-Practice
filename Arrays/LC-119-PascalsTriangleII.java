
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev=new ArrayList<>();

        for(int i=0;i<=rowIndex;i++){
            List<Integer> row=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    row.add(1);
                }
                else{
                    row.add(prev.get(j-1)+prev.get(j));
                }
            }
            prev=row;
        }
        return prev;
    }
}

//We can also do by using the same row which reduces use of prev
/*
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            row.add(1);  // always add 1 at end

            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }

        return row;
    }
}
*/