package pers.lyrichu.guava.collections;

import java.util.HashMap;
import java.util.Map;

public class MultiMapDemo {
  public static void main(String[] args){
    Map<String,String> cours = new HashMap<String, String>();
    // 加入测试数据
    cours.put("改革开放", "邓爷爷");
    cours.put("三个代表", "江主席");
    cours.put("科学发展观", "胡主席");
    cours.put("和谐社会", "胡主席");
    cours.put("八荣八耻", "胡主席");
    cours.put(".1..", "习主席");
    cours.put("..2.", "习主席");
    cours.put(".3..", "习主席");

  }
}
