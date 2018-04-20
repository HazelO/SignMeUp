package com.example.hazel.signmeup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RegisterActivity extends MainActivity {

    TextView welcomeMsgTextView;
    Button backButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        welcomeMsgTextView = (TextView) findViewById(R.id.welome_msg);
        backButton = (Button) findViewById(R.id.button);

        welcomeMsgTextView.setText("Thank you for signing up, " + getIntent().getStringExtra(Constants.KEY_USERNAME));

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(startIntent);
                finish();
            }
        });
    }
}
