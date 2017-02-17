package com.linux.stw.character;

/**
 * Created by nahum on 08/02/17.
 */
public class LinealExperience extends Experience
{

    public LinealExperience()
    {
        this.currentLevel = 1;
        this.amountExp = 0;
        this.nextLevel = 100;
    }

    public LinealExperience(Stats stats, int currentLevel)
    {
        super();

        assert (currentLevel >= 1);

        this.currentLevel = currentLevel;
        this.amountExp = 0;
        this.nextLevel = 100;
        this.stats = stats;

        for (int i = 1; i < currentLevel; i++)
            updateStats();
    }

    @Override
    protected void updateStats()
    {
        super.updateStats();
        stats.incrementHP(5);
        stats.incrementSTR(5);
        stats.incrementDEF(5);
        stats.incrementSPD(0.05f);

        this.amountExp = 0;
        this.nextLevel += 100;
    }
}
