package com.CtrlAltDefeat.Planner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import com.CtrlAltDefeat.Planner.R;
import android.os.Bundle;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }
}