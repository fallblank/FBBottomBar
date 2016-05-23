package me.fallblank.fbbottomnavigation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    private FBBottomBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomBar = (FBBottomBar) findViewById(R.id.bottom_bar);
        mBottomBar.addTabs(new FBTab(R.drawable.ic_favorites, "tab01"),
                new FBTab(R.drawable.ic_friends, "tab02"),
                new FBTab(R.drawable.ic_nearby, "tab03"),
                new FBTab(R.drawable.ic_recents, "tab04"),
                new FBTab(R.drawable.ic_restaurants, "tab05"));
    }
}
