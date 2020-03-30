import hashscript.HashNode;
import hashscript.StatusKey;
import org.rspeer.runetek.adapter.scene.SceneObject;
import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.commons.math.Random;
import org.rspeer.runetek.api.scene.SceneObjects;

import java.util.Collection;
import java.util.Collections;

public class ChopTree extends HashNode {
    @Override
    public Collection<StatusKey> getKeys() {
        return Collections.singleton(new StatusKey(false, true, true));
    }

    @Override
    public int execute() {
        final SceneObject tree = SceneObjects.getNearest("Tree");
        if (tree != null) {
            tree.interact("Chop down");
            Time.sleepUntil(() -> !SceneObjects.getNearest("Tree").getPosition().equals(tree.getPosition()), Random.mid(2000, 3000));
        }
        return Random.mid(1000, 2000);
    }

    @Override
    public String toString() {
        return "Chopping tree";
    }
}
