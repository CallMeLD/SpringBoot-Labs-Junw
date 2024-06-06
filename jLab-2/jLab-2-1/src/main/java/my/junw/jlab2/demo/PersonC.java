package my.junw.jlab2.demo;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
public class PersonC {

    private String name;

    private int age;

}
