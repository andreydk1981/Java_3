package Lesson_5_class;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionsApp {
    public static void main(String[] args) {
        List<String> list = Collections.synchronizedList(new ArrayList<>());

        /*
         * блокирует только один бакет
         */
        Map<String, String> map = new ConcurrentHashMap<>();

        /*
         * сздает копию на запись
         */
        List<String> list1 = new CopyOnWriteArrayList<>();
    }
}
