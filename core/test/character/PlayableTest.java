package character;

import com.linux.stw.character.Playable;
import com.linux.stw.util.factory.HeroFactory;
import com.linux.stw.util.factory.HeroType;
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
        Playable GNU = HeroFactory.createHero(HeroType.GNU, 1);

        Assert.assertNotNull(GNU);
    }


}