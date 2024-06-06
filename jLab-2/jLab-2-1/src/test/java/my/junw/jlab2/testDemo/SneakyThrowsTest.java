package my.junw.jlab2.testDemo;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * The @SneakyThrows annotation is used to automatically wrap a method or block of code in a try-catch block that rethrows exceptions as runtime exceptions.
 * @SneakyThrows注释用于自动将方法或代码块包装在 try-catch 块中，该块将异常作为运行时异常重新抛出。
 */
public class SneakyThrowsTest {

    /**
     * 当你想编写抛出检查型异常的代码，但不想在方法签名中声明这些异常时，可以使用 @SneakyThrows。
     * 将 @SneakyThrows 注解放置在抛出检查型异常的方法或代码块上。
     */
    @SneakyThrows
    public void throwException() {
        throw new IOException("Example exception");
    }

    @Test
    public void testSneakyThrows() {
        try {
            throwException();
            fail("Expected exception to be thrown");
        } catch (RuntimeException e) {
            assertEquals("java.io.IOException: Example exception", e.getMessage());
        }
    }
}
