package com.laazer.lol;

import org.json.JSONObject;

import com.laazer.common.Function;
import com.laazer.common.JSONUtils;
import com.laazer.lol.champion.*;

public class LoLUtils extends LoLObject{
    
    public static Function<Object, LoLRecommended> toRecommended = new ToRecommended();
    public static Function<Object, LoLSkin> toSkin = new ToSkin();
    public static Function<Object, LoLSpellVars> toSpellVar = new ToSpellVars();
    public static Function<Object, LoLChampSpell> toChampSpell = new ToChampSpell();
    public static Function<Object, LoLImage> toImage = new ToImage();
    
    private static class ToRecommended implements Function<Object, LoLRecommended> {
        public LoLRecommended apply(Object value) {
            return new LoLRecommended().genLoLRecommened(JSONUtils.toJSONObject.apply(value));
        }
    }
    
    private static class ToSkin implements Function<Object, LoLSkin> {
        public LoLSkin apply(Object value) {
            return new LoLSkin().genLoLSkin(JSONUtils.toJSONObject.apply(value));
        }
    }
    
    private static class ToSpellVars implements Function<Object, LoLSpellVars> {
        public LoLSpellVars apply(Object value) {
            return new LoLSpellVars().genSpellVars(JSONUtils.toJSONObject.apply(value));
        }
    }
    
    private static class ToChampSpell implements Function<Object, LoLChampSpell> {
        public LoLChampSpell apply(Object value) {
            return new LoLChampSpell().genChampSpell(JSONUtils.toJSONObject.apply(value));
        }
    }
    
    private static class ToImage implements Function<Object, LoLImage> {
        public LoLImage apply(Object value) {
            return new LoLImage().genImage(JSONUtils.toJSONObject.apply(value));
        }
    }
    
}
