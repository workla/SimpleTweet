package com.codepath.apps.restclienttemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ComposeActivity extends AppCompatActivity {

    public static final int MAX_TWEET_LENGTH = 280;
    EditText etCompose;
    Button btnTweet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

        etCompose = findViewById(R.id.etCompose);
        btnTweet = findViewById(R.id.btnTweet);

        //btn on click listener
        btnTweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = etCompose.getText().toString();
                if (s.isEmpty()) {
                    Toast.makeText(ComposeActivity.this, "You did not enter any text.  Try again", Toast.LENGTH_LONG).show();
                    return;
                }
                else if (s.length() > MAX_TWEET_LENGTH) {
                    Toast.makeText(ComposeActivity.this, "Your tweet is more than 280 characters.  Try again", Toast.LENGTH_LONG).show();
                    return;
                }
                else {
                    //make API call to post tweet
                    Toast.makeText(ComposeActivity.this, s, Toast.LENGTH_LONG).show();
                    return;
                }
            }
        });
    }
}