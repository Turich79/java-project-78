package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema<K, V> extends BaseSchema<Map<K, V>> {
    public MapSchema() {
        addFilter("required", (value -> value != null));
    }

    public MapSchema sizeof(int size) {
        addFilter("sizeof", (value -> value.size() == size));
        return this;
    }

    public void shape(Map<String, BaseSchema<V>> schemas) {
        if (schemas != null) {
            schemas.keySet()
                    .forEach(key -> addFilter("shape:" + key,
                            map -> schemas.get(key).isValid(map.get(key))));
        }
    }

    public MapSchema<K, V> required() {
        isRequired = true;
        return this;
    }
}
