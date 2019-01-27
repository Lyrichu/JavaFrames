package pers.lyrichu.ml.hanlp.demo;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.collection.AhoCorasick.AhoCorasickDoubleArrayTrie;
import com.hankcs.hanlp.dictionary.CoreDictionary;
import com.hankcs.hanlp.dictionary.CustomDictionary;

/*
 * 关于用户的自定义词典
 */
public class CustomDictionaryDemo {
    public static void main(String[] args) {
        customDic();
    }

    private static void customDic() {
        // CustomDictionary 是全局词典，可以动态增删词语
        // 动态增加一个词语
        CustomDictionary.add("攻城狮");
        // 强行插入,nz表示其他专名
        CustomDictionary.insert("白富美", "nz 1024");
        System.out.println(CustomDictionary.add("单身狗", "nz 1024 n 1"));
        System.out.println(CustomDictionary.get("单身狗"));
        String text = "攻城狮逆袭单身狗，迎娶白富美，走上人生巅峰";
        // AhoCorasickDoubleArrayTrie自动机扫描文本中出现的自定义词语
        final char[] charArray = text.toCharArray();
        CustomDictionary.parseText(charArray, new AhoCorasickDoubleArrayTrie.IHit<CoreDictionary.Attribute>()
        {
            @Override
            public void hit(int begin, int end, CoreDictionary.Attribute value)
            {
                System.out.printf("[%d:%d]=%s %s\n", begin, end, new String(charArray, begin, end - begin), value);
            }
        });

        // 自定义词典在所有分词器中都有效
        System.out.println(HanLP.segment(text));
    }
}
