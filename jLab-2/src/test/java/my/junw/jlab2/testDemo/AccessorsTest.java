package my.junw.jlab2.testDemo;

import my.junw.jlab2.demo.Person;
import my.junw.jlab2.demo.PersonC;
import my.junw.jlab2.demo.PersonD;
import my.junw.jlab2.demo.PersonE;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The @Accessors annotation is used to customize the generation of getters and setters for a class.
 * @Accessors注释用于自定义类的 getter 和 setter 的生成。
 */
public class AccessorsTest {

    /**
     * fluent
     * 默认为false，设置为true时，调用getter、setter方法时，可以省略掉get、set直接[.属性]
     */
    @Test
    public void testAccessorsFluent() {
        PersonC person = new PersonC();
        person.name("John");
        person.age(30);
        assertEquals("John", person.name());
        assertEquals(30, person.age());
    }

    /**
     *  chain
     * 默认为false，设置为true时，对应字段的 setter 方法调用后，会返回当前对象。
     * 且可实现链式编程
     */
    @Test
    public void testAccessorsChain() {
        PersonD person = new PersonD().setName("John").setAge(30);
        assertEquals("John", person.getName());
        assertEquals(30, person.getAge());
    }

    /**
     * prefix
     * 该属性是一个字符串数组，当该数组有值时，表示忽略字段中对应的前缀，生成对应的 getter 和 setter 方法。
     */
    @Test
    public void testPersonPrefix() {
        PersonE person = new PersonE();
        person.setName("John");
        person.setAge(30);

        assertEquals("PersonE(xxName=John, yyAge=30)", person.toString());
    }


}
