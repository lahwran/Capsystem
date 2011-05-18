import net.lahwran.mcclient.capsystem.Sendable;

/**
 * 
 */

/**
 * @author lahwran
 *
 */
public class Chatsender implements Sendable {

    @Override
    public void send(String string)
    {
        ModLoader.getMinecraftInstance().g.a(string);
    }

}
