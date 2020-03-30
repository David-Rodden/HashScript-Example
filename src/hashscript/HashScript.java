package hashscript;

import org.rspeer.script.Script;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class HashScript extends Script {
    private Map<StatusKey, HashNode> nodeMap;

    protected void submit(final HashNode... nodes) {
        nodeMap = Arrays.stream(nodes).flatMap(n -> n.getKeys().stream().map(k -> new AbstractMap.SimpleEntry<>(k, n))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }


    @Override
    public int loop() {
        return nodeMap.getOrDefault(new StatusKey(), new IdleNode()).execute();
    }
}
