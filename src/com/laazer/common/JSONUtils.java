package com.laazer.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.json.*;
import com.json.parsers.JSONParser;

public class JSONUtils {
    
    //TODO create methods that turn JSON arrays into java lists and maps
    
    public static Function<JSONObject, String> toString = new ToString(); 
    
    public static List<JSONObject> jArrayToList(JSONArray jarray) throws JSONException {
        List<JSONObject> jlist = new ArrayList<JSONObject>();
        for(int i = 0; i < jarray.length(); i++){
           jlist.add(jarray.getJSONObject(i));
        }
        return jlist;        
    }
    
    public static <R> List<R> mappedList(JSONArray jarray, Function<JSONObject, R> f) throws JSONException {
        return ListUtils.map(JSONUtils.jArrayToList(jarray), f);
    }
    
    private static class ToString implements Function<JSONObject, String> {
        @Override
        public String apply(JSONObject value) {
            return value.toString();
        }
    }
}
