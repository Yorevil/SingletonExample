package com.jonathan.singletonexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        TextView welcomeText = (TextView) findViewById(R.id.text_view_welcome);
        //welcomeText.setText("Welcome : " + SingletonExample.getInstance().getUsername());
        String string = Cache.getInstance().getLruCache().get("person_lastname").toString() + " " + Cache.getInstance().getLruCache().get("person_firstname").toString();
        welcomeText.setText(string);
    }
}
