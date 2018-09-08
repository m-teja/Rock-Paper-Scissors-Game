package randomsideprojects.rockpaperscissorsgame;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Arrays;

public class GameActivity extends AppCompatActivity {
    public static final String PREFERENCES_ACTIVE = "active";

    public SharedPreferences active;
    public SharedPreferences.Editor activeEditor;
    public RelativeLayout rl;
    public Context con = this;

    public ItemSpawn itemSpawn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        active = getSharedPreferences(PREFERENCES_ACTIVE, MODE_PRIVATE);
        activeEditor = active.edit();
        activeEditor.putBoolean("active", true);
        activeEditor.apply();

        rl = findViewById(R.id.rlGame);

        itemSpawn = new ItemSpawn(con);
        itemSpawn.startSpawn();

    }

    public void rock(View view) {
        if ((itemSpawn.getActiveImageItem().size() != 0)) {
            Item item = (Item)(itemSpawn.getActiveImageItem().get(0));
            int check = getResources().getIdentifier("scissors", "drawable", getPackageName());

            if (check == item.getidImage()) {
                item.deleteItem();
            }
        }
    }

    public void paper(View view) {
        if ((itemSpawn.getActiveImageItem().size() != 0)) {
            Item item = (Item)(itemSpawn.getActiveImageItem().get(0));
            int check = getResources().getIdentifier("rock", "drawable", getPackageName());

            if (check == item.getidImage()) {
                item.deleteItem();
            }
        }
    }

    public void scissors(View view) {
        if ((itemSpawn.getActiveImageItem().size() != 0)) {
            Item item = (Item)(itemSpawn.getActiveImageItem().get(0));
            int check = getResources().getIdentifier("paper", "drawable", getPackageName());

            if (check == item.getidImage()) {
                item.deleteItem();
            }
        }
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
