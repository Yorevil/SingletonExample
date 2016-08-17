package com.jonathan.singletonexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InformationActivity extends AppCompatActivity {

    private Button validatedInformation;
    private EditText editLastname;
    private EditText editFirstname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        validatedInformation = (Button) findViewById(R.id.valide_information_button);
        editLastname = (EditText) findViewById(R.id.last_name_text);
        editFirstname = (EditText) findViewById(R.id.first_name_text);

        validatedInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveFirstnameToCache();
                saveLastnameToCache();
                Intent welcomeActivityIntent = new Intent(InformationActivity.this, WelcomeActivity.class);
                startActivity(welcomeActivityIntent);
            }
        });


    }

    public void saveFirstnameToCache(){
        Cache.getInstance().getLruCache().put("person_firstname", editFirstname.getText().toString()); // Cache LRU
    }

    public void saveLastnameToCache(){
        Cache.getInstance().getLruCache().put("person_lastname", editLastname.getText().toString()); // Cache LRU
    }

}
