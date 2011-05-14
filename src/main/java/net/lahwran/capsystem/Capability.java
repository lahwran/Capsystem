/**
 * 
 */
package net.lahwran.capsystem;

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
