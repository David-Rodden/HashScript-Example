package hashscript;

import java.util.Collection;

public abstract class HashNode {

    public abstract Collection<StatusKey> getKeys();

    public abstract int execute();
}
