package my.junw.jlab2mapstruct.multiParamType.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

// 定义一个实体类SourceEntity，包含了各种类型的属性
@Data
public class SourceEntity {

    private int intValue;
    private Integer integerValue;
    private BigDecimal bigDecimalValue;
    private LocalDateTime localDateTimeValue;
    private Date dateValue;
    private MyEnum enumValue;
    private java.sql.Timestamp timestampValue;
    private String stringValue;
    private String ignore;

}
