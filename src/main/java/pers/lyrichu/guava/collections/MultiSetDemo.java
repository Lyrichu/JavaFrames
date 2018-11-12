package pers.lyrichu.guava.collections;

import java.util.Set;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class MultiSetDemo {
  /*
  统计单词的出现次数
   */
  public static void main(String[] args) {
    String str = "this is a cat and that is a mice where is the food";
    // 分割字符串
    String[] splits = str.split(" ");
    // 存储到MultiSet
    Multiset<String> ms = HashMultiset.create();
    for(String s:splits)
      ms.add(s);
    // 获取所有不重复单词的set
    Set<String> sets = ms.elementSet();
    // 打印出单词:count
    for(String s:sets)
      System.out.println(s+":"+ms.count(s));
  }
}
