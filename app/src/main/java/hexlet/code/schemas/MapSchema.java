package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {
    public MapSchema required() {
        addFilter("required", (value ->
                value instanceof Map<?, ?> && !(value == null)));
        return this;
    }

    public MapSchema sizeof(int size) {
        addFilter("sizeof", (value -> value instanceof Map<?, ?> && ((Map<?, ?>) value).size() == size));
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemasMap) {
        addFilter("shape", map -> check((Map<String, BaseSchema>) map, schemasMap));
        return this;
    }

    public boolean check(Map<String, BaseSchema> baseMap, Map<String, BaseSchema> schemasMap) {
        for (var pair : schemasMap.entrySet()) {
            var key = pair.getKey();
            if (!pair.getValue().isValid(baseMap.get(key))) {
                return false;
            }
        }
        return true;
    }
}
