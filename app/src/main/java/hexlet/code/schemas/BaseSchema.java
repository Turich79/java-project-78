package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    private final Map<String, Predicate<T>> mapOfRules = new LinkedHashMap<>();
    protected boolean isRequired;

    protected final void addFilter(String key, Predicate<T> value) {
        mapOfRules.put(key, value);
    }

    public final boolean isValid(T data) {
        var flgRequired = mapOfRules.get("required").test(data);

        if (!flgRequired && !isRequired) {
            return true;
        }

        try {
            return mapOfRules.values().stream()
                    .allMatch(predicate -> predicate.test(data));
        } catch (ClassCastException e) {
            return false;
        }
    }
}
