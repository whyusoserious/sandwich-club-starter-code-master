package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;
import java.util.ArrayList;
import  java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException{
        String name, desc, img, place;

        List<String> list = new ArrayList<>();
        List<String> foodlist = new ArrayList<>();

        JSONObject jameson = new JSONObject(json);
        JSONObject Jname = jameson.getJSONObject("Jname");
        name = Jname.getString("mainName");

        JSONArray array = Jname.getJSONArray("asArray");
        if (array != null)
        {
            for (int i = 0; i < array.length(); i++)
            {
                list.add(array.getString(i));
            }
        }
        JSONArray food = jameson.getJSONArray("food");
        if (food != null)
        {
            for (int i = 0; i < food.length(); i++)
            {
                foodlist.add(food.getString(i));
            }
        }
        place = jameson.getString("place");
        desc = jameson.getString("desc");
        img = jameson.getString("img");
        return new Sandwich(name, list, place, desc, img, foodlist);
    }
}
