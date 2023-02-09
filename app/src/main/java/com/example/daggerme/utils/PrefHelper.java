package com.example.daggerme.utils;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

import dagger.Module;


public class PrefHelper {

    Context context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public PrefHelper(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("HopeInfo",MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void put(String key, String value){
        editor.putString(key, value);
        editor.commit();
    }

    public void put(String key, int value){
        editor.putInt(key, value);
        editor.commit();
    }

    public void put(String key, long value){
        editor.putLong(key, value);
        editor.commit();
    }

    public void put(String key, float value){
        editor.putFloat(key, value);
        editor.commit();
    }

    public void put(String key, boolean value){
        editor.putBoolean(key, value);
        editor.commit();
    }

    public SharedPreferences pref(){
        return sharedPreferences;
    }

    public void delete(String key){
        editor.remove(key);
        editor.commit();
    }

}
