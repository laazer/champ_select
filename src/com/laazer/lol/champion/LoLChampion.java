package com.laazer.lol.champion;

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import com.json.parsers.*;
import com.laazer.common.UrlManager;
import com.laazer.lol.LoLObject;
import com.laazer.common.UrlManager;

public class LoLChampion implements LoLObject{
    final static String URL = LoLObject.URL + "static-data/NA/v1.2/champion/";
    int id;
    boolean freeToPlay;
    String key;
    String name;
    String title;
    List<String> allyTips;
    String blurb;
    List<String> enemyTips;
    LoLImage image;
    LoLInfo info;
    String lore;
    String partype;
    LoLPassive passive;
    List<LoLRecommended> recommended;
    List<LoLSkin> skins;
    List<LoLChampSpell> spells;
    LoLStats stats;
    List<String> tags;
    
    LoLChampion(int id) throws JSONException {
        this.id = id;
        JSONObject obj = this.generateJson(); 
        this.freeToPlay = obj.getBoolean("freetoplay");
        this.key = obj.getString("key"); this.name = obj.getString("name");
        this.title = obj.getString("title"); this.allyTips = obj.getJSONArray("allytips");
        this.blurb = obj.getString("blurb"); this.enemyTips = obj.getJSONArray("enemytips");
        this.image = obj.getJSONObject("image"); 
        this.lore = obj.getString("lore");
        this.recommended = obj.getJSONObject("recommended");
        this.passive = obj.getJSONObject("passive");
        this.partype = obj.getString("partype");
        this.skins = obj.getJSONObject("skins");
        this.spells = obj.getJSONObject("spells");
        this.stats = obj.getJSONObject("stats");
        this.tags = obj.getJSONArray("tags");
    }

    @Override
    public JSONObject generateJson() {
        JSONParser parser = new JSONParser();
        JSONObject jobj = (JSONObject) parser.parseJson(UrlManager.executeGet(URL + this.id));
        return jobj;
    }
    
}
