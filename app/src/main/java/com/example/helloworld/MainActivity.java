package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_1);
    }

    public void goToConstraintActivity(View view) {
        Intent intent = new Intent(this, ConstraintActivity.class);
        startActivity(intent);
    }

    public void goToLoginPage(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void goToSelectContractPage(View view) {
        Intent intent = new Intent(this, SelectContractActivity.class);
        startActivity(intent);
    }
}
