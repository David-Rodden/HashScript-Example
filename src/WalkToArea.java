import hashscript.HashNode;
import hashscript.StatusKey;
import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.commons.math.Random;
import org.rspeer.runetek.api.movement.Movement;

import java.util.Collection;
import java.util.Collections;

public class WalkToArea extends HashNode {
    @Override
    public Collection<StatusKey> getKeys() {
        return Collections.singleton(new StatusKey(false, true, false));
    }

    @Override
    public int execute() {
        if (!Movement.isRunEnabled() && Movement.getRunEnergy() >= 10) Movement.toggleRun(true);
        Movement.walkTo(Random.nextElement(StatusKey.getChopArea().getTiles()));
        Time.sleepUntil(() -> !Movement.isDestinationSet() || Movement.getDestinationDistance() < 5, Random.mid(4000, 5000));
        return Random.mid(300, 600);
    }
}
