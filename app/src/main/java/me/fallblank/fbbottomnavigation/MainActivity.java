package me.fallblank.fbbottomnavigation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import me.fallblank.bottombar.FBBottomBar;
import me.fallblank.bottombar.FBTab;

public class MainActivity extends AppCompatActivity {


    private FBBottomBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"clicked",Toast.LENGTH_LONG).show();
            }
        };

        mBottomBar = (FBBottomBar) findViewById(R.id.bottom_bar);

        FBTab tab01 = new FBTab(getApplicationContext(),R.drawable.ic_favorites, "tab01",listener);
        FBTab tab02 =new FBTab(getApplicationContext(),R.drawable.ic_friends, "tab02",listener);
        FBTab tab03 =new FBTab(getApplicationContext(),R.drawable.ic_nearby, "tab03",listener);

//        tab01.setShowTitle(false);
//        tab02.setShowTitle(false);
//        tab03.setShowTitle(false);

        mBottomBar.addTabs(tab01,tab02,tab03);
    }
}
