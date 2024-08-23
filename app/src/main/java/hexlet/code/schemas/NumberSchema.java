package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema() {
        System.out.println("NumberSchema constructor " + isRequired);
        addFilter("required", (value -> !isRequired || (isRequired && value != null)));
    }

    public NumberSchema positive() {
        addFilter("positive", (value -> !isRequired || (isRequired && value != null && value.intValue() > 0)));
        return this;
    }

    public NumberSchema range(Integer min, Integer max) {
        addFilter("range", (value -> value >= min && value <= max));
        return this;
    }
}
