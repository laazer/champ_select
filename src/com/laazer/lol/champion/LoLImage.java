package com.laazer.lol.champion;

import org.json.JSONException;
import org.json.JSONObject;

import com.laazer.lol.LoLObject;

public class LoLImage implements LoLObject {
    String full;
    String group;
    String sprite;
    int h;
    int w;
    int x;
    int y;
    
    public LoLImage(JSONObject jsonObject) throws JSONException {
        this.full = jsonObject.getString("full");
        this.group = jsonObject.getString("group");
        this.sprite = jsonObject.getString("sprite");
        this.h = jsonObject.getInt("h"); this.w = jsonObject.getInt("w");
        this.x = jsonObject.getInt("x"); this.y = jsonObject.getInt("y");
    }

}
