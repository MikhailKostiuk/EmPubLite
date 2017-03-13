package com.example.empublite;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SimpleContentActivity extends AppCompatActivity {

    public static final String EXTRA_FILE = "file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getFragmentManager().findFragmentById(android.R.id.content) == null) {
            String file = getIntent().getStringExtra(EXTRA_FILE);
            Fragment fragment = SimpleContentFragment.newInstance(file);

            getFragmentManager().beginTransaction().add(android.R.id.content, fragment).commit();
        }
    }
}
