package hashscript;

import org.rspeer.ui.Log;

import java.util.Collection;

public class IdleNode extends HashNode {
    @Override
    public Collection<StatusKey> getKeys() {
        return null;
    }

    @Override
    public int execute() {
        Log.info("Idling...");
        return 0;
    }
}
