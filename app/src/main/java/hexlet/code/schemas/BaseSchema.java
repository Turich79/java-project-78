package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    private final Map<String, Predicate<Object>> mapOfRules = new HashMap<>();

    protected final void addFilter(String key, Predicate<Object> value) {
        mapOfRules.put(key, value);
    }

    public final boolean isValid(Object data) {
        var entries = mapOfRules.entrySet();
        for (var entry : entries) {
            var flag = entry.getValue().test(data);
            if (!flag) {
                return false;
            }
        }
        return true;
    }

    public Map<String, Predicate<Object>> getMapOfRules() {
        return mapOfRules;
    }
}
