package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    private Map<String, Predicate<Object>> map = new HashMap<>();

    protected void addFilter(String key, Predicate<Object> value) {
        map.put(key, value);
    }

    public boolean isValid(Object data) {
        var entries = map.entrySet();
        for (var entry : entries) {
//            System.out.println("Key:"+entry.getKey());
//            System.out.println("Value:"+entry.getValue());
            var flag = entry.getValue().test(data);
            if (!flag) {
                return false;
            }
        }
        return true;
    }

    public Map<String, Predicate<Object>> getMap() {
        return map;
    }
}
