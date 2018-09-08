package randomsideprojects.rockpaperscissorsgame;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import static randomsideprojects.rockpaperscissorsgame.GameActivity.getScreenWidth;

public class Item {
    public final int ITEM_SIZE = 64;

    public int idImage;
    public int id;
    public int velocity;
    public Context con;
    public RelativeLayout rl;

    public ImageView image;

    public Item(int idImage, int velocity, Context con) {
        this.idImage = idImage;
        this.velocity = velocity;
        this.con = con;
    }


    public void genItem() {
        rl = ((Activity)con).findViewById(R.id.rlGame);
        id = View.generateViewId();

        image = new ImageView(con);
        image.setImageResource(idImage);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        image.setLayoutParams(lp);
        image.setId(id);
        image.setX(getScreenWidth()/2 - ITEM_SIZE);
        image.setY(200);

        rl.addView(image);

    }

    public void move() {

    }

    public void deleteItem() {

    }
}
