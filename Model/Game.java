package Model;

import java.util.ArrayList;
import java.util.Random;

public class Game {

    private ArrayList<String> wordPool = new ArrayList<String>();
    
    private String target;
    private String input;

    private int health;
    private int remainingLetters;

    public Game() {
        if (true) {
            wordPool.add("communication");
            wordPool.add("science");
            wordPool.add("programming");
            wordPool.add("language");
            wordPool.add("difficulty");
            wordPool.add("artificial");
            wordPool.add("intelligence");
            wordPool.add("attempts");
            wordPool.add("screenshot");
            wordPool.add("baseball");
            wordPool.add("windows");
            wordPool.add("learning");
            wordPool.add("electronics");
            wordPool.add("beautiful");
            wordPool.add("internet");
            wordPool.add("database");
            wordPool.add("organization");
            wordPool.add("application");
            wordPool.add("network");
            wordPool.add("friendly");
            wordPool.add("validation");
            wordPool.add("attempts");
            wordPool.add("statistics");
            wordPool.add("physics");
            wordPool.add("chemistry");
            wordPool.add("engineering");
            wordPool.add("school");
            wordPool.add("industry");
            wordPool.add("revolution");
            wordPool.add("progress");
            wordPool.add("characters");
            wordPool.add("heavily");
            wordPool.add("graphics");
        }
        input = "";
        health = 5;
        generateTarget();
        remainingLetters = target.length();
    }

    public void generateTarget() {       
        Random random = new Random();
        int size = wordPool.size();
        int index = random.nextInt(size);
        target = wordPool.get(index);
        for (int i = 0; i < target.length(); i++) {
            input += '.';
        }
    }

    public String getTarget() {
        return target;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public void reduceHealth() {
        health--;
    }

    public void reduceRemainingLetters() {
        remainingLetters--;
    }

    public int getHealth() {
        return health;
    }

    public int getRemainingLetters() {
        return remainingLetters;
    }
}
