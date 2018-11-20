package pers.lyrichu.apache.commons.text;

import org.apache.commons.text.similarity.LevenshteinDistance;

public class LevenshteinDistanceExample {
    public static void main(String[] args) {
      String str1 = "#人人网被卖了#";
      String str2 = "人人网卖身";
      int editDis = editDistance(str1,str2);
      double similarity = editDis*1.0/Math.max(str1.length(),str2.length());
      System.out.println("editDistance:"+editDis);
      System.out.println("similarity:"+similarity);
    }

    // 计算两个字符串的编辑距离
    private static int editDistance(String str1,String str2) {
      return LevenshteinDistance.getDefaultInstance().apply(str1,str2);
    }
}
