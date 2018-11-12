package pers.lyrichu.guava.collections;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class FunctionsDemo {
    /*
    函数式编程:解耦
    1.Predicate
    2.Function

    工具:
    1.Collections2.filter() 过滤器
    2.Collections2.transfer() 转换
    3.Functions.compose()组合式函数编程
     */
    public static void main(String[] args){
        test1();
        test2();
        test3();
    }
    public static void test1(){
        // 组合式函数编程
        // 确保容器中字符串的长度不超过5,超过后进行截取，并且全部转化为大写
        List<String> lists = Lists.newArrayList("best","food","bad"); // 静态创建list
        // 确保容器中的字符串长度不超过5,超过长度以后进行截取
        Function<String,String> f1 = new Function<String, String>() {
            public String apply(String s) {
                return s.length() > 5 ? s.substring(0,5):s;
            }
        };
        // 将字符串转化为大写
        Function<String,String> f2 = new Function<String, String>() {
            public String apply(String s) {
                return s.toUpperCase();
            }
        };
        // String = f2(f1(String));
        // 将两个函数进行组合
        Function<String,String> f = Functions.compose(f1,f2);
        // 执行转换操作(transform)
        Collection<String> resCol = Collections2.transform(lists,f);
        // 打印执行转换之后的字符串
        for(String s:resCol)
            System.out.println(s);
    }

    // 转换
    public static void test2(){
        // 类型转换,将long转化为日期格式
        Set<Long> timeSet = Sets.newHashSet();
        timeSet.add(1000000L);
        timeSet.add(9999999999L);
        timeSet.add(20000000L);
        // transform
        Collection<String> timeStrCol = Collections2.transform(timeSet, new Function<Long, String>() {
            public String apply(Long aLong) {
                return new SimpleDateFormat("yyyy-MM-dd").format(aLong);
            }
        });
        for(String s:timeStrCol)
            System.out.println(s);

    }
    // 过滤器
    public static void test3(){
        // 创建List,静态初始化
        List<String> list = Lists.newArrayList("mom","son","dad","bjsxt","refer");
        // 找出回文字符串
        //匿名内部类对象:匿名内部类，同时创建类对象
        Collection<String> palindromeList = Collections2.filter(list, new Predicate<String>() {
            public boolean apply(String s) {
                // 要使用的逻辑
                // 字符串等于反转字符串即是回文串
                return s.equals(new StringBuilder(s).reverse().toString());
            }
        });
        // 打印
        for(String palindrome:palindromeList)
            System.out.println(palindrome);
    }
}
