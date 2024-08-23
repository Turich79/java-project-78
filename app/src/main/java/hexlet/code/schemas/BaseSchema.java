package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    private final Map<String, Predicate<T>> mapOfRules = new HashMap<>();
    protected boolean isRequired;

    protected final void addFilter(String key, Predicate<T> value) {
        mapOfRules.put(key, value);
    }

    public final boolean isValid(T data) {
        if (data == null) {
            return mapOfRules.get("required").test(data);
        }

        var entries = mapOfRules.entrySet();
        for (var entry : entries) {
            var flag = entry.getValue().test(data);
            if (!flag) {
                return false;
            }
        }
        return true;
    }
}
