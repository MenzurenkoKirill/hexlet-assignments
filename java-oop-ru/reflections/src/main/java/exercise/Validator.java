package exercise;

import java.lang.reflect.Field;

// BEGIN
import java.util.ArrayList;
import java.util.List;
class Validator {
    public static List<String> validate(Address adr) {
        List<String> defectiveFields = new ArrayList<>();
        Field[] fields = adr.getClass().getDeclaredFields();
        for (Field field : fields) {
            NotNull notNull = field.getAnnotation(NotNull.class);
            try {
                field.setAccessible(true);
                if (notNull != null && field.get(adr) == null) {
                    defectiveFields.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                throw  new RuntimeException(e);
            }
        }
        return  defectiveFields;
    }
}
// END
