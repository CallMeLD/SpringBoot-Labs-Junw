package my.junw.jlab2.testDemo;

import my.junw.jlab2.demo.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The @Data annotation is used to automatically generate getters, setters, and a toString() method for a class.
 * @Data注解用于自动生成类的 getter、setter 和 toString（） 方法。
 */
public class TestData {

    /**
     * Explanation: The @Data annotation generates getters and setters for the name and age fields,
     *      as well as a toString() method that returns a string representation of the object.
     * 说明：@Data注释为名称和年龄字段生成 getter 和 setter，以及返回对象的字符串表示形式的 toString（） 方法。
     */
    @Test
    public void testPerson() {
        Person person = new Person();
        person.setName("John");
        person.setAge(30);

        assertEquals("Person(name=John, age=30)", person.toString());
    }

}
