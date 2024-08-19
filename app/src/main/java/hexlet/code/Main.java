package hexlet.code;

public class Main {
    public static void main(String[] args) {
        testInt();
//        testString();
    }

    public static void testInt() {
        var v = new Validator();

        var schema = v.number();

        System.out.println("1." + schema.isValid(5)); // true

// Пока не вызван метод required(), null считается валидным
        System.out.println("2." + schema.isValid(null)); // true
        System.out.println("3." + schema.positive().isValid(null)); // true
        schema.required();

        System.out.println("4." + schema.isValid(null)); // false
        System.out.println("5." + schema.isValid(10)); // true

// Потому что ранее мы вызвали метод positive()
        System.out.println("6." + schema.isValid(-10)); // false
    }

    public static void testString() {
        var v = new Validator();

        var schema = v.string();

// Пока не вызван метод required(), null и пустая строка считаются валидным
        System.out.println("1." + schema.isValid("")); // true
        System.out.println("2." + schema.isValid(null)); // true

        schema.required();

        System.out.println("3." + schema.isValid(null)); // false
        System.out.println("4." + schema.isValid("")); // false
        System.out.println("5." + schema.isValid("what does the fox say")); // true
        System.out.println("6." + schema.isValid("hexlet")); // true

        System.out.println("7." + schema.contains("wh").isValid("what does the fox say")); // true
        System.out.println("8." + schema.contains("what").isValid("what does the fox say")); // true
        System.out.println("9." + schema.contains("whatthe").isValid("what does the fox say")); // false

        System.out.println("10." + schema.isValid("what does the fox say")); // false
        // Здесь уже false, так как добавлена еще одна проверка contains("whatthe")

        // Если один валидатор вызывался несколько раз
        // то последний имеет приоритет (перетирает предыдущий)
        var schema1 = v.string();
        System.out.println("11." + schema1.minLength(10).minLength(4).isValid("Hexlet")); // true
    }
}
