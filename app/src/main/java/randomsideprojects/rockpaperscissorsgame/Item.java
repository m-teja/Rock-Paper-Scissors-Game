package randomsideprojects.rockpaperscissorsgame;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import static randomsideprojects.rockpaperscissorsgame.GameActivity.getScreenHeight;
import static randomsideprojects.rockpaperscissorsgame.GameActivity.getScreenWidth;

public class Item {
    public final int ITEM_SIZE = 64;

    public int idImage;
    public int id;
    public int velocity;
    public ArrayList activeImageItem;

    public boolean delete = false;

    public Context con;
    public RelativeLayout rl;

    public ImageView image;
    public String itemType;
    public Handler moveDelay = new Handler();

    public Item(int idImage, int velocity, Context con, ArrayList activeImageItem) {
        this.idImage = idImage;
        this.velocity = velocity;
        this.con = con;
        this.activeImageItem = activeImageItem;
    }

    public int getidImage() {
        return idImage;
    }

    public void init() {
        rl = ((Activity)con).findViewById(R.id.rlGame);
        id = View.generateViewId();
    }

    public void genItem() {
        image = new ImageView(con);
        image.setImageResource(idImage);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        image.setLayoutParams(lp);
        image.setId(id);
        image.setX(getScreenWidth()/2 - ITEM_SIZE);
        image.setY(ITEM_SIZE);

        itemType = (String)image.getTag();
        rl.addView(image);

    }
    Runnable moveRunnable = new Runnable() {
        @Override
        public void run() {

            checkLose();
            image.setY(image.getY() + velocity);

            if (!delete) {
                moveDelay.postDelayed(moveRunnable, 15);
            }
            else {
                deleteItem();
            }
        }
    };

    public void startMove() {
        moveRunnable.run();
    }

    public void checkLose() {
        if (image.getY() > getScreenHeight()/1.5) {
            this.deleteItem();
        }
    }

    public void deleteItem() {
        delete = true;
        moveDelay.removeCallbacksAndMessages(null);
        rl.removeView(image);
        activeImageItem.remove(this);
    }
}
