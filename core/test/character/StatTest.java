package character;

import com.linux.stw.character.*;
import org.junit.Assert;
import org.junit.Test;


public class StatTest
{
    @Test
    public void createEquilibrate()
    {
        Stats stat = new com.linux.stw.character.player.Equilibrate();

        Assert.assertEquals(100, stat.getHp());
        Assert.assertEquals(10, stat.getStr());
        Assert.assertEquals(3, stat.getLife());
        Assert.assertEquals(10, stat.getDef());
        Assert.assertEquals(1.0f, stat.getSpd(), 0);
    }

    @Test
    public void createSavage()
    {
        Stats stats = new com.linux.stw.character.player.Savage();

        Assert.assertEquals(100, stats.getHp());
        Assert.assertEquals(15, stats.getStr());
        Assert.assertEquals(3, stats.getLife());
        Assert.assertEquals(7, stats.getDef());
        Assert.assertEquals(1.25f, stats.getSpd(), 0);
    }

    @Test
    public void createDefensive()
    {
        Stats stats = new com.linux.stw.character.player.Defensive();

        Assert.assertEquals(125, stats.getHp());
        Assert.assertEquals(10, stats.getStr());
        Assert.assertEquals(3, stats.getLife());
        Assert.assertEquals(15, stats.getDef());
        Assert.assertEquals(0.75f, stats.getSpd(), 0);
    }

    @Test
    public void incrementHP()
    {
        Stats stats = new com.linux.stw.character.player.Equilibrate();

        stats.incrementHP(100);
        Assert.assertEquals(200, stats.getHp());

        try
        {
            stats.incrementHP(-100);
        }
        catch (AssertionError e)
        {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void incrementSTR()
    {
        Stats stats = new com.linux.stw.character.player.Equilibrate();

        stats.incrementSTR(100);
        Assert.assertEquals(110, stats.getStr());

        try
        {
            stats.incrementSTR(-100);

        }
        catch (AssertionError e)
        {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void incrementDEF()
    {
        Stats stats = new com.linux.stw.character.player.Savage();

        stats.incrementDEF(100);
        Assert.assertEquals(107.0f, stats.getDef(), 0);

        try
        {
            stats.incrementDEF(-100);
        }
        catch (AssertionError e)
        {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void incrementSPD()
    {
        Stats stats = new com.linux.stw.character.player.Equilibrate();

        stats.incrementSPD(0.24f);
        Assert.assertEquals(1.24f, stats.getSpd(), 0);

        try
        {
            stats.incrementSPD(-100);
        }
        catch (AssertionError e)
        {
            Assert.assertTrue(true);
        }
    }
}