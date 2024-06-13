package my.junw.jlab2mapstruct.annotations.vo;

import lombok.Data;

@Data
public class UserEntity {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
}
