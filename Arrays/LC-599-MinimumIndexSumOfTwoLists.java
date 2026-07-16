class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> map=new HashMap<>();
        List<String> res=new ArrayList<>();
        for(int i=0;i<list1.length;i++){
            map.put(list1[i],i);
        }
        int min=list1.length+list2.length+1;
        for(int i=0;i<list2.length;i++){
            if(map.containsKey(list2[i])){
                int sum=map.get(list2[i])+i;
                if(sum==min){
                    res.add(list2[i]);
                }
                if(sum<min){
                    min=sum;
                    res.clear();
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(String[]::new);
    }
}

// First Attempt

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int min=list1.length+list2.length+1;
        List<String> res=new ArrayList<>();
        for(int i=0;i<list1.length;i++){
            for(int j=0;j<list2.length;j++){
                if(list1[i].equals(list2[j])){
                    if(i+j==min){
                        res.add(list1[i]);
                        continue;
                    }
                    if(i+j<min){
                        min=i+j;
                        res.clear();
                        res.add(list1[i]);
                    }
                }
            }
        }
        return res.toArray(String[]::new);
    }
}