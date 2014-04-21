package com.laazer.lol;
import java.util.List;

public class Champion implements LoLObject{
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
    
    
}
