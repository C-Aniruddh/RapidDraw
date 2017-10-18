package io.aniruddh.rapiddraw.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;

import io.aniruddh.rapiddraw.R;
import io.aniruddh.rapiddraw.helpers.GameHelper;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class BeginGame extends AppCompatActivity {

    public static GameHelper gh;
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);

        setContentView(R.layout.activity_begin_game);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        gh = new GameHelper(BeginGame.this);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/marker.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        TextView newLabelView = (TextView) findViewById(R.id.newLabelView);
        String set = setNewLabel();
        newLabelView.setText(set);

        TextView displayNumber = (TextView) findViewById(R.id.drawingCount);
        String dis = "Drawing " + gh.getPlayNumber() + " / 8";
        displayNumber.setText(dis);

        Button startGame = (Button) findViewById(R.id.startGameBtn);
        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gh.incrementPlayNumber();
                Intent startg = new Intent(BeginGame.this, InGameActivity.class);
                startg.putExtra("givenLabel", gh.getGivenLabel());
                startActivity(startg);
            }
        });
    }

    @Override
    public void onRestart() {
        super.onRestart();
        Intent restart = new Intent(BeginGame.this, BeginGame.class);
        startActivity(restart);
    }

    private String setNewLabel() {
        String random_label = gh.getRandomLabel();
        String set = "Draw \n" + random_label + "\n in under 25 seconds";
        return set;
    }

    @Override
    public void onBackPressed() {
        Intent mainMenu = new Intent(BeginGame.this, MenuActivity.class);
        startActivity(mainMenu);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}
