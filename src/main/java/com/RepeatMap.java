package com;

import org.apache.commons.collections.CollectionUtils;

import java.util.*;

public class RepeatMap {
    public static List<Map<String,Object>> removeRepeatMapByKey(List<Map<String,Object>> list, String mapKey) {
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        List<Map<String, Object>> listMap = new ArrayList<>(  );
        Map<String, Map> msp = new HashMap<>(  );
        for (int i = list.size()-1; i >= 0 ; i--) {
            Map map = list.get(i);
            String index = (String) map.get(mapKey);
            map.remove(mapKey);
            msp.put(index, map);

        }

        Set<String> mspKey = msp.keySet();
        for(String key: mspKey){
            Map newMap = msp.get(key);
            newMap.put(mapKey, key);
            listMap.add(newMap);
        }

        return listMap;
    }

    public static void main(String[] args) {
        Map<String, Map> msp = new HashMap<String, Map>();
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        List<Map<String, Object>> listMap = new ArrayList<Map<String,Object>>();
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("id", "1123");
        map1.put("name", "张三");
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("id", "2");
        map2.put("name", "李四");
        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("id", "1123");
        map3.put("name", "王五");
        Map<String, Object> map4 = new HashMap<String, Object>();
        map4.put("id", "3");
        map4.put("name", "赵六");
        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);
        System.out.println("初始数据：" + list.toString());
        System.out.println("去重之后：" + removeRepeatMapByKey(list,"id"));
    }
}
