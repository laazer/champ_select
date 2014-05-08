package com.laazer.lol.champion;

import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import com.google.gson.Gson;
import com.json.parsers.*;
import com.laazer.common.Function;
import com.laazer.common.JSONUtils;
import com.laazer.common.ListUtils;
import com.laazer.common.UrlManager;
import com.laazer.lol.LoLObject;
import com.laazer.lol.LoLUtils;
import com.laazer.lol.Region;
import java.lang.Class;

public class LoLChampion extends LoLObject{
    final static String LocURL = LoLObject.URL + "static-data/"+ Region.NA +"/v1.2/champion/?";
    int id;
    boolean freeToPlay;
    String key, name, title, blurb, lore, partype;;
    List<String> allyTips, enemyTips, tags;
    LoLImage image;
    LoLInfo info;
    LoLPassive passive;
    List<LoLRecommended> recommended;
    List<LoLSkin> skins;
    List<LoLChampSpell> spells;
    LoLStats stats;
    
    LoLChampion() {

    }

    private static JSONObject generateJson(int id) {
        //TODO make url an input
        JSONParser parser = new JSONParser();
        JSONObject jobj = (JSONObject) parser.parseJson(UrlManager.executeGet(LocURL + id + "champData=all&" + LoLObject.KEY));
        return jobj;
    }
    
    public LoLChampion genChampion(JSONObject obj) throws JSONException {
        LoLChampion champ = new LoLChampion();
        champ.id = obj.getInt("id");
        champ.freeToPlay = obj.getBoolean("freetoplay");
        champ.key = obj.getString("key"); this.name = obj.getString("name");
        champ.title = obj.getString("title"); this.blurb = obj.getString("blurb"); 
        champ.allyTips = JSONUtils.mappedList(obj.getJSONArray("allytips"), JSONUtils.toString);
        champ.enemyTips = JSONUtils.mappedList(obj.getJSONArray("enemytips"), JSONUtils.toString);
        champ.image = new LoLImage().genImage(obj.getJSONObject("image")); 
        champ.lore = obj.getString("lore");
        champ.recommended = JSONUtils.mappedList(obj.getJSONArray("recommended"), LoLUtils.toRecommended);
        champ.passive = new LoLPassive(obj.getJSONObject("passive"));
        champ.partype = obj.getString("partype");
        champ.skins = JSONUtils.mappedList(obj.getJSONArray("skins"), LoLUtils.toSkin);
        champ.spells = JSONUtils.mappedList(obj.getJSONArray("spells"), LoLUtils.toChampSpell);
        champ.stats = new LoLStats().genLoLStats(obj.getJSONObject("stats"));
        champ.tags = JSONUtils.mappedList(obj.getJSONArray("tags"), JSONUtils.toString);
        return champ;
    }
    
    public LoLChampion genChampion(int id) throws JSONException {
        return genChampion(LoLChampion.generateJson(id));
    }
    
  
    
}
