package mysql;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1,2,3,4,1,2,4,23,1,53,4,23,23,2 );
        String str = UUID.randomUUID().toString()+"PNG";
        String name = false ? str : "\t"+str;
        System.out.println(name );
//        list = distincted(list);
//
//        System.out.println(list );



    }

    public static List<Integer> distincted(List<Integer> list){
        List<Integer> l = new ArrayList<>( list.size() );
        for (Integer i : list) {
            if(!l.contains(i)){
                l.add(i);
            }
        }
        return l;
    }
}
