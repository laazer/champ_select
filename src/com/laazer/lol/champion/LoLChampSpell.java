package com.laazer.lol.champion;
import java.util.List;
import com.laazer.common.Box;
import com.laazer.lol.LoLObject;

public class LoLChampSpell implements LoLObject{
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
    
}

