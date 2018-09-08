package randomsideprojects.rockpaperscissorsgame;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {
    public static final String PREFERENCES_ACTIVE = "active";

    public SharedPreferences active;
    public SharedPreferences.Editor activeEditor;
    public RelativeLayout rl;
    public Context con = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        active = getSharedPreferences(PREFERENCES_ACTIVE, MODE_PRIVATE);
        activeEditor = active.edit();
        activeEditor.putBoolean("active", true);
        activeEditor.apply();

        rl = findViewById(R.id.rlGame);

        ItemSpawn itemSpawn = new ItemSpawn(con);
        itemSpawn.startSpawn();

    }

    public void rock(View view) {

    }

    public void paper(View view) {
    }

    public void scissors(View view) {
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth(){
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    @Override
    public void onStart() {
        super.onStart();
        activeEditor.putBoolean("active", true);
        activeEditor.apply();
    }

    @Override
    public void onStop() {
        super.onStop();
        activeEditor.putBoolean("active", false);
        activeEditor.apply();
    }

    @Override
    public void onPause() {
        super.onPause();
        activeEditor.putBoolean("active", false);
        activeEditor.apply();
    }

}
