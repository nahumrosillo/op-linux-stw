package character;

import com.linux.stw.character.hero.Equilibrate;
import com.linux.stw.character.Experience;
import com.linux.stw.character.LinealExperience;
import com.linux.stw.character.Stats;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nahum on 08/02/17.
 */
public class ExperienceTest
{

    @Test
    public void createExperienceLineal()
    {
        final short LEVEL = 1;

        Stats stats = new Equilibrate();
        Experience experience = new LinealExperience(stats, LEVEL);

        Assert.assertEquals(0, experience.getAmountExp());
        Assert.assertEquals(LEVEL, experience.getCurrentLevel());
        Assert.assertEquals(100 , experience.getNextLevel());
    }

    @Test
    public void levelUpLineal()
    {
        final short LEVEL = 5;

        Stats stats = new Equilibrate();
        Experience experience = new LinealExperience(stats, LEVEL);

        Assert.assertEquals(0, experience.getAmountExp());
        Assert.assertEquals(LEVEL, experience.getCurrentLevel());
        Assert.assertEquals(500 , experience.getNextLevel());

        try
        {
            experience.incrementExp(-555);
        }
        catch (AssertionError e)
        {
            Assert.assertTrue("unsigned value", true);
        }

        experience.incrementExp(1000);
        Assert.assertEquals(0, experience.getAmountExp());
        Assert.assertEquals(LEVEL + 1, experience.getCurrentLevel());
        Assert.assertEquals(600 , experience.getNextLevel());
    }
}
