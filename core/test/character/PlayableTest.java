package character;

import com.linux.stw.character.Playable;
import com.linux.stw.util.factory.ExperienceType;
import com.linux.stw.util.factory.HeroType;
import com.linux.stw.util.factory.PlayableFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nahum on 08/02/17.
 */
public class PlayableTest
{

    @Test
    public void createHero()
    {
        Playable GNU = PlayableFactory.createHero(HeroType.GNU, ExperienceType.LINEAL, 1);

        Assert.assertNotNull(GNU);
    }


}