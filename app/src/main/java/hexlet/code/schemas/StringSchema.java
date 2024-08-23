package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {
    public StringSchema() {
        addFilter("required", (value ->
                !isRequired || (isRequired && value != null && !"".equals(value))));
    }

    public StringSchema minLength(int num) {
        addFilter("minLength", (value -> value.length() >= num));
        return this;
    }

    public StringSchema contains(String subString) {
        addFilter("contains", (value -> value.contains(subString)));
        return this;
    }

    public StringSchema required() {
        isRequired = true;
        return this;
    }
}
