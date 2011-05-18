/**
 * 
 */
package net.lahwran.capsystem.commdata;

/**
 * @author lahwran
 *
 */
public class Intb64data extends Commdata<Integer> {

    protected final Integer data;

    @Override
    public Integer decoded()
    {
        return data;
    }

    @Override
    public String encoded()
    {
        return "base sixty four."; //B64 ENCODE HERE
    }

    public Intb64data(String encoded)
    {
        this.data = 0;  // B64 DECODE HERE
    }

    public Intb64data(Integer data)
    {
        this.data = data;
    }

    static String stypeChar()
    {
        return "j";
    }

    @Override
    public String typeChar()
    {
        return stypeChar();
    }
}
