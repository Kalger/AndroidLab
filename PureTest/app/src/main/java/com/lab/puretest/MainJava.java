package com.lab.puretest;

import android.animation.ObjectAnimator;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Set;

public class MainJava implements JsonDeserializer<Timestamp> {
    Iterable a;
    Collection b;
    ArrayList c;
    Object d;
    String e;
    LinkedHashMap f;


    private void testFun(){
        dataJava data = new dataJava();
        data.num =6;
    }

    @Override
    public Timestamp deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return null;
    }
}
