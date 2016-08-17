package com.jonathan.singletonexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private Button buttonLogin;
    private EditText editUsername;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        buttonLogin = (Button) findViewById(R.id.button_login);
        editUsername = (EditText) findViewById(R.id.edit_username);
        final SingletonExample testSingleton = SingletonExample.getInstance();
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //SingletonExample.getInstance().setUsername(editUsername.getText().toString());
                //testSingleton.printSingletonMethod();
                saveUsernameToCache();
                Intent welcomeActivityIntent = new Intent(LoginActivity.this, InformationActivity.class);
                startActivity(welcomeActivityIntent);
            }
        });
    }

    public void saveUsernameToCache(){
        Cache.getInstance().getLruCache().put("user_name", editUsername.getText().toString()); // Cache LRU
    }

    public void retrieveUsernameFromCache(){
        editUsername = (EditText) Cache.getInstance().getLruCache().get("user_name");
    }
}
