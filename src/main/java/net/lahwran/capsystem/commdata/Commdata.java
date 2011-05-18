/**
 * 
 */
package net.lahwran.capsystem.commdata;

/**
 * @author lahwran
 *
 */
public abstract class Commdata<T> {
    public abstract T decoded();
    public abstract String encoded();
    public abstract String typeChar();
    public static Commdata selectDecoder(String field)
    {
        String type = field.substring(0, 1);
        field = field.substring(1);
             if(type.equals(Stringdata.stypeChar()))
                 return new Stringdata(field);

        else if(type.equals(Floatb64data.stypeChar()))
                 return new Floatb64data(field);

        else if(type.equals(Floatdata.stypeChar()))
                 return new Floatdata(field);

        else if(type.equals(Intb64data.stypeChar()))
                 return new Intb64data(field);

        else if(type.equals(Intdata.stypeChar()))
                 return new Intdata(field);

        else if(type.equals(Booldata.stypeChar()))
                 return new Booldata(field);

        else
            // TODO: maybe just print to stderr? traceback is useless
            throw new IllegalArgumentException("unhandled type character '"+type+"'");
    }
}
