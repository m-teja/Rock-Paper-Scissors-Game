package randomsideprojects.rockpaperscissorsgame;

import android.content.Context;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class ItemSpawn {

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
        image.setX(200);
        image.setY(200);
        rl.addView(image);

        startItemMove(image);
    }

    public void startItemMove(ImageView image) {
        ItemMove itemMove = new ItemMove(image, spawnDelayTime);
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
