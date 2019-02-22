package pers.lyrichu.guava.collections;

import java.util.Set;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

public class SetsDemo {
  /*
  集合的操作:
  1.交集 Sets.intersection
  2.差集:Sets.difference()
  3.并集:Sets.union()
   */
  public static void main(String args[]) {
    Set<Integer> sets1 = Sets.newHashSet(1,3,4,6);
    Set<Integer> sets2 = Sets.newHashSet(2,3,4,7,10,20);
    // 求交集
    Set<Integer> setsIntersection = Sets.intersection(sets1,sets2);
    // 求差集
    Set<Integer> setsDifference = Sets.difference(sets1,sets2);
    // 求并集
    Set<Integer> setsUnion = Sets.union(sets1,sets2);
    printSets("setsIntersection",setsIntersection);
    printSets("setsDifference",setsDifference);
    printSets("setsUnion",setsUnion);
  }

  public static void printSets(String name,Set<Integer> set){
    System.out.println(name+":");
    for(Integer i:set)
      System.out.print(i+" ");
    System.out.println();
  }
}
