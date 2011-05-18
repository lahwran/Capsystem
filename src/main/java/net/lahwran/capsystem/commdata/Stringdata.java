/**
 * 
 */
package net.lahwran.capsystem.commdata;

/**
 * @author lahwran
 *
 */
public class Stringdata extends Commdata<String> {

    private final String data;

    @Override
    public String decoded()
    {
        return data;
    }

    @Override
    public String encoded()
    {
        return data;
    }

    public Stringdata(String data)
    {
        this.data = data;
    }

    static String stypeChar()
    {
        return "t";
    }

    @Override
    public String typeChar()
    {
        return stypeChar();
    }
}
