package com.example.hazel.signmeup;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int MIN_AGE = 18;

    EditText legalName, email, userName, age;
    Button dob, submit;
    DatePickerDialog pickDOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        legalName = findViewById(R.id.name);
        email = findViewById(R.id.email);
        userName = findViewById(R.id.username);
        age = findViewById(R.id.age);
        dob = findViewById(R.id.dob);

        age.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int age = 0;

                try {
                    age = Integer.parseInt(s.toString());
                } catch (NumberFormatException ignored) {
                    Toast toast = new Toast(MainActivity.this);
                    toast.setText("Please enter correct age in digits");
                    toast.show();
                }

                if (age < MIN_AGE) {
                    submit.setEnabled(false);
                } else {
                    submit.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        dob.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (pickDOB == null) {
                        pickDOB = new DatePickerDialog(MainActivity.this);
                    }

                    pickDOB.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            dob.setText(month+ "/" + dayOfMonth + "/" + year);

                            if (year >= 2000) {
                                submit.setEnabled(false);
                            } else {
                                submit.setEnabled(true);
                            }
                        }
                    });
                    pickDOB.show();
                }

            }
        );
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameValue =  userName.getText().toString();
                Intent startIntent = new Intent(MainActivity.this, RegisterActivity.class);
                startIntent.putExtra(Constants.KEY_USERNAME, usernameValue);
                startActivity(startIntent);

                finish();
            }
        });
    }

}
