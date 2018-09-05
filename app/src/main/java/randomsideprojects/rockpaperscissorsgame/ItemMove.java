package randomsideprojects.rockpaperscissorsgame;

import android.os.Handler;
import android.widget.ImageView;

public class ItemMove {

    public ImageView image;
    public int spawnDelayTime;
    public int velocity;

    public Handler move;

    public ItemMove(ImageView image, int spawnDelayTime) {
        this.image = image;
        this.spawnDelayTime = spawnDelayTime;
    }

    Runnable runnableStartMove = new Runnable() {
        @Override
        public void run() {
            image.setY(image.getY() + velocity);

            move.postDelayed(runnableStartMove, 10);
        }
    };

    public void startMove() {
        move = new Handler();
        velocity = spawnDelayTime/250;
        runnableStartMove.run();
    }
}
