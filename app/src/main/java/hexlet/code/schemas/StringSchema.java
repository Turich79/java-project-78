package hexlet.code.schemas;

public class StringSchema extends BaseSchema {
    public StringSchema() {
    }

    public StringSchema minLength(int num) {
        addFilter("minLength", (value ->
                value instanceof String && ((String) value).length() >= num));
        return this;
    }

    public StringSchema contains(String subString) {
        addFilter("contains", (value ->
                value instanceof String && ((String) value).contains(subString)));
        return this;
    }

    public StringSchema required() {
        addFilter("required", (value ->
                value instanceof String && !((String) value).isEmpty()));
        return this;
    }
}
