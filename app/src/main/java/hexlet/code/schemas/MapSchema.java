package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {
    public MapSchema() {
    }

    public MapSchema required() {
        addFilter("required", (value ->
                value instanceof Map<?, ?> && !(value == null)));
        return this;
    }

    public MapSchema sizeof(int size) {
        addFilter("sizeof", (value -> value instanceof Map<?, ?> && ((Map<?, ?>) value).size() == size));
        return this;
    }

    public final MapSchema shape(Map<String, BaseSchema<String>> schemasMap) {
        addFilter("shape", map -> check((Map<String, BaseSchema<String>>) map, schemasMap));
        return this;
    }

    public final boolean check(Map<String, BaseSchema<String>> baseMap, Map<String, BaseSchema<String>> schemasMap) {
        for (var pair : schemasMap.entrySet()) {
            var key = pair.getKey();
            if (!pair.getValue().isValid(baseMap.get(key))) {
                return false;
            }
        }
        return true;
    }
}
