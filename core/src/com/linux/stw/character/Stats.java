package com.linux.stw.character;

/**
 * Created by nahum on 08/02/17.
 */
public abstract class Stats
{
    protected static final short LIFE_BASE = 3;
    protected static final float SPD_ATTACK_BASE = 1.0f;
    protected static final int HP_BASE = 100;
    protected static final int STR_BASE = 10;
    protected static final int DEF_BASE = 10;


    protected short life;
    protected float spd_attack;
    protected int hp, str, def, score;

    public short getLife() {
        return life;
    }


    public float getSpd() {
        return spd_attack;
    }

    public int getHp() {
        return hp;
    }

    public int getStr() {
        return str;
    }

    public int getDef() {
        return def;
    }

    public void setScore(int s) { score = s;}
    public int getScore() { return score; }

    public void incrementHP(int incLife)
    {

        assert (incLife >= 0);
        hp += incLife;
    }

    public void incrementSTR(int incSTR)
    {
        assert (incSTR >= 0);
        str += incSTR;
    }

    public void incrementSPD(float incSPD)
    {
        assert (incSPD >= 0);
        spd_attack += incSPD;
    }

    public void incrementDEF(int incDEF)
    {
        assert (incDEF >= 0);
        def += incDEF;
    }

    @Override
    public String toString() {
        String s;
        s = "--- Stats ---\n";
        s += "Life: " + life +"\n";
        s += "HP: " + hp +"\n";
        s += "STR: " + str +"\n";
        s += "DEF: " + def +"\n";
        s += "SPD: " + spd_attack +"\n";
        s += "Score: " + score + "\n";
        s += "-------------\n";

        return s;
    }
}
