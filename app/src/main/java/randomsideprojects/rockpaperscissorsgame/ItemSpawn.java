package randomsideprojects.rockpaperscissorsgame;

import android.content.Context;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import static randomsideprojects.rockpaperscissorsgame.GameActivity.getScreenWidth;

public class ItemSpawn {

    public final int ITEM_SIZE = 64;
    public int spawnDelayTime = 1000;

    public RelativeLayout rl;
    public ItemGen itemGen;
    public Context con;
    public Handler spawnDelay;

    public ItemSpawn(ItemGen itemGen, RelativeLayout rl, Context con) {
        this.itemGen = itemGen;
        this.rl = rl;
        this.con = con;
    }

    public void addToLayout() {
        ImageView image = new ImageView(con);
        image.setImageResource(
                con.getResources().getIdentifier(itemGen.getItem(), "drawable", con.getPackageName())
        );
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        image.setLayoutParams(lp);
        image.setY(200);
        image.setX(getScreenWidth()/2 - ITEM_SIZE);
        rl.addView(image);

        startItemMove(image);
    }

    public void startItemMove(ImageView image) {
        ItemMove itemMove = new ItemMove(image, spawnDelayTime, rl);
        itemMove.startMove();

    }

    Runnable runnableSpawnDelay = new Runnable() {
        @Override
        public void run() {
            //Fill item queue to 10
            for (int i = itemGen.getQueueLength(); i < 10; i++) {
                itemGen.addItem();
            }
            addToLayout();

            spawnDelay.postDelayed(runnableSpawnDelay, spawnDelayTime);
        }
    };

    public void initSpawn() {
        spawnDelay = new Handler();
        runnableSpawnDelay.run();
    }
}
