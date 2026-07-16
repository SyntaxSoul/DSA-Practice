class Solution {
    public String[] findWords(String[] words) {

        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";

        List<String> result = new ArrayList<>();

        for (String word : words) {

            char firstChar = Character.toLowerCase(word.charAt(0));
            String row;

            if (row1.indexOf(firstChar) != -1) {
                row = row1;
            } else if (row2.indexOf(firstChar) != -1) {
                row = row2;
            } else {
                row = row3;
            }

            boolean valid = true;

            for (int i = 1; i < word.length(); i++) {
                char ch = Character.toLowerCase(word.charAt(i));

                if (row.indexOf(ch) == -1) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }
}

// First Attempt

class Solution {
    public String[] findWords(String[] words) {
        String row1="qwertyuiop";
        String row2="asdfghjkl";
        String row3="zxcvbnm";
        int row=0;
        int first=0;
        int j=0;
        String[] res=new String[words.length];
        for(String str:words){
            for(int i=0;i<str.length;i++){
                if(row1.contains(str.charAt[i].toLowerCase())){
                    row=1;
                }
                else if(row2.contains(str.charAt[i].toLowerCase())){
                    row=2;
                }
                else{
                    row=3;
                }
                if(i==0){
                    first=row;
                    continue;
                }
                if(row!=first){
                    break;
                }
                if(i==str.length){
                    res[j++]=str;
                }
            }
        }
        return res;
    }
}