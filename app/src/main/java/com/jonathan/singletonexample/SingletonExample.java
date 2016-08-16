package com.jonathan.singletonexample;

import android.util.Log;

/**
 * Created by jonathanherrmann on 16/08/2016.
 */
public class SingletonExample {

    private static SingletonExample instance = null;
    private String username;

    private SingletonExample(){}

    public static SingletonExample getInstance(){
        if (instance == null){
            instance = new SingletonExample();
        }
        return instance;
    }

    protected static void printSingletonMethod(){
        Log.e("JO", "Example method for singleton");
    }

    public String getUsername() {
        return username;
    }

    public SingletonExample setUsername(String username) {
        this.username = username;
        return this;
    }
}
