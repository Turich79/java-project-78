package hexlet.code.schemas;

public class StringSchema {
    private int minL = 0;
    private String contString = "";
    private boolean isNotNull;

    public StringSchema() {
    }

    public StringSchema required() {
        this.isNotNull = true;
        return this;
    }

    public StringSchema minLength(int num) {
        this.minL = num;
        return this;
    }

    public StringSchema contains(String string) {
        this.contString = string;
        return this;
    }

    public boolean isValid(String data) {
        if (isNotNull && (data == null || data.isEmpty())) {
            return false;
        }
        if (minL > 0 && data.length() < minL) {
            return false;
        }
        if (!contString.isEmpty() && !data.contains(contString)) {
            return false;
        }

        return true;
    }
}
