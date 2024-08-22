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
        var isNotNull = mapOfRules.get("required").test(data);
        System.out.println("isNotNull" + isNotNull + ",isRequired" + isRequired);
        if (!isRequired && !isNotNull) {
            return true;
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

    public final Map<String, Predicate<T>> getMapOfRules() {
        return mapOfRules;
    }
}
