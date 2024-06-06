package my.junw.jlab2.testDemo;

import lombok.Builder;
import my.junw.jlab2.demo.Person;
import my.junw.jlab2.demo.PersonB;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *  The @Builder annotation is used to automatically generate a builder class for a class.
 *  @Builder注释用于自动生成类的构建器类。
 */
public class BuilderTest {

    /**
     * Explanation: The @Builder annotation generates a builder class for the Person class, which can be used to create instances of the class in a fluent API style.
     * 说明：@Builder注释为 Person 类生成一个构建器类，该类可用于以流畅的 API 样式创建该类的实例。
     */
    @Test
    public void testBuilder() {
        PersonB person = PersonB.builder()
                .name("John")
                .age(30)
                .build();
        assertEquals("John", person.getName());
        assertEquals(30, person.getAge());
    }
}
