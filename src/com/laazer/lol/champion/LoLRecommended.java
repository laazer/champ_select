package com.laazer.lol.champion;
import java.util.List;

import org.json.JSONObject;

import com.laazer.lol.LoLObject;

public class LoLRecommended implements LoLObject{
    List<LoLBlock> blocks;
    String champion;
    String map;
    String mode;
    boolean priority;
    String tutke;
    String type;
    public LoLRecommended(JSONObject value) {
        // TODO Auto-generated constructor stub
    }
}
