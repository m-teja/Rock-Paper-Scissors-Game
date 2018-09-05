package randomsideprojects.rockpaperscissorsgame;
import java.util.ArrayList;

public class ItemGen {

    public ArrayList itemQueue = new ArrayList<String>();

    public ItemGen() {

    }

    public void initQueue() {
        for (int i = 0; i < 10; i++) {
            addItem();
        }
    }

    public int getQueueLength() {
        return itemQueue.size();
    }

    public String getItem() {
        return (String) itemQueue.remove(0);
    }

    public String genRandomItem() {
        int randResult = (int)(Math.floor((Math.random() * 3)));

        switch (randResult) {
            case 0:
                return "rock";

            case 1:
                return "paper";

            case 2:
                return "scissors";

            default:
                return "rock";
        }
    }

    public void addItem() {
        itemQueue.add(genRandomItem());
    }
}