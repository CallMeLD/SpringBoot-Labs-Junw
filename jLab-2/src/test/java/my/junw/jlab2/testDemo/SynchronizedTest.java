package my.junw.jlab2.testDemo;

import lombok.Synchronized;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The @Synchronized annotation is used to automatically synchronize a method or block of code.
 * @Synchronized注释用于自动同步方法或代码块。
 */
public class SynchronizedTest {

    private int counter = 0;

    @Synchronized
    public void incrementCounter() {
        counter++;
    }

    /**
     * Explanation: The @Synchronized annotation synchronizes the incrementCounter() method, ensuring that only one thread can execute it at a time.
     * 说明：@Synchronized注解同步 incrementCounter（） 方法，确保一次只能有一个线程执行它。
     */
    @Test
    public void testSynchronized() {
        incrementCounter();
        assertEquals(1, counter);
    }

}
