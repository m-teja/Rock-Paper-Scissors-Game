package randomsideprojects.rockpaperscissorsgame;

import android.os.Handler;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import static randomsideprojects.rockpaperscissorsgame.GameActivity.getScreenHeight;

public class ItemMove {

    public ImageView image;
    public int spawnDelayTime;
    public int velocity;
    public boolean done = false;
    public RelativeLayout rl;

    public Handler move;

    public ItemMove(ImageView image, int spawnDelayTime, RelativeLayout rl) {
        this.image = image;
        this.spawnDelayTime = spawnDelayTime;
        this.rl = rl;
    }

    public void checkLose() {
        if (image.getY() > getScreenHeight()/1.5) {
            move.removeCallbacksAndMessages(null);
            rl.removeView(image);
            done = true;
        }
    }

    Runnable runnableStartMove = new Runnable() {
        @Override
        public void run() {
            image.setY(image.getY() + velocity);
            checkLose();

            if (!done) {
                move.postDelayed(runnableStartMove, 10);
            }
            else {
                move.removeCallbacksAndMessages(null);
            }
        }
    };

    public void startMove() {
        move = new Handler();
        velocity = spawnDelayTime/250;
        runnableStartMove.run();
    }
}
