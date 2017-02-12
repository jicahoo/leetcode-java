package com.flash.interview;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by zhangj52 on 2/12/2017.
 */
public class RemoveNullFromMap {

    public void removeNullFromMap(Map<String, String> map) {
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            if (entry.getValue() == null) {
                iterator.remove();
            }
        }

    }

    public void removeNullFromMapJava8(Map<String, String> map) {
        map.entrySet().removeIf(e -> e.getValue() == null);
    }

    public static void main(String[] args) {
        RemoveNullFromMap s = new RemoveNullFromMap();
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", null);
        s.removeNullFromMap(map);
        System.out.println(map.containsKey("2"));
        System.out.println(map.get("2"));
        System.out.println(map.get("3"));

        map.put("2", null);
        System.out.println(map.containsKey("2"));
        s.removeNullFromMapJava8(map);
        System.out.println(map.containsKey("2"));
        System.out.println(map.get("2"));

    }
}

