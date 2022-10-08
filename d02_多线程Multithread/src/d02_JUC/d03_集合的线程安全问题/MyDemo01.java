package d02_JUC.d03_集合的线程安全问题;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

/**
 * List问题演示
 */
public class MyDemo01 {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                myList.add(UUID.randomUUID().toString().substring(0,4));

                System.out.println(myList);

            },String.valueOf(i)).start();
        }
    }
}

