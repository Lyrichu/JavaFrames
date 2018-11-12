package pers.lyrichu.guava.collections;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        // 只读的list
        List<String> readList = Collections.unmodifiableList(list);
        //readList.add("d"); // 不可以直接对视图进行修改
        list.add("d");// 直接对list进行更改,视图也一起改变,不够安全
        // guava的只读设置,安全可靠
        List<String> immutableList = ImmutableList.of("a","b","c");
        // immutableList.add("d"); // java.lang.UnsupportedOperationException
    }
}
