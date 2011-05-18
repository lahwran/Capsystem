/**
 * 
 */
package net.lahwran.capsystem;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lahwran
 *
 */
public class Capability {
    public final String type;
    public final String name;
    public final String args;
    public Capability(String type, String name, String args)
    {
        this.type = type;
        this.name = name;
        this.args = args;
    }

    public Capability(String cap)
    {
        Matcher match = Capsystem.cappattern.matcher(cap);
        if (!match.matches())
            throw new RuntimeException("String is not a capability: "+cap);
        this.type = match.group(1);
        this.name = match.group(2);
        this.args = match.group(3);
    }

    @Override
    public int hashCode()
    {
        return name.hashCode();
    }

    public String toString()
    {
        return type+name+ (args.length() > 0 ? ":"+args : "");
    }

    public boolean equals(Object o)
    {
        if (!(o instanceof Capability)) return false;
        Capability newo = (Capability)o;
        return newo.name.equals(this.name) && newo.type.equals(this.type) && newo.args.equals(this.args);
    }
}
