package com.jonathan.singletonexample;

import android.util.LruCache;

/**
 * Created by jonathanherrmann on 17/08/2016.
 */
public class Cache {

    private static Cache instance;
    private LruCache<String, Object> lruCache;

    private Cache(){
        lruCache = new LruCache<>(1024); // random size
    }

    public static Cache getInstance(){
        if (instance == null){
            instance = new Cache();
        }

        return instance;
    }

    public LruCache<String, Object> getLruCache(){
        return lruCache;
    }
}
