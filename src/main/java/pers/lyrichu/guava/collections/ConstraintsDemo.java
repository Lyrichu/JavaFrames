package pers.lyrichu.guava.collections;

import com.google.common.base.Preconditions;
import com.google.common.collect.Constraint;
import com.google.common.collect.Constraints;
import com.google.common.collect.Sets;

import java.util.Set;

/*
加入约束条件:非空、长度验证
Constraint
Predications
Constraints
 */
public class ConstraintsDemo {
    public static void main(String[] args){
        Set<String> sets = Sets.newHashSet();
        // 创建约束
        Constraint<String> constraint = new Constraint<String>() {
            public String checkElement(String s) {
                // 非空验证
                Preconditions.checkNotNull(s);
                // 验证长度为5-20的字符串
                Preconditions.checkArgument(s.length() >= 5 && s.length() <= 20);
                return s;
            }
        };
        Set<String> cs = Constraints.constrainedSet(sets,constraint);
        //cs.add(null); //java.lang.NullPointerException
        //cs.add("good"); // 长度不合法,java.lang.IllegalArgumentException
        cs.add("china");
        cs.add("English");
        for(String s:cs)
          System.out.println(s);
    }
}
