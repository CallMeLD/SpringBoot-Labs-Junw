package my.junw.jlab2.demo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(prefix = {"xx","yy"})
public class PersonE {

    private String xxName;

    private int yyAge;

}
