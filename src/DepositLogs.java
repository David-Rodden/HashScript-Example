import hashscript.HashNode;
import hashscript.StatusKey;
import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.commons.math.Random;
import org.rspeer.runetek.api.component.Bank;
import org.rspeer.runetek.api.component.tab.Inventory;

import java.util.Arrays;
import java.util.Collection;

public class DepositLogs extends HashNode {
    @Override
    public Collection<StatusKey> getKeys() {
        return Arrays.asList(new StatusKey(true, true, true), new StatusKey(true, true, false), new StatusKey(true, false, false), new StatusKey(true, false, true));
    }

    @Override
    public int execute() {
        if (!Bank.isOpen() && Bank.open()) {
            Bank.depositInventory();
            Time.sleepUntil(Inventory::isEmpty, Random.mid(2000, 2500));
        }
        return Random.mid(1000, 2000);
    }

    @Override
    public String toString() {
        return "Depositing logs";
    }
}
