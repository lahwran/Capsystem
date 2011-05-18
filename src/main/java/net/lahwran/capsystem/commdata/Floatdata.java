/**
 * 
 */
package net.lahwran.capsystem.commdata;

/**
 * @author lahwran
 *
 */
public class Floatdata extends Floatb64data {

    @Override
    public String encoded()
    {
        return ""+data;
    }

    public Floatdata(String encoded)
    {
        super(Float.parseFloat(encoded));
    }

    static String stypeChar()
    {
        return "f";
    }

    @Override
    public String typeChar()
    {
        return stypeChar();
    }
}
