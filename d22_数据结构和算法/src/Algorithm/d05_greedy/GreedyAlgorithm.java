package Algorithm.d05_greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GreedyAlgorithm {

    public static void main(String[] args) {
        HashMap<String, HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();  //所有广播电台及覆盖地区

        HashSet<String> hashSet1 = new HashSet<String>();       //每个电台覆盖的地区
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        //加入到map
        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);


        //allAreas 存放所有的地区
        HashSet<String> allAreas = new HashSet<String>();       //创建一个set集合存放所有地区
        for (String key : broadcasts.keySet()) {                   //遍历map的所有key
            for (String s : broadcasts.get(key)) {                 //根据遍历得到的key，得到map对应的set集合，遍历这个set集合
                allAreas.add(s);                                //把遍历这个set集合得到的城市加入到我们的allAreas中
            }
        }
        //System.out.println(allAreas);


        //创建ArrayList, 存放已选择的电台集合
        ArrayList<String> selects = new ArrayList<String>();

        //临时的集合，存放遍历过程中的某电台覆盖的地区和当前所有未覆盖的地区的交集（也就是该电台能覆盖的未覆盖地区）
        HashSet<String> tempSet = new HashSet<String>();
        //临时的指针
        String maxKey = null;

        while (allAreas.size() != 0) {       //allAreas当前所有未覆盖地区，不断减少，当为0时说明全都覆盖则推出循环
            maxKey = null;      //每次循环第一步需要把maxKey置空

            for (String key : broadcasts.keySet()) {      //遍历 broadcasts的key集合, 取出对应key（k1，k2....// ）
                tempSet.clear();        //清空

                Set areas = broadcasts.get(key);         //当前这个key能够覆盖的地区
                tempSet.addAll(areas);                   //当前key能覆盖的地区加入tempset

                tempSet.retainAll(allAreas);             //求出tempSet和allAreas集合的交集（当前集合包含的未覆盖地区的数量）交集会赋给 tempSet
                //如果当前集合包含的未覆盖地区的数量，比maxKey指向的集合地区还多，就需要重置maxKey
                if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size())) {
                    maxKey = key;
                }
            }
            if (maxKey != null) {        //maxKey != null, 就应该将maxKey 加入selects
                selects.add(maxKey);
                allAreas.removeAll(broadcasts.get(maxKey));      //将maxKey指向的广播电台覆盖的地区从 allAreas 去掉
            }
        }
        //循环条件是：while(allAreas.size() != 0)，出循环说明所有地区都被覆盖
        System.out.println("得到的选择结果是" + selects);//[K1,K2,K3,K5]

    }

}
