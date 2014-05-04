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

public class LoLChampion implements LoLObject{
    final static String URL = LoLObject.URL + "static-data/NA/v1.2/champion/";
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
        this.spells = obj.getJSONObject("spells");
        this.stats = obj.getJSONObject("stats");
        this.tags = obj.getJSONArray("tags");
    }

    private JSONObject generateJson() {
        JSONParser parser = new JSONParser();
        JSONObject jobj = (JSONObject) parser.parseJson(UrlManager.executeGet(URL + this.id));
        return jobj;
    }
    
    
}
