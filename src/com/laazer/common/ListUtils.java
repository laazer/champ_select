package com.laazer.common;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
    
    public static <K, T> List<T> map(List<K> list, Function<K, T> f) {
        List<T> result = new ArrayList<T>();
        for(int i = 0; i < list.size(); i++) {
            result.add(f.apply(list.get(i)));
        }
        return result;
    }
    
    public static <T> List<T> arrayToList(T[] array) {
        List<T> list = new ArrayList<T>();
        for(int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }
    
}
