package com.laazer.lol;

import org.json.JSONObject;

public interface LoLObject {
    final static String URL = "https://prod.api.pvp.net/api/lol/";
    final static String NA = "na";
    final static String EUW = "euw";
    final static String BR = "br";
    public JSONObject generateJson();
}
