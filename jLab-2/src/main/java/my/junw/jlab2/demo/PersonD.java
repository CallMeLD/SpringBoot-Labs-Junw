package my.junw.jlab2.demo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PersonD {

    private String name;

    private int age;

}
