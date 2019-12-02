package String;

/**
 * @ClassName SubString
 * @Description
 * @Date 2019/12/2
 * @Created by lizhanxu
 */
public class SubString {
    public static void main(String[] args) {
        String s="abcdbbfcba";
        System.out.println(longestPalindrome(s));
//        System.out.println(forcelongestPalindrome("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz"));
    }

    public static String longestPalindrome(String s){
        int len = s.length();

        //特殊处理
        if(s==null||s.length()==0){
            return "";
        }

        //求得反序串
        char[] chars = s.toCharArray();
        char[] reverse = new char[len];
        for(int i=len-1;i>=0;i--){
            reverse[len-i-1] = chars[i];
        }

        //m为该公共子串在原串中的末尾下标
        //max为最大公共子串的长度
        int m=0,max=0;
        //二维矩阵
        int[][] arrays = new int[len][len];
        for(int i=0;i<len;i++){//原始串
            for(int j=0;j<len;j++){//反序串
                if(reverse[j]==chars[i]){
                    if(i>0&&j>0){
                        if(reverse[j-1]!=chars[i-1]){
                            arrays[i][j]=1;
                        }else
                            arrays[i][j]=arrays[i-1][j-1]+1;//填充最大公共子串长度
                    }
                    if(i==0||j==0){
                        arrays[i][j]=1;
                    }
                    //增加(len-1-j + arrays[i][j] - 1 == i)判断，目的是过滤最大公共子串中的非回文串；
                    //len-1-j 为反序子串末尾下标在原始串中的对应位置，i 为该子串在原始串中的末尾下标
                    //len-1-j 应该与 i 回文对应
                    //因此
                    if(arrays[i][j]>max&&(len-1-j + arrays[i][j] - 1 == i)){
                        m=i;
                        max=arrays[i][j];
                    }
                }
            }
        }
        return s.substring(m-(max-1),max);
    }

    //暴力解法
    public static String forcelongestPalindrome(String s){
         String res = "";
         if(s==null||s.length()==0){
             return "";
         }
         if(s.length()==1){
             return s;
         }
         int len = s.length();
         for(int i=0;i<len;i++){
             for(int j=i+1;j<=len;j++){
                 if(judge(s.substring(i,j))&&(s.substring(i,j).length()>res.length())){
                     res=s.substring(i,j);
                 }
             }
         }
         return res;
    }

    //判断是否为回文串
    public static boolean judge(String s){
        int len=s.length();
        for(int i=0;i<len/2;i++){
            if(s.charAt(i)!=s.charAt(len-i-1)){
                return false;
            }
        }
        return true;
    }
}
