package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema() {
        addFilter("required", (value ->
                !isRequired || value != null)
        );

    }

    public NumberSchema required() {
        isRequired = true;
        return this;
    }

    public NumberSchema positive() {
        addFilter("positive", (value -> !isRequired || value > 0));
        return this;
    }

    public NumberSchema range(Integer min, Integer max) {
        addFilter("range", (value -> value >= min && value <= max));
        return this;
    }
}
