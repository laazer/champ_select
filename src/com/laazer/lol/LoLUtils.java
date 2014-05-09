package com.laazer.lol;

import org.json.JSONObject;

import com.laazer.common.Function;
import com.laazer.lol.champion.*;

public class LoLUtils extends LoLObject{
    
    public static Function<JSONObject, LoLRecommended> toRecommended = new ToRecommended();
    public static Function<JSONObject, LoLSkin> toSkin = new ToSkin();
    public static Function<JSONObject, LoLSpellVars> toSpellVar = new ToSpellVars();
    public static Function<JSONObject, LoLChampSpell> toChampSpell = new ToChampSpell();
    public static Function<JSONObject, LoLImage> toImage = new ToImage();
    
    
    private static class ToRecommended implements Function<JSONObject, LoLRecommended> {
        public LoLRecommended apply(JSONObject value) {
            return new LoLRecommended().genLoLRecommened(value);
        }
    }
    
    private static class ToSkin implements Function<JSONObject, LoLSkin> {
        public LoLSkin apply(JSONObject value) {
            return new LoLSkin().genLoLSkin(value);
        }
    }
    
    private static class ToSpellVars implements Function<JSONObject, LoLSpellVars> {
        public LoLSpellVars apply(JSONObject value) {
            return new LoLSpellVars().genSpellVars(value);
        }
    }
    
    private static class ToChampSpell implements Function<JSONObject, LoLChampSpell> {
        public LoLChampSpell apply(JSONObject value) {
            return new LoLChampSpell().genChampSpell(value);
        }
    }
    
    private static class ToImage implements Function<JSONObject, LoLImage> {
        public LoLImage apply(JSONObject value) {
            return new LoLImage().genImage(value);
        }
    }
    
}
