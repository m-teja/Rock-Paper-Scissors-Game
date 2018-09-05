package randomsideprojects.rockpaperscissorsgame;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class GameActivity extends AppCompatActivity {

    public RelativeLayout rl;
    public Context con = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        rl = findViewById(R.id.rlGame);

        ItemGen itemGen = new ItemGen();
        itemGen.initQueue();

        ItemSpawn itemSpawn = new ItemSpawn(itemGen, rl, con);

        itemSpawn.initSpawn();
    }
}
