package my.junw.jlab2mapstruct.annotations.converted;

import my.junw.jlab2mapstruct.annotations.context.MappingContext;
import my.junw.jlab2mapstruct.annotations.vo.UserDTO;
import my.junw.jlab2mapstruct.annotations.vo.UserEntity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

/**
 * @BeanMapping：在 toDTO 和 updateEntityFromDTO 方法中使用，结合 ignoreByDefault = true 参数，用于忽略未显式映射的属性。这确保了只有明确映射的属性会被映射，从而避免了不必要的属性映射。
 *
 * @MappingTarget：在 updateEntityFromDTO 方法中使用，用于指示目标对象是现有对象，应在其基础上更新字段。
 *
 * @BeforeMapping 和 @AfterMapping：在映射前后执行额外操作。
 *
 * @Context：用于传递上下文信息，便于在映射过程中使用共享数据或方法。
 *
 * @InheritConfiguration 和 @InheritInverseConfiguration：用于继承其他映射方法的配置，以简化映射定义。
 *
 * @Named：定义自定义的映射方法。
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    // 基本映射
    @Mapping(source = "firstName", target = "fullName", qualifiedByName = "fullNameMapping")
    @Mapping(source = "email", target = "email")
    @BeanMapping(ignoreByDefault = true) // 使用 @BeanMapping 忽略未映射的属性
    UserDTO toDTO(UserEntity userEntity, @Context MappingContext context);

    // 逆向映射
    @InheritInverseConfiguration
    UserEntity toEntity(UserDTO userDTO, @Context MappingContext context);

    // 更新目标对象
    @BeanMapping(ignoreByDefault = true) // 使用 @BeanMapping 忽略未映射的属性
    @Mapping(target = "firstName", expression = "java(userDTO.getFullName().split(\" \")[0])")
    @Mapping(target = "lastName", ignore = true)
    void updateEntityFromDTO(UserDTO userDTO, @MappingTarget UserEntity userEntity, @Context MappingContext context);

    // 映射前的操作
    @BeforeMapping
    default void beforeMapping(@MappingTarget UserEntity userEntity, @Context MappingContext context) {
        // 在映射前执行一些操作
        System.out.println("BeforeMapping -->" + context.pContext());
    }

    // 映射后的操作
    @AfterMapping
    default void afterMapping(@MappingTarget UserDTO userDTO, @Context MappingContext context) {
        // 在映射后执行一些操作
        System.out.println("AfterMapping -->" + context.pContext());
    }

    // 使用自定义方法进行映射
    @Named("fullNameMapping")
    default String fullNameMapping(String firstName) {
        return firstName + " Smith";
    }

}

