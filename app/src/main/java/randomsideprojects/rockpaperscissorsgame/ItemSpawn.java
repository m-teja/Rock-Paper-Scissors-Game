package randomsideprojects.rockpaperscissorsgame;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import static randomsideprojects.rockpaperscissorsgame.GameActivity.PREFERENCES_ACTIVE;
import static randomsideprojects.rockpaperscissorsgame.GameActivity.getScreenWidth;

public class ItemSpawn {

    public Context con;

    public Handler spawnDelay = new Handler();
    public SharedPreferences active;
    public RelativeLayout rl;
    public ArrayList activeImageItem = new ArrayList<Item>();

    public int velocity = 7;

    public ItemSpawn(Context con) {
        this.con = con;
    }

    public ArrayList getActiveImageItem() {
        return activeImageItem;
    }

    public int genRandItem() {
        int rand = (int)Math.floor(Math.random() * 3);
        int id;
        switch (rand) {
            case 0:
                id = con.getResources().getIdentifier("rock", "drawable", con.getPackageName());
                return id;

            case 1:
                id = con.getResources().getIdentifier("paper", "drawable", con.getPackageName());
                return id;

            case 2:
                id = con.getResources().getIdentifier("scissors", "drawable", con.getPackageName());
                return id;

            default:
                id = con.getResources().getIdentifier("rock", "drawable", con.getPackageName());
                return id;
        }
    }

    public void startSpawn() {
        active = con.getSharedPreferences(PREFERENCES_ACTIVE, Context.MODE_PRIVATE);
        rl = ((Activity)con).findViewById(R.id.rlGame);
        runnableSpawn.run();
    }

    Runnable runnableSpawn = new Runnable() {
        @Override
        public void run() {
            Item item = new Item(genRandItem(), velocity, con, activeImageItem);
            item.init();
            item.genItem();
            item.startMove();

            activeImageItem.add(item);

            if (active.getBoolean("active", false)) {
                spawnDelay.postDelayed(runnableSpawn, 1000);
            }
            else {
                spawnDelay.removeCallbacksAndMessages(null);
            }

        }
    };
}
//TODO pass in object not ImageView, new class and put handler to move there