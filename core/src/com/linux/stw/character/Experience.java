package com.linux.stw.character;

/**
 * Created by nahum on 08/02/17.
 */
public abstract class Experience
{
    protected Stats stats;

    protected int currentLevel;
    protected int amountExp;
    protected int nextLevel;

    public int getCurrentLevel() {
        return currentLevel;
    }

    public int getAmountExp() {
        return amountExp;
    }

    public int getNextLevel() {
        return nextLevel;
    }

    protected void levelUp()
    {
        currentLevel++;
        updateStats();
    }

    protected void updateStats() {}

    protected boolean checkLevelUp()
    {
        return amountExp >= nextLevel;
    }

    public void incrementExp(int valueExp)
    {
        assert (valueExp >= 0);

        amountExp += valueExp;

        if (checkLevelUp())
        {
            levelUp();
        }
    }

    @Override
    public String toString() {
        String s;

        s = "--- Exp ---\n";
        s += "Current Level: " + currentLevel +"\n";
        s += "Exp Amount: " + amountExp +"\n";
        s += "Next Exp: " + nextLevel +"\n";
        s += "----------\n";

        return s;
    }
}
