package com.jonathan.singletonexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        Button buttonLogin = (Button) findViewById(R.id.button_login);
        final EditText editUsername = (EditText) findViewById(R.id.edit_username);
        final SingletonExample testSingleton = SingletonExample.getInstance();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SingletonExample.getInstance().setUsername(editUsername.getText().toString());
                testSingleton.printSingletonMethod();

                Intent welcomeActivityIntent = new Intent(LoginActivity.this, WelcomeActivity.class);
                startActivity(welcomeActivityIntent);
            }
        });

    }
}
