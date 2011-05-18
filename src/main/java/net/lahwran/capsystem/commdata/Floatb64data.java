/**
 * 
 */
package net.lahwran.capsystem.commdata;

/**
 * @author lahwran
 *
 */
public class Floatb64data extends Commdata<Float> {

    protected final Float data;

    @Override
    public Float decoded()
    {
        return data;
    }

    @Override
    public String encoded()
    {
        return "base sixty four."; //B64 ENCODE HERE
    }

    public Floatb64data(String encoded)
    {
        this.data = 0.0f; // B64 DECODE HERE
    }

    public Floatb64data(Float data)
    {
        this.data = data;
    }

    static String stypeChar()
    {
        return "g";
    }

    @Override
    public String typeChar()
    {
        return stypeChar();
    }
}
