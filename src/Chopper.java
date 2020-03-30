import hashscript.HashScript;
import org.rspeer.script.ScriptMeta;

@ScriptMeta(name = "HashChopper", developer = "Dungeonqueer", desc = "Testing of Hash implementation")
public class Chopper extends HashScript {
    @Override
    public void onStart() {
        submit(new ChopTree(), new DepositLogs(), new WithdrawAxe(), new WalkToArea());
    }
}
