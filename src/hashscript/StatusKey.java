package hashscript;

import org.rspeer.runetek.api.component.tab.Equipment;
import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.runetek.api.movement.position.Area;
import org.rspeer.runetek.api.scene.Players;

import java.util.regex.Pattern;

public class StatusKey {
    private static Pattern axePattern;
    private static Area chopArea;
    private final boolean inventoryFull, hasAxe, inChopArea;

    static {
        axePattern = Pattern.compile(".*\\saxe");
        chopArea = Area.rectangular(3146, 3442, 3117, 3421);
    }

    StatusKey() {
        inventoryFull = Inventory.isFull();
        hasAxe = Equipment.contains(axePattern);
        inChopArea = chopArea.contains(Players.getLocal());
    }

    public StatusKey(final boolean inventoryFull, final boolean hasAxe, final boolean inChopArea) {
        this.inventoryFull = inventoryFull;
        this.hasAxe = hasAxe;
        this.inChopArea = inChopArea;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        return toString().equals(obj.toString());
    }

    @Override
    public String toString() {
        return String.format("inv: %b - axe: %b - area: %b", inventoryFull, hasAxe, inChopArea);
    }

    public static Area getChopArea() {
        return chopArea;
    }
}
