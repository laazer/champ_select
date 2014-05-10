package com.laazer.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.json.*;
import com.json.parsers.JSONParser;

public class JSONUtils {
    
    public static Function<Object, JSONObject> toJSONObject = new ToJSONObject();
    
    public static List<Object> jArrayToList(JSONArray jarray) throws JSONException {
        List<Object> jlist = new ArrayList<Object>();
        for(int i = 0; i < jarray.length(); i++){
           jlist.add(jarray.getJSONObject(i));
        }
        return jlist;        
    }
    
    public static <R> List<R> mappedList(JSONArray jarray, Function<Object, R> f) throws JSONException {
        return ListUtils.map(JSONUtils.jArrayToList(jarray), f);
    }
    
    private static class ToJSONObject implements Function<Object, JSONObject> {
        @Override
        public JSONObject apply(Object value) {
            return (JSONObject) value;
        }
    }
    
}
