package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {
    public NumberSchema() {
    }

    public NumberSchema required() {
        addFilter("required", (value ->
                value instanceof Integer && !(value == null)));
        return this;
    }

    public NumberSchema positive() {
        var isNotNull = getMap().containsKey("required");
        if (isNotNull) {
            addFilter("positive", (value -> {
                var flag = value instanceof Integer;
                var intValue = (Integer) value;
                return (flag && intValue > 0);
            }));
        } else {
            addFilter("positive", (value -> {
                var flag = value instanceof Integer;
                var intValue = (Integer) value;
                return (flag && intValue > 0) || value == null;
            }));
        }
        return this;
    }

    public NumberSchema range(Integer min, Integer max) {
        addFilter("range", (value -> {
            var flag = value instanceof Integer;
            var intValue = ((Integer) value).intValue();
            return flag && intValue >= min && intValue <= max;
        }));
        return this;
    }
}
