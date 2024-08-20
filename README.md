### Hexlet tests and linter status:
[![Actions Status](https://github.com/Turich79/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/Turich79/java-project-78/actions)

[![Maintainability](https://api.codeclimate.com/v1/badges/0a6708c3d75afa2426c8/maintainability)](https://codeclimate.com/github/Turich79/java-project-78/maintainability)

[![Test Coverage](https://api.codeclimate.com/v1/badges/0a6708c3d75afa2426c8/test_coverage)](https://codeclimate.com/github/Turich79/java-project-78/test_coverage)

# Валидатор данных:
Валидатор данных – библиотека, с помощью которой можно проверять корректность любых данных. Подобных библиотек множество в каждом языке, так как практически все программы работают с внешними данными, которые нужно проверять на корректность. В первую очередь речь идет про данные форм заполняемых пользователями. За основу для проекта взята библиотека yup.


## Пример использования:

```
import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.BaseSchema;

Validator v = new Validator();

// методы библиотеки
- required() - делает обязательным ввод данных, если пустая строка или null, то возвращает false, иначе true
- positive() - проверка на положительность для чисел
- minLength() - добавляет ограничение на минимальную длину строки
- contains() - добавляет ограничение по содержимому строки
- range() - добавляет допустимый диапазон чисел, включая границы
- sizeof() - добавляет ограничение на размер Map

// строки
StringSchema schema = v.string().required();

schema.isValid("what does the fox say"); // true
schema.isValid(""); // false

// числа
NumberSchema schema = v.number().required().positive();

schema.isValid(-10); // false
schema.isValid(10); // true

// объект Map с поддержкой проверки структуры
Map<String, BaseSchema> schemas = new HashMap<>();
schemas.put("name", v.string().required());
schemas.put("age", v.number().positive());

MapSchema schema = v.map().sizeof(2).shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("name", "Kolya");
human1.put("age", 100);
schema.isValid(human1); // true

Map<String, Object> human2 = new HashMap<>();
human2.put("name", "");
human2.put("age", null);
schema.isValid(human1); // false
```
