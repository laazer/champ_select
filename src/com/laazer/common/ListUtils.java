package com.laazer.common;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
    
    public static <K, T> List<T> map(List<K> list, UniFunction<K, T> f) {
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
    
    
    public static <K, T> T fold(T base, BinFunction<T, T> f, List<K> list, UniFunction<K, T> transform) {
        if(list.isEmpty()) {return base;}
        else {
            K tmp = list.remove(0);
            return fold(f.apply(base, transform.apply(tmp)), f, list, transform);
        }
    }
    
    
    private static class ToSame<T> implements UniFunction<T, T> {
        @Override
        public T apply(T value) {
            return value;
        }
        
    }
    
    public static UniFunction<Object, List<Object>> toList = new ToList();
    private static class ToList implements UniFunction<Object, List<Object>> {
        @Override
        public List<Object> apply(Object value) {
            return (List<Object>) value;
        }
        
    }
    
    public static UniFunction<Object, List<String>> toStringList = new ToStringList();
    private static class ToStringList implements UniFunction<Object, List<String>> {
        @Override
        public List<String> apply(Object value) {
            return ListUtils.map(ListUtils.toList.apply(value), Functions.toString);
        }
    }
    
    public static UniFunction<Object, List<Integer>> toIntList = new ToIntList();
    private static class ToIntList implements UniFunction<Object, List<Integer>> {
        @Override
        public List<Integer> apply(Object value) {
            return ListUtils.map(ListUtils.toList.apply(value), Functions.toInt);
        }
    }
}
