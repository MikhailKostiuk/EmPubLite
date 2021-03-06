package com.example.empublite;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager = null;
    private ContentsAdapter mContentsAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.pager);

        mContentsAdapter = new ContentsAdapter(this);
        mViewPager.setAdapter(mContentsAdapter);
        findViewById(R.id.progressBar).setVisibility(View.GONE);
        mViewPager.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.about: {
                Intent intent = new Intent(this, SimpleContentActivity.class)
                        .putExtra(SimpleContentActivity.EXTRA_FILE,
                                "file:///android_asset/misc/about.html");
                startActivity(intent);
                return true;
            }
            case R.id.help: {
                Intent intent = new Intent(this, SimpleContentActivity.class)
                        .putExtra(SimpleContentActivity.EXTRA_FILE,
                                "file:///android_asset/misc/help.html");
                startActivity(intent);
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
