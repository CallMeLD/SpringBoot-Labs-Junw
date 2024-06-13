package my.junw.jlab2mapstruct.annotations;

import my.junw.jlab2mapstruct.annotations.context.MappingContext;
import my.junw.jlab2mapstruct.annotations.converted.UserMapper;
import my.junw.jlab2mapstruct.annotations.vo.UserDTO;
import my.junw.jlab2mapstruct.annotations.vo.UserEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnnotatinsTest {
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

    @Test
    public void testMapping() {
        // 创建实体对象
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setFirstName("John");
        userEntity.setLastName("Doe");
        userEntity.setEmail("john.doe@example.com");
        userEntity.setAddress("123 Main St");

        // 创建上下文
        MappingContext context = new MappingContext();

        // 执行映射
        UserDTO userDTO = UserMapper.INSTANCE.toDTO(userEntity, context);

        System.out.println(userDTO.toString());
        // 验证映射结果
        assertNull(userDTO.getId());
        assertEquals("John Smith", userDTO.getFullName());
        assertEquals(userEntity.getEmail(), userDTO.getEmail());
        // 确认忽略了 address 属性
    }

    @Test
    public void testInverseMapping() {
        // 创建 DTO 对象
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setFullName("John Smith");
        userDTO.setEmail("john.smith@example.com");

        // 创建上下文
        MappingContext context = new MappingContext();

        // 执行逆向映射
        UserEntity userEntity = UserMapper.INSTANCE.toEntity(userDTO, context);
        System.out.println(userEntity.toString());
        // 验证逆向映射结果
        assertNull(userEntity.getId());
        assertEquals("John Smith Smith", userEntity.getFirstName());
        assertNull(userEntity.getLastName());
        assertEquals(userDTO.getEmail(), userEntity.getEmail());
    }

    @Test
    public void testUpdateEntityFromDTO() {
        // 创建初始实体对象
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setFirstName("John");
        userEntity.setLastName("Doe");
        userEntity.setEmail("john.doe@example.com");
        userEntity.setAddress("123 Main St");

        // 创建 DTO 对象
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setFullName("Sun Smith");
        userDTO.setEmail("john.smith@example.com");

        // 创建上下文
        MappingContext context = new MappingContext();

        // 执行更新映射
        UserMapper.INSTANCE.updateEntityFromDTO(userDTO, userEntity, context);
        System.out.println(userEntity.toString());
        // 验证更新映射结果
        assertEquals(userDTO.getId(), userEntity.getId());
        assertEquals("Sun", userEntity.getFirstName());
        assertEquals("Doe", userEntity.getLastName());
        assertNotEquals(userDTO.getEmail(), userEntity.getEmail());
        // 确认忽略了 address 属性
    }



}
