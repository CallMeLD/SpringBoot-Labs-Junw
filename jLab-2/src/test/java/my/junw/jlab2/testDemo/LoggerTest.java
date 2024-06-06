package my.junw.jlab2.testDemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * The @Slf4j annotation is used to automatically generate a logger instance for a class.
 * @Slf4j注释用于自动生成类的记录器实例。
 */
@Slf4j
public class LoggerTest {

    /**
     * Explanation: The @Slf4j annotation generates a logger instance for the class, which can be used to log messages.
     * 说明：@Slf4j注释为类生成一个记录器实例，该实例可用于记录消息。
     */
    @Test
    public void testLogger() {
        log.info("Hello, world!");
        // Verify that the log message is printed
    }

}
