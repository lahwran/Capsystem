/**
 * 
 */
package net.lahwran.capsystem.commdata;

/**
 * @author lahwran
 *
 */
public class Intdata extends Intb64data {

    @Override
    public String encoded()
    {
        return ""+data;
    }

    public Intdata(String encoded)
    {
        super(Integer.parseInt(encoded));
    }

    static String stypeChar()
    {
        return "i";
    }

    @Override
    public String typeChar()
    {
        return stypeChar();
    }
}
