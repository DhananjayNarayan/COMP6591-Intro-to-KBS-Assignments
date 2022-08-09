package cli;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CliMemory {

    private static CliMemory cliMemory;
    private final Map<String, String> memory = new HashMap<>();

    public static CliMemory getInstance() {
        if (Objects.isNull(cliMemory)) {
            cliMemory = new CliMemory();
        }
        return cliMemory;
    }

    public void put(String key, String value) {
        memory.put(key, value);
    }

    public String get(String key) {
        return memory.get(key);
    }

    public boolean has(String key) {
        return memory.containsKey(key);
    }
}
