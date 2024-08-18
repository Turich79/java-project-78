package hexlet.code.schemas;

public class NumberSchema {
    private boolean isNotNull;
    private boolean isPositive;
    private Integer min = Integer.MIN_VALUE;
    private Integer max = Integer.MAX_VALUE;

    public NumberSchema() {
    }

    public NumberSchema required() {
        this.isNotNull = true;
        return this;
    }

    public NumberSchema positive() {
        this.isPositive = true;
        return this;
    }

    public NumberSchema range(Integer min, Integer max) {
        this.min = min;
        this.max = max;
        return this;
    }

    public boolean isValid(Object data) {
        if (data == null) {
            if (isNotNull) {
                return false;
            } else {
                return true;
            }
        }

        int number;
        if (!(data instanceof Integer)) {
            number = Integer.getInteger((String) data);
        } else {
            number = ((Integer) data).intValue();
        }

        if (isPositive && number <= 0) {
            return false;
        }

        if (number < min || number > max) {
            return false;
        }

        return true;
    }


}
