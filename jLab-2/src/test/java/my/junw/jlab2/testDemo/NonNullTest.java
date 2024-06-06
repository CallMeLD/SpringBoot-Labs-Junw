package my.junw.jlab2.testDemo;

import lombok.NonNull;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * The @NonNull annotation is used to indicate that a method parameter or return value cannot be null.
 * @NonNull注释用于指示方法参数或返回值不能为 null。
 */
public class NonNullTest {


    @NonNull
    public String getNonNullString() {
        return "Hello";
    }

    /**
     * Explanation: The @NonNull annotation indicates that the getNonNullString() method returns a non-null value.
     * 说明： @NonNull注释指示 getNonNullString（） 方法返回非 null 值。
     */
    @Test
    public void testNonNull() {
        String nonNullString = getNonNullString();
        assertNotNull(nonNullString);
    }


}
