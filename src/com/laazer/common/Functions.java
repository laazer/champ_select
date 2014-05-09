package com.laazer.common;

public class Functions {

    public static Function<Object, String> toString = new ToString();
    private static class ToString implements Function<Object, String> {
        @Override
        public String apply(Object value) {
            return value.toString();
        }
    }
    
    public static Function<Object, Double> toDouble = new ToDouble();
    private static class ToDouble implements Function<Object, Double> {
        @Override
        public Double apply(Object value) {
            return (Double) value;
        }
    }
    
    public static Function<Object, Integer> toInt = new ToInt();
    private static class ToInt implements Function<Object, Integer> {
        @Override
        public Integer apply(Object value) {
            return (Integer) value;
        }
    }
}