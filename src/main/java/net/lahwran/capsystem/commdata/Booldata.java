/**
 * 
 */
package net.lahwran.capsystem.commdata;

/**
 * @author lahwran
 *
 */
public class Booldata extends Commdata<Boolean> {

    private final Boolean data;

    @Override
    public Boolean decoded()
    {
        return data;
    }

    @Override
    public String encoded()
    {
        return data ? "1" : "0";
    }

    public Booldata(String encoded)
    {
        this.data = encoded.equals("0");
    }

    public Booldata(Boolean data)
    {
        this.data = data;
    }

    static String stypeChar()
    {
        return "b";
    }

    @Override
    public String typeChar()
    {
        return stypeChar();
    }

}
