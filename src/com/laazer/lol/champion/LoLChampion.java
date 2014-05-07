package com.laazer.lol.champion;

import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
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
    
    LoLChampion(int id) throws JSONException {
        this.id = id;
        JSONObject obj = this.generateJson(); 
        this.freeToPlay = obj.getBoolean("freetoplay");
        this.key = obj.getString("key"); this.name = obj.getString("name");
        this.title = obj.getString("title"); this.blurb = obj.getString("blurb"); 
        this.allyTips = JSONUtils.mappedList(obj.getJSONArray("allytips"), JSONUtils.toString);
        this.enemyTips = JSONUtils.mappedList(obj.getJSONArray("enemytips"), JSONUtils.toString);
        this.image = new LoLImage(obj.getJSONObject("image")); 
        this.lore = obj.getString("lore");
        this.recommended = JSONUtils.mappedList(obj.getJSONArray("recommended"), LoLUtils.toRecommended);
        this.passive = new LoLPassive(obj.getJSONObject("passive"));
        this.partype = obj.getString("partype");
        this.skins = JSONUtils.mappedList(obj.getJSONArray("skins"), LoLUtils.toSkin);
        this.spells = JSONUtils.mappedList(obj.getJSONObject("spells"), LoLUtils.toSpell);
        this.stats = new LoLStats(obj.getJSONObject("stats"));
        this.tags = JSONUtils.mappedList(obj.getJSONArray("tags"), JSONUtils.toString);
    }

    private JSONObject generateJson() {
        //TODO make url an input
        JSONParser parser = new JSONParser();
        JSONObject jobj = (JSONObject) parser.parseJson(UrlManager.executeGet(LocURL + this.id + "champData=all&" + LoLObject.KEY));
        return jobj;
    }
    
  
    
}
