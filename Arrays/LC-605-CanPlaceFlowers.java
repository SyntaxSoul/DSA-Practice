class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i=0;i<flowerbed.length && n>0;i++){
            if(flowerbed[i] == 1){
                continue;
            }
            boolean leftEmpty = (i == 0 || flowerbed[i-1] == 0);
            boolean rightEmpty = (i == flowerbed.length-1 || flowerbed[i+1] == 0);

            if(leftEmpty && rightEmpty){
                flowerbed[i] = 1;
                n--;
            }
        }
        return n==0;
    }
}

// First Attempt

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i=0;
        int len=flowerbed.length;
        if(len<=1){
            if(flowerbed[i]==0 && n==1){
                return true;
            }
            if(n==0){
                return true;
            }
            return false;
        }
        while(i<flowerbed.length && n>0){
            if(i==0){
                    if(flowerbed[i]==0 && flowerbed[i+1]==0){
                        n--;
                        i++;
                    }
                }
            else if(i==flowerbed.length-1){
                if(flowerbed[i]==0 && flowerbed[i-1]==0){
                    n--;
                    i++;
                }
            }
            else if(flowerbed[i]==0 && flowerbed[i-1]==0 && flowerbed[i+1]==0){
                n--;
                i++;
            }
            i++;
        }
        return n==0;
    }
}
