package com.laazer.lol.champion;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import com.laazer.common.Box;
import com.laazer.common.Functions;
import com.laazer.common.JSONUtils;
import com.laazer.common.ListUtils;
import com.laazer.lol.LoLObject;
import com.laazer.common.UniFunction;
import com.laazer.lol.LoLUtils;

public class LoLChampSpell extends LoLObject{
    List<LoLImage> altImages;
    List<Double> cooldown;
    String coolDownBurn;
    String costBurn;
    String costType;
    String description;
    List<List<Integer>> effect;
    List<String> effectBurn;
    LoLImage image;
    String key;
    LoLLevelTip levelTip;
    int maxrank;
    String name;
    Box<Integer> range;
    String rangeBurn;
    String resource;
    String sanitizedDescription;
    String sanitizedTooltip;
    String tooltip;
    List<LoLSpellVars> vars;
    
    public LoLChampSpell() {}
    
    public LoLChampSpell genChampSpell(JSONObject obj) throws JSONException {
        LoLChampSpell cs = new LoLChampSpell();
        cs.altImages = JSONUtils.mappedList(obj.getJSONArray("altimages"), LoLUtils.toImage);
        cs.cooldown = JSONUtils.mappedList(obj.getJSONArray("cooldown"), Functions.toDouble);
        cs.coolDownBurn = obj.getString("cooldownburn");
        cs.costBurn = obj.getString("costburn");
        cs.description = obj.getString("description");
        cs.effect = JSONUtils.mappedList(obj.getJSONArray("effect"), ListUtils.toList);
        return cs;
        
    }
    
}

