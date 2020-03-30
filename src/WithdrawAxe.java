import hashscript.HashNode;
import hashscript.StatusKey;
import org.rspeer.runetek.adapter.Interactable;
import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.commons.math.Random;
import org.rspeer.runetek.api.component.Bank;
import org.rspeer.runetek.api.component.tab.Equipment;
import org.rspeer.runetek.api.component.tab.Inventory;

import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Pattern;

public class WithdrawAxe extends HashNode {
    private final Pattern axePattern;

    WithdrawAxe() {
        axePattern = Pattern.compile("Bronze axe");
    }

    @Override
    public Collection<StatusKey> getKeys() {
        return Arrays.asList(new StatusKey(false, false, false), new StatusKey(false, false, true));
    }

    @Override
    public int execute() {
        if (Inventory.contains(axePattern)) {
            final Interactable axe = Inventory.getFirst(axePattern);
            axe.interact("Wield");
            Time.sleepUntil(() -> Equipment.contains(axePattern), Random.mid(1000, 2000));
            return Random.mid(1000, 2000);
        }
        if (!Bank.isOpen()) {
            Bank.open();
            return Random.mid(1000, 2000);
        }
        if (Bank.contains(axePattern)) {
            Bank.withdraw(item -> axePattern.matcher(item.getName()).find(), 1);
            Time.sleepUntil(() -> Inventory.contains(item -> axePattern.matcher(item.getName()).find()), Random.mid(1000, 1500));
        }
        return Random.mid(1000, 2000);
    }

    @Override
    public String toString() {
        return "Withdrawing axe";
    }
}
